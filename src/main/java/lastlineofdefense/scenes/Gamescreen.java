package lastlineofdefense.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import lastlineofdefense.LastLineOfDefenseApp;
import lastlineofdefense.entities.player.Player;
import lastlineofdefense.hud.scoreboard.Lives;
import lastlineofdefense.hud.scoreboard.Scoreboard;

public class Gamescreen extends DynamicScene {
    private LastLineOfDefenseApp app;

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

        addEntity(new Player(app, new Coordinate2D(getWidth() / 2, getHeight() / 10 * 8)));

        var Score = new Scoreboard(new Coordinate2D(30, 15));
        Score.displayScore();
        addEntity(Score);

        var HighScore = new Scoreboard(new Coordinate2D(getWidth() - 225, 15));
        HighScore.displayHighScore();
        addEntity(HighScore);


        int LivesStartX = 30;
        double LivesY = getHeight()-55;
        int LivesSpacing = 40;
        int numberOfLives = 3;      //TODO: change to Player.getLives()
        for (int i = 0; i < numberOfLives; i++) {
            int livesX = LivesStartX + (i * LivesSpacing);
            addEntity(new Lives(new Coordinate2D(livesX, LivesY)));
        }
    }
}