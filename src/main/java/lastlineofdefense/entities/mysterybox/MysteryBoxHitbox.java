package lastlineofdefense.entities.mysterybox;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.paint.Color;

public class MysteryBoxHitbox extends RectangleEntity implements Collider {

    protected MysteryBoxHitbox(Coordinate2D initialLocation) {
        super(initialLocation);
        setWidth(100);
        setHeight(100);
        setFill(Color.TRANSPARENT);
    }
}
