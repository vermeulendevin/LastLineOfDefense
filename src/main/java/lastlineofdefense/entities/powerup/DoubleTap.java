package lastlineofdefense.entities.powerup;

import lastlineofdefense.entities.player.Player;
import lastlineofdefense.hud.scoreboard.PowerUpBox;

public class DoubleTap implements IPowerUp {
    private final PowerUpBox powerUpBox;

    public DoubleTap (PowerUpBox powerUpBox) {
        this.powerUpBox = powerUpBox;
    }

    @Override
    public void activatePowerUp(Player player) {
        player.setFireRate(player.getFireRate() / 2);
        powerUpBox.setImage(this);
        System.out.println("Double Tap activated! Fire rate increased.");
    }

    @Override
    public void deactivatePowerUp(Player player) {
        player.setFireRate(player.getFireRate() * 2);
        System.out.println("Double Tap deactivated. Fire rate reset.");
    }
}
