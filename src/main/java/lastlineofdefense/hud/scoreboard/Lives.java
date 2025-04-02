package lastlineofdefense.hud.scoreboard;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Lives extends SpriteEntity {

    public Lives(Coordinate2D location) {
        super("sprites/heart_32x32.png", location);
    }

}