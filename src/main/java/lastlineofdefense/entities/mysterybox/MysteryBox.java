package lastlineofdefense.entities.mysterybox;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;
import lastlineofdefense.entities.player.Player;
import lastlineofdefense.entities.powerup.*;

import java.util.List;
import java.util.Random;

public class MysteryBox extends DynamicCompositeEntity implements Newtonian, SceneBorderTouchingWatcher {

    private final List<IPowerUp> powerUps = List.of(new FullAuto(), new DoubleTap(), new PlusOneLife(), new DoublePoints());

    private IPowerUp powerUp;
    private Player player;

    public MysteryBox(Coordinate2D initialLocation) {
        super(initialLocation);
        setGravityConstant(0.3);
        setFrictionConstant(0.05);
        chooseRandomPowerUp();
    }

    @Override
    protected void setupEntities() {
        var sprite = new MysteryBoxSprite(new Coordinate2D(0, 0));
        addEntity(sprite);
        var hitbox = new MysteryBoxHitbox(this, new Coordinate2D(0, 0));
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

    public void chooseRandomPowerUp() {
        int chance = new Random().nextInt(100);

        if(chance < 50) {
            powerUp = new DoubleTap();  // 50%
        } else if(chance < 70) {
            powerUp = new FullAuto();   // 20%
        } else if(chance < 90) {
            powerUp = new DoublePoints();   // 20%
        } else {
            powerUp = new PlusOneLife();   // 10%
        }
    }

    public IPowerUp getPowerUp() {
        return powerUp;
    }

    public void removeMysteryBox() {
        remove();
    }
}
