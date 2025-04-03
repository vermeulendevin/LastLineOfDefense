package lastlineofdefense.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import lastlineofdefense.LastLineOfDefenseApp;
import lastlineofdefense.entities.bullet.Bullet;
import lastlineofdefense.entities.bunker.Bunker;
import lastlineofdefense.entities.mysterybox.MysteryBox;
import lastlineofdefense.entities.player.Player;
import lastlineofdefense.hud.scoreboard.Lives;
import lastlineofdefense.hud.scoreboard.Scoreboard;

public class Gamescreen extends DynamicScene {
    private LastLineOfDefenseApp app;
    private Player player;

    private int nrOfBunkers = 4;

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

        var Score = new Scoreboard(new Coordinate2D(30, 15));
        Score.displayScore();
        addEntity(Score);

        var HighScore = new Scoreboard(new Coordinate2D(getWidth() - 225, 15));
        HighScore.displayHighScore();
        addEntity(HighScore);

        var mysterybox = new MysteryBox(new Coordinate2D(200, getHeight() / 10 * 8));
        addEntity(mysterybox);


        int LivesStartX = 30;
        double LivesY = getHeight()-55;
        int LivesSpacing = 40;
        int numberOfLives = 3;      //TODO: change to Player.getLives()
        for (int i = 0; i < numberOfLives; i++) {
            int livesX = LivesStartX + (i * LivesSpacing);
            addEntity(new Lives(new Coordinate2D(livesX, LivesY)));
        }

        for(int i = 0; i < nrOfBunkers; i++) {
            addEntity(new Bunker(new Coordinate2D(150 + i * 300, getHeight() / 10 * 6.5)));
        }
    }

    public void createBullet() {
        Bullet bullet = new Bullet(new Coordinate2D(player.getX(), getHeight() / 10 * 8.5), 180d);
        addEntity(bullet);
    }
}