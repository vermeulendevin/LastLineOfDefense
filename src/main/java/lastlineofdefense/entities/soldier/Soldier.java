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

    public Soldier(Scoreboard scoreboard, Gamescreen gamescreen, Coordinate2D initialLocation) {
        super(initialLocation);
        this.scoreboard = scoreboard;
        this.gamescreen = gamescreen;
    }

    @Override
    protected void setupEntities() {
        final SoldierSprite soldierSprite = new SoldierSprite(new Coordinate2D(0, 0));
        final SoldierHitbox soldierHitbox = new SoldierHitbox(scoreboard, new Coordinate2D(0, 0));
        addEntity(soldierSprite);
        addEntity(soldierHitbox);
    }

    public void dropMysteryBox() {
        Random random = new Random();
        if(random.nextDouble() < 0.25) {
            gamescreen.createMysteryBox(getAnchorLocation());
        }
    }
}