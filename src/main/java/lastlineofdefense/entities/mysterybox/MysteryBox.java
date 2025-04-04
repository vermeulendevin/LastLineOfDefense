package lastlineofdefense.entities.mysterybox;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Timer;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;
import lastlineofdefense.entities.player.Player;
import lastlineofdefense.entities.powerup.*;
import lastlineofdefense.hud.scoreboard.Scoreboard;

import java.util.List;
import java.util.Random;

public class MysteryBox extends DynamicCompositeEntity implements Newtonian, SceneBorderTouchingWatcher, TimerContainer {

    private IPowerUp powerUp;
    private Player player;
    private Scoreboard scoreboard;

    private final List<IPowerUp> powerUps = List.of(new FullAuto(), new DoubleTap(), new PlusOneLife(), new DoublePoints(scoreboard));

    public MysteryBox(Scoreboard scoreboard, Coordinate2D initialLocation) {
        super(initialLocation);
        this.scoreboard = scoreboard;
        setGravityConstant(0.3);
        setFrictionConstant(0.10);
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

        if(border == SceneBorder.BOTTOM) {
            setGravityConstant(0);
            setAnchorLocationY(getSceneHeight() - getHeight() - 1);
        }
    }

    public void chooseRandomPowerUp() {
        int chance = new Random().nextInt(100);

        if(chance < 50) {
            powerUp = new DoubleTap();  // 50%
        } else if(chance < 70) {
            powerUp = new FullAuto();   // 20%
        } else if(chance < 90) {
            powerUp = new DoublePoints(scoreboard);   // 20%
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

    @Override
    public void setupTimers() {
        addTimer(new MysteryBoxTimer(this));
    }

    public static final class MysteryBoxTimer extends Timer {
        private final MysteryBox mysteryBox;

        private MysteryBoxTimer(MysteryBox mysteryBox) {
            super(10000);
            this.mysteryBox = mysteryBox;
        }

        @Override
        public void onAnimationUpdate(long l) {
            mysteryBox.removeMysteryBox();
        }
    }
}
