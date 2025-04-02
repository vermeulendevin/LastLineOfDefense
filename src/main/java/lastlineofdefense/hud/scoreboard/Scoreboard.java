package lastlineofdefense.hud.scoreboard;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.YaegerGame;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Scoreboard extends TextEntity {
    int currentScore = 0;
    int highScore = 0;

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
        currentScore = currentScore + points;
    }
}
