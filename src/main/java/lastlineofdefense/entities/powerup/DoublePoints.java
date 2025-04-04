package lastlineofdefense.entities.powerup;

import lastlineofdefense.entities.player.Player;
import lastlineofdefense.hud.scoreboard.PowerUpBox;
import lastlineofdefense.hud.scoreboard.Scoreboard;

public class DoublePoints implements IPowerUp{
    private final Scoreboard scoreboard;
    private final PowerUpBox powerUpBox;

    public DoublePoints(Scoreboard scoreboard, PowerUpBox powerUpBox) {
        this.scoreboard = scoreboard;
        this.powerUpBox = powerUpBox;
    }


    @Override
    public void activatePowerUp(Player player) {
        scoreboard.setDoublePoints(true);
        System.out.println("Double points activated!");
    }

    @Override
    public void deactivatePowerUp(Player player) {
        scoreboard.setDoublePoints(false);
    }
}