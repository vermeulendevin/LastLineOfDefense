package lastlineofdefense.entities.bullet;

        import com.github.hanyaeger.api.Coordinate2D;
        import com.github.hanyaeger.api.entities.Collider;
        import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
        import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
        import com.github.hanyaeger.api.scenes.SceneBorder;

        public class Bullet extends DynamicSpriteEntity implements SceneBorderCrossingWatcher, Collider {
            private final Object shooter;
            private final double speed = 10;

            public Bullet(Object shooter, Coordinate2D initialLocation, double direction) {
                super("sprites/Bullet.png", initialLocation);
                this.shooter = shooter;
                setMotion(speed, direction);
            }

            @Override
            public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
                if (sceneBorder.equals(SceneBorder.TOP) || sceneBorder.equals(SceneBorder.BOTTOM)) {
                    remove();
                }
            }

            public Object getShooter() {
                return shooter;
            }
        }