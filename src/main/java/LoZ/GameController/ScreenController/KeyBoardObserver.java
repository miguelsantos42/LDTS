package LoZ.GameController.ScreenController;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
//KeyBoardObserver
public class KeyBoardObserver extends KeyAdapter {

    private Console console;
    private Console listener;
    public KeyBoardObserver() {}

    @Override
    public void keyPressed(KeyEvent e) {

        super.keyPressed(e);

        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT -> console.keyPressed(Console.Action.LEFT);
            case KeyEvent.VK_RIGHT -> console.keyPressed(Console.Action.RIGHT);
            case KeyEvent.VK_UP -> console.keyPressed(Console.Action.DOWN);
            case KeyEvent.VK_DOWN -> console.keyPressed(Console.Action.UP);
            case KeyEvent.VK_Z -> console.keyPressed(Console.Action.ATTACK);
            case KeyEvent.VK_SPACE -> console.keyPressed(Console.Action.ATTACK);
            case KeyEvent.VK_X ->  console.keyPressed(Console.Action.DEFFEND);
            case KeyEvent.VK_Q ->  console.keyPressed(Console.Action.QUIT);
        }
    }

    public void setConsole(Console console) {
        this.console = console;
    }

    public void setListener(Console listener) {
        this.listener = listener;
    }
}