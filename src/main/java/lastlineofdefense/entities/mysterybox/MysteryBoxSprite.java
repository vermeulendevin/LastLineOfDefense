package lastlineofdefense.entities.mysterybox;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class MysteryBoxSprite extends SpriteEntity {
    protected MysteryBoxSprite(Coordinate2D initialLocation) {
        super("sprites/heart_32x32.png", initialLocation, new Size(50, 50));
    }
}
