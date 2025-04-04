package lastlineofdefense.hud.scoreboard;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.YaegerGame;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Scoreboard extends TextEntity {
    private int currentScore = 0;
    private int highScore = 0;
    private boolean doublePoints = false;

    public Scoreboard(Coordinate2D location) {
        super(location);
        setFont(Font.font("Roboto", FontWeight.NORMAL, 30));
        setFill(Color.WHITE);
    }

    public void displayScore () {
        setText("Score: " + currentScore);
    }

    public void displayHighScore () {
        if (currentScore > highScore) {
            highScore = currentScore;
        }
        setText("High Score: " + highScore);
    }

    public int getCurrentScore () {
        return currentScore;
    }

    public void setCurrentScore (int points){
        if (doublePoints == true) {
            points = points * 2;
        }
        currentScore = currentScore + points;
        updateScore();
    }

    public void updateScore() {
        displayScore();
    }

    public void setDoublePoints (boolean doublePoints) {
        this.doublePoints = doublePoints;
    }
}
