package lastlineofdefense.entities.soldier;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;

public class SoldierGrid extends DynamicCompositeEntity {
    private int rows;
    private int cols;
    private int spacingX;
    private int spacingY;

    public SoldierGrid(int rows, int cols, Coordinate2D initialLocation, int spacingX, int spacingY) {
        super(initialLocation);
        this.rows = rows;
        this.cols = cols;
        this.spacingX = spacingX;
        this.spacingY = spacingY;
    }

    @Override
    protected void setupEntities() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int x = col * spacingX;
                int y = row * spacingY;
                Soldier soldier = new Soldier(new Coordinate2D(x, y));
                addEntity(soldier);
            }
        }
    }
}