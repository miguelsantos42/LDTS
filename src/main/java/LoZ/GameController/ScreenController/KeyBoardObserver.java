package LoZ.GameController.ScreenController;

import LoZ.GameController.Game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
//KeyBoardObserver
public class KeyBoardObserver extends KeyAdapter {

    public KeyBoardObserver() {}

    @Override
    public void keyPressed(KeyEvent e) {

        super.keyPressed(e);

        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT -> Game.console.level.keyPressed(Console.Action.LEFT, Game.console);
            case KeyEvent.VK_RIGHT -> Game.console.level.keyPressed(Console.Action.RIGHT, Game.console);
            case KeyEvent.VK_UP -> Game.console.level.keyPressed(Console.Action.DOWN, Game.console);
            case KeyEvent.VK_DOWN -> Game.console.level.keyPressed(Console.Action.UP, Game.console);
            case KeyEvent.VK_Z -> Game.console.level.keyPressed(Console.Action.ATTACK, Game.console);
            case KeyEvent.VK_SPACE -> Game.console.level.keyPressed(Console.Action.ATTACK, Game.console);
            case KeyEvent.VK_X ->  Game.console.level.keyPressed(Console.Action.DEFFEND, Game.console);
            case KeyEvent.VK_Q ->  Game.console.level.keyPressed(Console.Action.QUIT, Game.console);
        }
    }

}