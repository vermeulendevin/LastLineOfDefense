package lastlineofdefense.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import javafx.scene.input.MouseButton;
import lastlineofdefense.LastLineOfDefenseApp;

public class DifficultyButton extends TextEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {

    private LastLineOfDefenseApp app;

    public DifficultyButton(LastLineOfDefenseApp app, Coordinate2D initialLocation, String text) {
        super(initialLocation, text);
        this.app = app;
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {

    }

    @Override
    public void onMouseEntered() {

    }

    @Override
    public void onMouseExited() {

    }
}
