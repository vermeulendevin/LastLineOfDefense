package lastlineofdefense.entities.bunker;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;

public class Bunker extends DynamicCompositeEntity {

    public Bunker(Coordinate2D initialLocation) {
        super(initialLocation);
    }

    @Override
    protected void setupEntities() {

    }
}
