package lastlineofdefense.entities.powerup;

import lastlineofdefense.entities.player.Player;

public class FullAuto implements IPowerUp {

    private final Player player;
    private int originalShootCooldown;

    public FullAuto(Player player) {
        this.player = player;
    }

    @Override
    public void activatePowerUp() {
        originalShootCooldown = player.getShootCooldown();
        player.setShootCooldown(originalShootCooldown / 2);
        System.out.println("Power-up activated! Shoot cooldown reduced to: " + player.getShootCooldown());
    }

    @Override
    public void deactivatePowerUp() {
        player.setShootCooldown(originalShootCooldown);
        System.out.println("Power-up deactivated. Shoot cooldown restored to original value.");
    }
}
