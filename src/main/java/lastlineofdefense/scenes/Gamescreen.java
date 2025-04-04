package lastlineofdefense.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;
import lastlineofdefense.LastLineOfDefenseApp;
import lastlineofdefense.entities.borders.BorderBottom;
import lastlineofdefense.entities.bullet.Bullet;
import lastlineofdefense.entities.bunker.Bunker;
import lastlineofdefense.entities.mysterybox.MysteryBox;
import lastlineofdefense.entities.player.Player;
import lastlineofdefense.entities.soldier.SoldierGrid;
import lastlineofdefense.hud.scoreboard.Lives;
import lastlineofdefense.hud.scoreboard.Scoreboard;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class Gamescreen extends DynamicScene implements UpdateExposer, KeyListener {
    private LastLineOfDefenseApp app;
    private Player player;
    private SoldierGrid soldierGrid;
    private Scoreboard score;
    private Scoreboard highScore;

    private int nrOfBunkers = 4;

    private boolean escPressed = false;

    public Gamescreen(LastLineOfDefenseApp app) {
        this.app = app;
    }

    @Override
    public void setupScene() {
        setBackgroundAudio("audio/interstellar prod marijn.mp3");
        setBackgroundImage("backgrounds/RockBG.png");
    }

    @Override
    public void setupEntities() {

        player = new Player(app, this, new Coordinate2D(getWidth() / 2, getHeight() / 10 * 8));
        addEntity(player);

        score = new Scoreboard(new Coordinate2D(30, 15));
        score.displayScore();
        addEntity(score);

        highScore = new Scoreboard(new Coordinate2D(getWidth() - 225, 15));
        highScore.displayHighScore();
        addEntity(highScore);

        soldierGrid = new SoldierGrid(score, this, 3, 10, new Coordinate2D(100, getHeight() / 10 * 1), 80, 75, getWidth());
        addEntity(soldierGrid);

        int LivesStartX = 30;
        double LivesY = getHeight() - 55;
        int LivesSpacing = 40;
        int numberOfLives = player.getLives();
        for (int i = 0; i < numberOfLives; i++) {
            int livesX = LivesStartX + (i * LivesSpacing);
            addEntity(new Lives(new Coordinate2D(livesX, LivesY)));
        }

        for (int i = 0; i < nrOfBunkers; i++) {
            addEntity(new Bunker(new Coordinate2D(150 + i * 300, getHeight() / 10 * 6.5)));
        }

        var borderBottom = new BorderBottom(new Coordinate2D(0, getHeight() - 125));
        borderBottom.setWidth(getWidth());
        addEntity(borderBottom);
    }

    @Override
    public void explicitUpdate(long timestamp) {
        soldierGrid.update();
        soldierGrid.triggerLastRowShooting();

        if(escPressed) {
            app.setActiveScene(2);
            escPressed = false;
        }
    }

    public void createBullet(Coordinate2D location, double direction) {
        Bullet bullet = new Bullet(location, direction);
        addEntity(bullet);
    }

    public void createMysteryBox(Coordinate2D location) {
        MysteryBox mysterybox = new MysteryBox(score, location);
        addEntity(mysterybox);
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if (pressedKeys.contains(KeyCode.ESCAPE)) {
            escPressed = true;
        }
    }
}