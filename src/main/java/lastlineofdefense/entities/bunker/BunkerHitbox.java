package lastlineofdefense.entities.bunker;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.paint.Color;

import java.util.List;

public class BunkerHitbox extends RectangleEntity implements Collided {
    protected BunkerHitbox(Coordinate2D initialLocation) {
        super(initialLocation);
        setWidth(100);
        setHeight(100);
        setFill(Color.TRANSPARENT);
    }

    @Override
    public void onCollision(List<Collider> collidingObject) {

    }
}
