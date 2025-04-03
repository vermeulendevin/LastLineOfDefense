package lastlineofdefense.entities.soldier;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import lastlineofdefense.hud.scoreboard.Scoreboard;

public class SoldierGrid extends DynamicCompositeEntity {
    private Scoreboard scoreboard;

    private int rows;
    private int cols;
    private int spacingX;
    private int spacingY;
    private double speed = 0.5;
    private boolean movingRight = true;

    private double gameWidth;

    public SoldierGrid(Scoreboard scoreboard, int rows, int cols, Coordinate2D initialLocation, int spacingX, int spacingY, double gameWidth) {
        super(initialLocation);
        this.scoreboard = scoreboard;
        this.rows = rows;
        this.cols = cols;
        this.spacingX = spacingX;
        this.spacingY = spacingY;
        this.gameWidth = gameWidth;
    }

    @Override
    protected void setupEntities() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int x = col * spacingX;
                int y = row * spacingY;
                Soldier soldier = new Soldier(scoreboard, new Coordinate2D(x, y));
                addEntity(soldier);
            }
        }
    }

    public void update() {
        double dx = movingRight ? speed : -speed;
        setAnchorLocation(new Coordinate2D(getAnchorLocation().getX() + dx, getAnchorLocation().getY()));

        double gridRightEdge = getAnchorLocation().getX() + (cols - 1) * spacingX;
        double gridLeftEdge = getAnchorLocation().getX();

        if (movingRight && gridRightEdge >= gameWidth - spacingX) {
            moveDown();
            movingRight = false;
        } else if (!movingRight && gridLeftEdge <= 0) {
            moveDown();
            movingRight = true;
        }
    }

    private void moveDown() {
        setAnchorLocation(new Coordinate2D(getAnchorLocation().getX(), getAnchorLocation().getY() + spacingY - 25));
    }
}