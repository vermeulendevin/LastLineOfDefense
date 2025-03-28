package lastlineofdefense.scenes;

import com.github.hanyaeger.api.scenes.DynamicScene;
import lastlineofdefense.LastLineOfDefenseApp;

public class Gamescreen extends DynamicScene {
    public Gamescreen(LastLineOfDefenseApp lastLineOfDefenseApp) {
    }

    @Override
    public void setupScene() {
        setBackgroundAudio("audio/interstellar prod marijn.mp3");
        setBackgroundImage("backgrounds/RockBG.png");
    }

    @Override
    public void setupEntities() {

    }
}
