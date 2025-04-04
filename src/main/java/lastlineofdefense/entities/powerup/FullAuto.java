package lastlineofdefense.entities.powerup;

import lastlineofdefense.entities.player.Player;
import lastlineofdefense.hud.scoreboard.PowerUpBox;

public class FullAuto implements IPowerUp {
    private final PowerUpBox powerUpBox;
    private int originalFireRate = 500;

    public FullAuto (PowerUpBox powerUpBox) {
        this.powerUpBox = powerUpBox;
    }

    @Override
    public void activatePowerUp(Player player) {
        int increasedFireRate = 100;
        player.setFireRate(increasedFireRate);
        System.out.println("Full Auto activated! Fire rate increased.");
        powerUpBox.setImage(this);
    }

    @Override
    public void deactivatePowerUp(Player player) {
        player.setFireRate(originalFireRate);
        System.out.println("Full Auto deactivated. Fire rate reset.");
    }
}
