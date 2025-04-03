package lastlineofdefense.entities.soldier;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import lastlineofdefense.LastLineOfDefenseApp;
import lastlineofdefense.entities.player.PlayerHitbox;
import lastlineofdefense.entities.player.PlayerSprite;

public class Soldier extends DynamicCompositeEntity {
    private LastLineOfDefenseApp app;

    public Soldier(Coordinate2D initialLocation) {
        super(initialLocation);
        this.app = app;

    }

    @Override
    protected void setupEntities() {
        final SoldierSprite soldierSprite = new SoldierSprite(new Coordinate2D(0, 0));
        final SoldierHitbox soldierHitbox = new SoldierHitbox(new Coordinate2D(0, 0));
        addEntity(soldierSprite);
        addEntity(soldierHitbox);
    }


}