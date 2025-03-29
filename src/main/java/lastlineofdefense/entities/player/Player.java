package lastlineofdefense.entities.player;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;
import lastlineofdefense.LastLineOfDefenseApp;

import java.util.Set;

public class Player extends DynamicCompositeEntity implements SceneBorderTouchingWatcher, KeyListener {

    private LastLineOfDefenseApp app;
    private byte lives = 3;

    protected Player(LastLineOfDefenseApp app, Coordinate2D initialLocation) {
        super(initialLocation);
        this.app = app;
    }

    @Override
    protected void setupEntities() {
        final PlayerSprite playerSprite = new PlayerSprite(new Coordinate2D(0, 0));
        final PlayerHitbox playerHitbox = new PlayerHitbox(new Coordinate2D(0, 40));
        addEntity(playerSprite);
        addEntity(playerHitbox);
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder border) {
        setSpeed(0);

        switch(border) {
            case LEFT:
                setAnchorLocationX(1);
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
            setMotion(3,270d);
        } else if(pressedKeys.contains(KeyCode.D)){
            setMotion(3,90d);
        }
    }
}
