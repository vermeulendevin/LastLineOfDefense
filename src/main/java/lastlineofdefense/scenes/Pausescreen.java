package lastlineofdefense.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import lastlineofdefense.LastLineOfDefenseApp;
import lastlineofdefense.entities.buttons.PlayButton;
import lastlineofdefense.entities.buttons.QuitButton;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class Pausescreen extends StaticScene implements KeyListener {

    private LastLineOfDefenseApp app;

    public Pausescreen(LastLineOfDefenseApp app) {
        this.app = app;
    }

    @Override
    public void setupScene() {
        setBackgroundColor(Color.BLACK);
    }

    @Override
    public void setupEntities() {
        var PauseText = new TextEntity(
                new Coordinate2D(getWidth() / 2, getHeight() / 6),
                "Game Paused"
        );
        PauseText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        PauseText.setFill(Color.DARKGREEN);
        PauseText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 80));
        addEntity(PauseText);

        //TODO: OPTIONAL SCORE/HIGHSCORE
        //TODO: RESUME BUTTON

        var startOverButton = new PlayButton(app, new Coordinate2D(getWidth()/4, (getHeight()/4)*3), "Start Over");
        startOverButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(startOverButton);

        var quitGameButton = new QuitButton(app, new Coordinate2D((getWidth()/4)*3, (getHeight()/4)*3), "Quit Game");
        quitGameButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(quitGameButton);
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if (pressedKeys.contains(KeyCode.ESCAPE)) {
            long currentTime = System.currentTimeMillis();
            long prevTime = 0;
            if(currentTime - prevTime >= 1000) {
                app.setActiveScene(1);
                prevTime = currentTime;
            }
        }
    }
}
