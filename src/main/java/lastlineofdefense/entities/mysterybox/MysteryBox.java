package lastlineofdefense.entities.mysterybox;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;

public class MysteryBox extends DynamicCompositeEntity implements Newtonian, SceneBorderTouchingWatcher {
    public MysteryBox(Coordinate2D initialLocation) {
        super(initialLocation);
        setGravityConstant(0.3);
        setFrictionConstant(0.05);
    }

    @Override
    protected void setupEntities() {
        var sprite = new MysteryBoxSprite(new Coordinate2D(0, 0));
        addEntity(sprite);
        var hitbox = new MysteryBoxHitbox(new Coordinate2D(0, 0));
        addEntity(hitbox);
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder border) {
        setGravityConstant(0);

        switch(border) {
            case BOTTOM:
                setAnchorLocationY(getSceneHeight() - getHeight() - 1);
                break;
            default:
                break;
        }
    }
}
