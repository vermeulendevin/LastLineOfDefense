package lastlineofdefense.entities.bullet;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicRectangleEntity;

public class bullet extends DynamicRectangleEntity implements Collider {
    private final double speed = 10;

    public bullet(Coordinate2D initialLocation, double direction) {
        super(initialLocation);
        setHeight(5);
        setWidth(2);
        setMotion(speed, direction);
    }
}
