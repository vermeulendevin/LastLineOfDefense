package lastlineofdefense.entities.soldier;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.paint.Color;

import java.util.List;

public class SoldierHitbox extends RectangleEntity implements Collided {
    protected SoldierHitbox(Coordinate2D initialLocation) {
        super(initialLocation);
        setWidth(50);
        setHeight(50);
        setFill(Color.TRANSPARENT);
    }

    @Override
    public void onCollision(List<Collider> collidingObject) {
        var bulletCollision = false;

//        for(Collider collider : collidingObject) {
//            if (collider instanceof Bullet) {
//                bulletCollision = true;
//            }
//        }
    }
}