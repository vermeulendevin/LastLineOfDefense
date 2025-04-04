package lastlineofdefense.entities.player;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.paint.Color;
import lastlineofdefense.LastLineOfDefenseApp;
import lastlineofdefense.entities.bullet.Bullet;
import lastlineofdefense.entities.soldier.Soldier;

import java.util.List;

public class PlayerHitbox extends RectangleEntity implements Collided, Collider {

    private final Player player;
    private final LastLineOfDefenseApp app;

    protected PlayerHitbox(Player player, LastLineOfDefenseApp app, Coordinate2D initialLocation) {
        super(initialLocation);
        this.player = player;
        this.app = app;
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
            if(collider instanceof Bullet bullet) {
                if(bullet.getShooter() instanceof Player) {
                    continue;
                }
                if (player.getLives() > 0) {
                    player.setLives((byte) (player.getLives() - 1));
                    System.out.println("Player hit! Lives remaining: " + player.getLives());
                } else {
                    System.out.println("Game Over! No lives left.");
                    app.setActiveScene(3);
                }
                ((Bullet) collider).remove();
            }
        }
    }
}
