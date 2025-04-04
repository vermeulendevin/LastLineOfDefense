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
import lastlineofdefense.hud.scoreboard.PowerUpBox;
import lastlineofdefense.hud.scoreboard.Scoreboard;

import java.util.List;
import java.util.Random;

public class MysteryBox extends DynamicCompositeEntity implements Newtonian, SceneBorderTouchingWatcher, TimerContainer {

    private IPowerUp powerUp;
    private Player player;
    private Scoreboard scoreboard;
    private PowerUpBox powerUpBox;

    public MysteryBox(Scoreboard scoreboard, Coordinate2D initialLocation, PowerUpBox powerUpBox) {
        super(initialLocation);
        this.powerUpBox = powerUpBox;
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

        if(chance < 45) {
            powerUp = new DoubleTap(powerUpBox);  // 45%
        } else if(chance < 70) {
            powerUp = new DoublePoints(scoreboard, powerUpBox);   // 25%
        } else if(chance < 85) {
            powerUp = new FullAuto(powerUpBox);   // 15%
        } else {
            powerUp = new PlusOneLife();   // 15%
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
