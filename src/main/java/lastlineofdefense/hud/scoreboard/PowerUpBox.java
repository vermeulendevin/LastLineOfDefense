package lastlineofdefense.hud.scoreboard;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.CompositeEntity;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import lastlineofdefense.entities.powerup.DoublePoints;
import lastlineofdefense.entities.powerup.DoubleTap;
import lastlineofdefense.entities.powerup.FullAuto;
import lastlineofdefense.entities.powerup.IPowerUp;

public class PowerUpBox extends CompositeEntity {
    private DoublePointsSprite doublePointsSprite;
    private DoubleTapSprite doubleTapSprite;
    private FullAutoSprite fullAutoSprite;


    public PowerUpBox(Coordinate2D location) {
        super(location);
    }


    public void setImage(IPowerUp powerUp) {
        if (powerUp instanceof DoublePoints) {
            System.out.println("powerUp instanceof DoublePoints");
            doublePointsSprite = new DoublePointsSprite(new Coordinate2D(0, 0));

        } else if (powerUp instanceof DoubleTap) {
            System.out.println("powerUp instanceof DoubleTap");
            doubleTapSprite = new DoubleTapSprite(new Coordinate2D(0, 0));

        } else if (powerUp instanceof FullAuto) {
            System.out.println("powerUp instanceof FullAuto");
            fullAutoSprite = new FullAutoSprite(new Coordinate2D(0, 0));

        }

    }

    @Override
    protected void setupEntities() {
        addEntity(doublePointsSprite);
        addEntity(doubleTapSprite);
        addEntity(fullAutoSprite);
    }

}
