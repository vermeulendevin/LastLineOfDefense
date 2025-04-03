package lastlineofdefense.entities.soldier;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class SoldierSprite extends SpriteEntity {

    protected SoldierSprite(Coordinate2D initialLocation) {
        super("sprites/Soldier.png", initialLocation, new Size(75, 75));
    }
}
