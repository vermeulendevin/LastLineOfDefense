package lastlineofdefense.entities.powerup;

import lastlineofdefense.entities.player.Player;

public interface IPowerUp {
    void activatePowerUp(Player player);
    void deactivatePowerUp(Player player);
}
