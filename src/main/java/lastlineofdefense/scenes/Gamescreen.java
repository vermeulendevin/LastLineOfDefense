package lastlineofdefense.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import lastlineofdefense.LastLineOfDefenseApp;
import lastlineofdefense.entities.player.Player;
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

        addEntity(new Player(app, new Coordinate2D(getWidth() / 2, getHeight() / 8 * 7)));

        var Score = new Scoreboard(new Coordinate2D(30, 15));
        Score.displayScore();
        addEntity(Score);

        var HighScore = new Scoreboard(new Coordinate2D(575, 15));
        HighScore.displayHighScore();
        addEntity(HighScore);
    }
}
