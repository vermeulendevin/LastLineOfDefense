package lastlineofdefense.entities.borders;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.paint.Color;

public class BorderBottom extends RectangleEntity implements Collider {

    public BorderBottom(Coordinate2D initialLocation) {
        super(initialLocation);
        setHeight(10);
        setFill(Color.TRANSPARENT);
    }
}
