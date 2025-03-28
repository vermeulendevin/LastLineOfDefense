package lastlineofdefense.entities.player;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class player extends DynamicSpriteEntity {

    protected player(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation);
    }
}
