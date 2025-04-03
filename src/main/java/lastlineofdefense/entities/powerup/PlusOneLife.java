package lastlineofdefense.entities.powerup;

import lastlineofdefense.entities.player.Player;

public class PlusOneLife implements IPowerUp {

    @Override
    public void activatePowerUp(Player player) {
        if (player.getLives() >= 5) {
            System.out.println("Player already has maximum lives.");
            return;
        } else if (player.getLives() < 5 || player.getLives() >= 1) {
            player.setLives((byte) (player.getLives() + 1));
            System.out.println("Powerup activated! Lives increased to: " + player.getLives());
        }
    }

    @Override
    public void deactivatePowerUp(Player player) {
        //not relevant
    }
}
