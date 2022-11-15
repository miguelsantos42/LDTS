package Objects;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

abstract public class GameObject {
    public Position position;

    public GameObject(Position position) {

        this.position = position;

    }

    public void draw(TextGraphics screen) {
        screen.setForegroundColor(new TextColor.RGB(255, 255, 255));
        screen.putString(10, 10, "a");


    }

}
