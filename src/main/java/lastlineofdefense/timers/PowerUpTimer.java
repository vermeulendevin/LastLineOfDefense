package lastlineofdefense.timers;

import com.github.hanyaeger.api.Timer;
import lastlineofdefense.entities.player.Player;
import lastlineofdefense.entities.powerup.IPowerUp;

public class PowerUpTimer extends Timer {

    private Player player;
    private IPowerUp powerUp;
    private long startTime = 0;

    public PowerUpTimer(IPowerUp powerUp, Player player) {
        super(10000);
        this.powerUp = powerUp;
        this.player = player;
    }

    @Override
    public void onAnimationUpdate(long l) {
        System.out.println("testt");
        if(player.getFireRate() == 100) {
            System.out.println("Fire rate omhoog");
            if (startTime == 0) {
                startTime = l;
            }
            if (l - startTime >= 10000) {
                startTime = 0;
            }
        }
        remove();
    }
}
