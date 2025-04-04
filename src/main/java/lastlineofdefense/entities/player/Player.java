package lastlineofdefense.entities.player;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;
import lastlineofdefense.LastLineOfDefenseApp;
import lastlineofdefense.entities.powerup.IPowerUp;
import lastlineofdefense.scenes.Gamescreen;

import java.util.Set;

public class Player extends DynamicCompositeEntity implements SceneBorderTouchingWatcher, KeyListener, Newtonian {

    private LastLineOfDefenseApp app;
    private Gamescreen gamescreen;
    private byte lives = 3;

    private long lastShotTime = 0;
    private int fireRate = 500;

    private boolean activePowerUp = false;

    public Player(LastLineOfDefenseApp app, Gamescreen gamescreen, Coordinate2D initialLocation) {
        super(initialLocation);
        this.app = app;
        this.gamescreen = gamescreen;
        setGravityConstant(0);
        setFrictionConstant(0.5);
    }

    @Override
    protected void setupEntities() {
        final PlayerSprite playerSprite = new PlayerSprite(new Coordinate2D(0, 0));
        final PlayerHitbox playerHitbox = new PlayerHitbox(this, app, new Coordinate2D(0, 0));

        playerSprite.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        playerHitbox.setAnchorPoint(AnchorPoint.CENTER_CENTER);

        addEntity(playerSprite);
        addEntity(playerHitbox);
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder border) {
        setSpeed(0);

        switch(border) {
            case LEFT:
                setAnchorLocationX(getWidth() / 2);
                break;
            case RIGHT:
                setAnchorLocationX(getSceneWidth() - getWidth() - 1);
                break;
            default:
                break;
        }
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if(pressedKeys.contains(KeyCode.A)){
            setMotion(5,270d);
        } else if(pressedKeys.contains(KeyCode.D)){
            setMotion(5,90d);
        } else if(pressedKeys.contains(KeyCode.ENTER)) {
            long currentTime = System.currentTimeMillis();
            if(currentTime - lastShotTime >= fireRate) {
                shoot();
                lastShotTime = currentTime;
            }
        }
    }

    public void shoot() {
        gamescreen.createBullet(this, getAnchorLocation(), 180d);
    }

    public double getX() {
        return getAnchorLocation().getX() + getWidth() / 2;
    }

    public void setFireRate(int i) {
        this.fireRate = i;
    }

    public int getFireRate() {
        return fireRate;
    }

    public void setPowerUp(IPowerUp powerUp) {
        powerUp.activatePowerUp(this);
        this.activePowerUp = true;
    }

    public void setLives(byte lives) {
        this.lives = lives;
    }

    public byte getLives() {
        return lives;
    }

    public boolean isActivePowerUp() {
        return activePowerUp;
    }
}
