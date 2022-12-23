package LoZ.GameController.ScreenController;
import LoZ.GameController.ScreenController.Console;
import LoZ.Game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
//KeyBoardObserver
public class KeyBoardObserver extends KeyAdapter {

    public KeyBoardObserver() {}


    static public enum Action{
        UP,
        DOWN,
        LEFT,
        RIGHT,
        ATTACK,
        DEFEND,
        QUIT,
        SELECT
    }

    public static Action lastMovement = Action.LEFT;

    @Override
    public void keyPressed(KeyEvent e) {

        super.keyPressed(e);


        switch (Console.state) {
            case MENU -> menuController(e);
            case INSTRUCTIONS -> instructionsController(e);
            case LEVEL -> levelController(e);
        }
    }



    public void menuController(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP -> Game.console.menu.keyPressed(Action.DOWN);
            case KeyEvent.VK_DOWN -> Game.console.menu.keyPressed(Action.UP);
            case KeyEvent.VK_Q -> Game.console.menu.keyPressed(Action.QUIT);
            case KeyEvent.VK_ENTER -> Game.console.menu.keyPressed(Action.SELECT);
        }
    }

    public void levelController(KeyEvent e){
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT -> Game.console.level.keyPressed(Action.LEFT);
            case KeyEvent.VK_RIGHT -> Game.console.level.keyPressed(Action.RIGHT);
            case KeyEvent.VK_UP -> Game.console.level.keyPressed(Action.DOWN);
            case KeyEvent.VK_DOWN -> Game.console.level.keyPressed(Action.UP);
            case KeyEvent.VK_Z -> Game.console.level.keyPressed(Action.ATTACK);
            case KeyEvent.VK_SPACE -> Game.console.level.keyPressed(Action.ATTACK);
            case KeyEvent.VK_X ->  Game.console.level.keyPressed(Action.DEFEND);
            case KeyEvent.VK_Q ->  Game.console.level.keyPressed(Action.QUIT);
        }
    }
    public void instructionsController(KeyEvent e){
        switch (e.getKeyCode()) {
            case KeyEvent.VK_M -> Game.console.instructions.keyPressed(Action.SELECT);
            case KeyEvent.VK_Q ->  Game.console.instructions.keyPressed(Action.QUIT);
        }
    }




}