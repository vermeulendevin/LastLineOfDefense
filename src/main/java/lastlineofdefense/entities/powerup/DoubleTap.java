package lastlineofdefense.entities.powerup;

import lastlineofdefense.entities.player.Player;

public class DoubleTap implements IPowerUp {
    @Override
    public void activatePowerUp(Player player) {
        player.setFireRate(player.getFireRate() / 2);
        System.out.println("Double Tap deactivated. Fire rate reset.");
    }

    @Override
    public void deactivatePowerUp(Player player) {
        player.setFireRate(player.getFireRate() * 2);
        System.out.println("Double Tap activated! Fire rate increased.");
    }
}