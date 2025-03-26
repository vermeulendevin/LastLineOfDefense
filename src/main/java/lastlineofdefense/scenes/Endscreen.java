package lastlineofdefense.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import lastlineofdefense.LastLineOfDefenseApp;

public class Endscreen extends StaticScene {
    private LastLineOfDefenseApp app;

    public Endscreen(LastLineOfDefenseApp app) {
        this.app = app;
    }

    @Override
    public void setupScene() {
        setBackgroundColor(Color.BLACK);
    }

    @Override
    public void setupEntities() {
        var gameOverText = new TextEntity(
                new Coordinate2D(getWidth() / 2, getHeight() / 4),
                "Game Over"
        );
        gameOverText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        gameOverText.setFill(Color.WHITE);
        gameOverText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 80));
        addEntity(gameOverText);

        var scoreText = new TextEntity(
                new Coordinate2D(getWidth() / 3, (getHeight() / 6)*3),
                "Score: "                                           //TODO: Score variabele hier toevoegen
        );
        scoreText.setAnchorPoint(AnchorPoint.CENTER_RIGHT);
        scoreText.setFill(Color.WHITE);
        scoreText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 40));
        addEntity(scoreText);

        var highScoreText = new TextEntity(
                new Coordinate2D(getWidth() / 3, (getHeight() / 6)*4),
                "Highscore: "                                             //TODO: HighScore variabele hier toevoegen
        );
        highScoreText.setAnchorPoint(AnchorPoint.CENTER_RIGHT);
        highScoreText.setFill(Color.WHITE);
        highScoreText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 40));
        addEntity(highScoreText);
    }


}
