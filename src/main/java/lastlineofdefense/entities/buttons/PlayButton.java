package lastlineofdefense.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import lastlineofdefense.LastLineOfDefenseApp;

public class PlayButton extends TextEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {
    private LastLineOfDefenseApp app;

    public PlayButton(LastLineOfDefenseApp app, Coordinate2D initialLocation, String text) {
        super(initialLocation, text);
        this.app = app;
        setFill(Color.GREEN);
        setFont(Font.font("Roboto", FontWeight.BOLD, 30));
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        app.setActiveScene(1);
    }

    @Override
    public void onMouseEntered() {
        setFill(Color.DARKGREEN);
        setCursor(Cursor.HAND);
    }

    @Override
    public void onMouseExited() {
        setFill(Color.GREEN);
        setCursor(Cursor.DEFAULT);
    }
}
