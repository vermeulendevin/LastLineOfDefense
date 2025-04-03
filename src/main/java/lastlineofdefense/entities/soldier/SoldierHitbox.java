package lastlineofdefense.entities.soldier;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.paint.Color;
import lastlineofdefense.entities.bullet.Bullet;
import lastlineofdefense.hud.scoreboard.Scoreboard;

import java.util.List;

public class SoldierHitbox extends RectangleEntity implements Collided {

    private Scoreboard scoreboard;

    protected SoldierHitbox(Scoreboard scoreboard, Coordinate2D initialLocation) {
        super(initialLocation);
        this.scoreboard = scoreboard;
        setWidth(50);
        setHeight(50);
        setFill(Color.TRANSPARENT);
    }

    @Override
    public void onCollision(List<Collider> collidingObject) {
        for (Collider collider : collidingObject) {
            if (collider instanceof Bullet) {
                scoreboard.setCurrentScore(15);
                System.out.println(scoreboard.getCurrentScore());
                ((Bullet) collider).remove();
                remove();
            }
        }
    }
}