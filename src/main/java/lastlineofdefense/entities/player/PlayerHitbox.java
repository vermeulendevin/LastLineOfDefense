package lastlineofdefense.entities.player;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.paint.Color;

import java.util.List;

public class PlayerHitbox extends RectangleEntity implements Collided, Collider {
    protected PlayerHitbox(Coordinate2D initialLocation) {
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
