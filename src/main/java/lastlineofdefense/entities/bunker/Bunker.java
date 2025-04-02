package lastlineofdefense.entities.bunker;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;

public class Bunker extends DynamicCompositeEntity {

    public Bunker(Coordinate2D initialLocation) {
        super(initialLocation);
    }

    @Override
    protected void setupEntities() {
        var bunkerSprite = new BunkerSprite(new Coordinate2D(0, 0));
        var bunkerHitbox = new BunkerHitbox(new Coordinate2D(0, 0));

        bunkerSprite.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        bunkerHitbox.setAnchorPoint(AnchorPoint.CENTER_CENTER);

        addEntity(bunkerSprite);
        addEntity(bunkerHitbox);
    }
}
