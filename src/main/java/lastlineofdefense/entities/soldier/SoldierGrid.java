package lastlineofdefense.entities.soldier;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import lastlineofdefense.hud.scoreboard.Scoreboard;
import lastlineofdefense.scenes.Gamescreen;

import java.util.Random;

public class SoldierGrid extends DynamicCompositeEntity {
    private Scoreboard scoreboard;
    private Gamescreen gamescreen;

    private Soldier[][] soldierGrid;

    private final Random random = new Random();

    private int rows;
    private int cols;
    private int spacingX;
    private int spacingY;
    private double speed = 0.5;
    private boolean movingRight = true;

    private double gameWidth;

    public SoldierGrid(Scoreboard scoreboard, Gamescreen gamescreen, int rows, int cols, Coordinate2D initialLocation, int spacingX, int spacingY, double gameWidth) {
        super(initialLocation);
        this.scoreboard = scoreboard;
        this.gamescreen = gamescreen;
        this.rows = rows;
        this.cols = cols;
        this.spacingX = spacingX;
        this.spacingY = spacingY;
        this.gameWidth = gameWidth;
        this.soldierGrid = new Soldier[rows][cols];
    }

    @Override
    protected void setupEntities() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int x = col * spacingX;
                int y = row * spacingY;
                Soldier soldier = new Soldier(scoreboard, gamescreen, this, new Coordinate2D(x, y), row, col);
                soldierGrid[row][col] = soldier;
                addEntity(soldier);
            }
        }
    }

    public void update() {
        double horizontalShift = movingRight ? speed : -speed;
        setAnchorLocation(new Coordinate2D(getAnchorLocation().getX() + horizontalShift, getAnchorLocation().getY()));

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

    public Coordinate2D getGridPosition() {
        return new Coordinate2D(getAnchorLocation());
    }

    public boolean isInLastRow(Soldier soldier) {
        int col = soldier.getCol();
        for(int row = rows -1; row >= 0; row--) {
            if(soldierGrid[row][col] != null && !soldierGrid[row][col].isDead()) {
                return soldierGrid[row][col] == soldier;
            }
        }
        return false;
    }

    public void triggerLastRowShooting() {
        for (int row = rows - 1; row >= 0; row--) {
            for (int col = 0; col < cols; col++) {
                Soldier soldier = soldierGrid[row][col];
                if (soldier != null && !soldier.isDead()) {
                    if (isInLastRow(soldier)) {
                        if(random.nextInt(100) == 0) {
                            soldier.shoot();
                        }
                    }
                }
            }
        }
    }
}