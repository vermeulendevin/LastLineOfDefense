package lastlineofdefense.entities.player;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class PlayerSprite extends SpriteEntity {

    protected PlayerSprite(Coordinate2D initialLocation) {
        super("sprites/Player.png", initialLocation, new Size(75, 75));
    }
}
