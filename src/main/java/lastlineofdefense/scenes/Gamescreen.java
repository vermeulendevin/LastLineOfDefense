package lastlineofdefense.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import lastlineofdefense.LastLineOfDefenseApp;
import lastlineofdefense.entities.bunker.Bunker;
import lastlineofdefense.entities.player.Player;

import java.util.ArrayList;

public class Gamescreen extends DynamicScene {
    private LastLineOfDefenseApp app;
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
        addEntity(new Player(app, new Coordinate2D(getWidth() / 2, getHeight() / 8 * 6)));

        for(int i = 0; i < nrBunkers; i++) {
            int x = 50 + (i * 200);
            addEntity(new Bunker(new Coordinate2D(x, getHeight() / 8 * 5)));
        }

    }
}
