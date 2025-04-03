package lastlineofdefense.entities.powerup;

import lastlineofdefense.entities.player.Player;
import lastlineofdefense.hud.scoreboard.Scoreboard;

public class DoublePoints implements IPowerUp{
    private final Scoreboard scoreboard;

    public DoublePoints(Scoreboard scoreboard) {
        this.scoreboard = scoreboard;
    }


    @Override
    public void activatePowerUp(Player player) {
        Scoreboard.setDoublePoints(true);
        System.out.println("Double points activated!");
    }

    @Override
    public void deactivatePowerUp(Player player) {
        Scoreboard.setDoublePoints(false);
    }
}