package lastlineofdefense.entities.soldier;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import lastlineofdefense.LastLineOfDefenseApp;
import lastlineofdefense.entities.player.PlayerHitbox;
import lastlineofdefense.entities.player.PlayerSprite;
import lastlineofdefense.hud.scoreboard.Scoreboard;
import lastlineofdefense.scenes.Gamescreen;

import java.util.Random;

public class Soldier extends DynamicCompositeEntity {
    private Scoreboard scoreboard;
    private Gamescreen gamescreen;
    private SoldierGrid soldierGrid;

    private int row;
    private int col;

    private boolean dead = false;

    public Soldier(Scoreboard scoreboard, Gamescreen gamescreen, SoldierGrid soldierGrid, Coordinate2D initialLocation, int row, int col) {
        super(initialLocation);
        this.scoreboard = scoreboard;
        this.gamescreen = gamescreen;
        this.soldierGrid = soldierGrid;
        this.row = row;
        this.col = col;
    }

    @Override
    protected void setupEntities() {
        final SoldierSprite soldierSprite = new SoldierSprite(new Coordinate2D(0, 0));
        final SoldierHitbox soldierHitbox = new SoldierHitbox(this, scoreboard, new Coordinate2D(0, 0));
        addEntity(soldierSprite);
        addEntity(soldierHitbox);
    }

    private Coordinate2D absolutePosition() {
        Coordinate2D gridPosition = soldierGrid.getGridPosition();
        Coordinate2D localPosition = getAnchorLocation();

        Coordinate2D trueLocation = new Coordinate2D(
                gridPosition.getX() + localPosition.getX(),
                gridPosition.getY() + localPosition.getY()
        );

        return trueLocation;
    }

    public void shoot() {
        gamescreen.createBullet(absolutePosition(), 0d);
    }

    public void dropMysteryBox() {
        Random random = new Random();
        if(random.nextDouble() < 0.25) {
            gamescreen.createMysteryBox(absolutePosition());
        }
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setAsDead() {
        dead = true;
        remove();
    }

    public boolean isDead() {
        return dead;
    }
}