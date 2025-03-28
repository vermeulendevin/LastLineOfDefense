package lastlineofdefense.entities.player;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;

import java.util.List;

public class PlayerHitbox extends RectangleEntity implements Collided {
    protected PlayerHitbox(Coordinate2D initialLocation) {
        super(initialLocation);
    }

    @Override
    public void onCollision(List<Collider> list) {

    }
}
