package lastlineofdefense.entities.powerup;

import lastlineofdefense.entities.player.Player;

public class FullAuto implements IPowerUp {
    private int originalFireRate = 500;

    @Override
    public void activatePowerUp(Player player) {
        int increasedFireRate = 100;
        player.setFireRate(increasedFireRate);
        System.out.println("Full Auto activated! Fire rate increased.");
    }

    @Override
    public void deactivatePowerUp(Player player) {
        player.setFireRate(originalFireRate);
        System.out.println("Full Auto deactivated. Fire rate reset.");
    }
}
