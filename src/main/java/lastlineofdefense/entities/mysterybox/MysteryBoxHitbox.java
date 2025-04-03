package lastlineofdefense.entities.mysterybox;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.paint.Color;
import lastlineofdefense.entities.player.Player;
import lastlineofdefense.entities.player.PlayerHitbox;

import java.util.List;

public class MysteryBoxHitbox extends RectangleEntity implements Collided {

    protected MysteryBoxHitbox(Coordinate2D initialLocation) {
        super(initialLocation);
        setWidth(50);
        setHeight(50);
        setFill(Color.TRANSPARENT);
    }

    @Override
    public void onCollision(List<Collider> collidingObject) {
        for(Collider collider : collidingObject) {
            if(collider instanceof PlayerHitbox playerHitbox) {

            }
        }
    }
}
