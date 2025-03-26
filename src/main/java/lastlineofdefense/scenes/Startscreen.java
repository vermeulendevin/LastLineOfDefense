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

public class Startscreen extends StaticScene {
    private LastLineOfDefenseApp app;

    public Startscreen(LastLineOfDefenseApp app) {
        this.app = app;
    }

    @Override
    public void setupScene() {
        setBackgroundColor(Color.BLACK);
    }

    @Override
    public void setupEntities() {
        var title = new TextEntity(new Coordinate2D(getWidth() / 2, getHeight() / 4), "Last Line of Defense");
        title.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        title.setFill(Color.WHITE);
        title.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 60));
        addEntity(title);

        var playButton = new PlayButton(app, new Coordinate2D(getWidth() / 2, getHeight() / 2), "Play");
        playButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(playButton);
    }
}
