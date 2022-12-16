package LoZ.GameController.ScreenController;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
//KeyBoardObserver
public class KeyBoardObserver extends KeyAdapter {

    public KeyBoardObserver() {}

    @Override
    public void keyPressed(KeyEvent e) {

        super.keyPressed(e);

        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT -> LevelController.console.level.keyPressed(Console.Action.LEFT, LevelController.console);
            case KeyEvent.VK_RIGHT -> LevelController.console.level.keyPressed(Console.Action.RIGHT, LevelController.console);
            case KeyEvent.VK_UP -> LevelController.console.level.keyPressed(Console.Action.DOWN, LevelController.console);
            case KeyEvent.VK_DOWN -> LevelController.console.level.keyPressed(Console.Action.UP, LevelController.console);
            case KeyEvent.VK_Z -> LevelController.console.level.keyPressed(Console.Action.ATTACK, LevelController.console);
            case KeyEvent.VK_SPACE -> LevelController.console.level.keyPressed(Console.Action.ATTACK, LevelController.console);
            case KeyEvent.VK_X ->  LevelController.console.level.keyPressed(Console.Action.DEFFEND, LevelController.console);
            case KeyEvent.VK_Q ->  LevelController.console.level.keyPressed(Console.Action.QUIT, LevelController.console);
        }
    }

}