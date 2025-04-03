package lastlineofdefense.entities.bunker;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class BunkerSprite extends SpriteEntity {
    protected BunkerSprite(Coordinate2D initialLocation) {
        super("sprites/bunker.png", initialLocation, new Size(150, 150));
    }
}
