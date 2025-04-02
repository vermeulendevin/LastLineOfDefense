package lastlineofdefense.entities.bunker;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.paint.Color;
import lastlineofdefense.entities.bullet.Bullet;

import java.util.List;

public class BunkerHitbox extends RectangleEntity implements Collided {

    private Bunker bunker;

    protected BunkerHitbox(Bunker bunker, Coordinate2D initialLocation) {
        super(initialLocation);
        this.bunker = bunker;
        setWidth(100);
        setHeight(60);
        setFill(Color.TRANSPARENT);
    }

    @Override
    public void onCollision(List<Collider> collidingObject) {
        for(Collider collider : collidingObject) {
            if(collider instanceof Bullet) {
                bunker.hitBunker();
                ((Bullet) collider).remove();
            }
        }
    }
}
