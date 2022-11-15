package Game.LevelStateController;

import Game.ScreenController.Console;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static Game.ScreenController.Console.Action.*;

public class KeyBoardObserver extends KeyAdapter {

    private Console console;
    public KeyBoardObserver() {}

    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);

        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT -> console.keyPressed(LEFT);
            case KeyEvent.VK_RIGHT -> console.keyPressed(RIGHT);
            case KeyEvent.VK_UP -> console.keyPressed(DOWN);
            case KeyEvent.VK_DOWN -> console.keyPressed(UP);
            case KeyEvent.VK_Z -> console.keyPressed(ATTACK);
            case KeyEvent.VK_X ->  console.keyPressed(DEFFEND);
        }
    }

    public void setConsole(Console console) {
        this.console = console;
    }
}