package lastlineofdefense.entities.powerup;

import lastlineofdefense.entities.player.Player;

public class DoublePoints implements IPowerUp{
    @Override
    public void activatePowerUp(Player player) {
        System.out.println("Double Points activated");
    }

    @Override
    public void deactivatePowerUp(Player player) {

    }
}
