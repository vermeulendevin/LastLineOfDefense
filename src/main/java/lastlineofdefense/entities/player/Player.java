package lastlineofdefense.entities.player;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;

public class Player extends DynamicCompositeEntity implements SceneBorderCrossingWatcher {

    protected Player(Coordinate2D initialLocation) {
        super(initialLocation);
    }

    @Override
    protected void setupEntities() {

    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {

    }
}
