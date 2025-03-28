package lastlineofdefense.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import lastlineofdefense.LastLineOfDefenseApp;
import lastlineofdefense.entities.buttons.PlayButton;
import lastlineofdefense.entities.buttons.QuitButton;

public class Pausescreen extends StaticScene {

    private LastLineOfDefenseApp app;

    public Pausescreen(LastLineOfDefenseApp App) {
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

        var startOverButton = new PlayButton(app, new Coordinate2D(getWidth()/4, (getHeight()/4)*3), "Start Over");
        startOverButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(startOverButton);

        var quitGameButton = new QuitButton(app, new Coordinate2D((getWidth()/4)*3, (getHeight()/4)*3), "Quit Game");
        quitGameButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(quitGameButton);
    }
}
