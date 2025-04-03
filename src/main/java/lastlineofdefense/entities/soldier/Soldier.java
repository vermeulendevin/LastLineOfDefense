package lastlineofdefense.entities.soldier;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import lastlineofdefense.LastLineOfDefenseApp;
import lastlineofdefense.entities.player.PlayerHitbox;
import lastlineofdefense.entities.player.PlayerSprite;
import lastlineofdefense.hud.scoreboard.Scoreboard;

public class Soldier extends DynamicCompositeEntity {
    private Scoreboard scoreboard;

    public Soldier(Scoreboard scoreboard, Coordinate2D initialLocation) {
        super(initialLocation);
        this.scoreboard = scoreboard;
    }

    @Override
    protected void setupEntities() {
        final SoldierSprite soldierSprite = new SoldierSprite(new Coordinate2D(0, 0));
        final SoldierHitbox soldierHitbox = new SoldierHitbox(scoreboard, new Coordinate2D(0, 0));
        addEntity(soldierSprite);
        addEntity(soldierHitbox);
    }


}