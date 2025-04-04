package lastlineofdefense.entities.player;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.paint.Color;
import lastlineofdefense.entities.bullet.Bullet;

import java.util.List;

public class PlayerHitbox extends RectangleEntity implements Collided, Collider {

    private final Player player;

    protected PlayerHitbox(Player player, Coordinate2D initialLocation) {
        super(initialLocation);
        this.player = player;
        setWidth(50);
        setHeight(50);
        setFill(Color.TRANSPARENT);
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    public void onCollision(List<Collider> collidingObject) {
        for(Collider collider : collidingObject) {
            if(collider instanceof Bullet) {
                ((Bullet) collider).remove();
            }
        }
    }
}
