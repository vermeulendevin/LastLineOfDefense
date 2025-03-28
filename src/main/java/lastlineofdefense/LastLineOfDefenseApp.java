package lastlineofdefense;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import lastlineofdefense.scenes.Endscreen;
import lastlineofdefense.scenes.Pausescreen;
import lastlineofdefense.scenes.Startscreen;

public class LastLineOfDefenseApp extends YaegerGame {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void setupGame() {
        setGameTitle("Last Line of Defense");
        setSize(new Size(800,600));
    }

    @Override
    public void setupScenes() {

        addScene(0, new Startscreen(this));
        addScene(2, new Pausescreen(this));
        addScene(3, new Endscreen(this));       //TODO goeie volgorde

    }
}
