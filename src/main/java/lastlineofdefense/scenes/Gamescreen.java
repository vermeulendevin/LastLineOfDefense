package lastlineofdefense.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import lastlineofdefense.LastLineOfDefenseApp;
import lastlineofdefense.entities.bullet.Bullet;
import lastlineofdefense.entities.bunker.Bunker;
import lastlineofdefense.entities.player.Player;
import lastlineofdefense.hud.scoreboard.Lives;
import lastlineofdefense.hud.scoreboard.Scoreboard;

public class Gamescreen extends DynamicScene {
    private LastLineOfDefenseApp app;
    private Player player;
    private int nrBunkers = 4;

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

        player = new Player(app, this, new Coordinate2D(getWidth() / 2, getHeight() / 10 * 8.5));
        addEntity(player);

        var Score = new Scoreboard(new Coordinate2D(30, 15));
        Score.displayScore();
        addEntity(Score);

        var HighScore = new Scoreboard(new Coordinate2D(getWidth()-225, 15));
        HighScore.displayHighScore();
        addEntity(HighScore);

        addEntity(new Lives(new Coordinate2D(30, getHeight()-55)));

        for(int i = 0; i < nrBunkers; i++) {
            int x = 100 + i * 300;
            addEntity(new Bunker(new Coordinate2D(x, getHeight() / 10 * 7)));
        }


    }

    public void createBullet() {
        Bullet bullet = new Bullet(new Coordinate2D(player.getX(), getHeight() / 10 * 8.5), 180d);
        addEntity(bullet);
    }

}
