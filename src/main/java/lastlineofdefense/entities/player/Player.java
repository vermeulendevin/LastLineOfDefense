package lastlineofdefense.entities.player;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class Player extends DynamicSpriteEntity {

    public Player(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation);
    }
}
