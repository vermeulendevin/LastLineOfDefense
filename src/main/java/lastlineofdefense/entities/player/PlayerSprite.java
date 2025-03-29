package lastlineofdefense.entities.player;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class PlayerSprite extends SpriteEntity {

    protected PlayerSprite(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation);
    }
}
