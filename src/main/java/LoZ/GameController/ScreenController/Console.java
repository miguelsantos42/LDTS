package LoZ.GameController.ScreenController;

import LoZ.GameController.LevelStateController.Level;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFrame;

import java.io.IOException;

import LoZ.GameController.Game;
//Console
public class Console{

    public enum Action{
        UP,
        DOWN,
        LEFT,
        RIGHT,
        ATTACK,
        DEFFEND,
        QUIT
    }

    public Level level;
    protected boolean exitThread = false;


    public Console(TextGraphics graphics) {

        this.level = new Level(graphics, this);

    }

    public static Action lastMovement = Action.LEFT;


    public void addKeyBoardListener(KeyBoardObserver obs) {
        ((AWTTerminalFrame) Game.getScreen().getTerminal()).getComponent(0).addKeyListener(obs);
    }

    public void clear() {
        Game.getScreen().clear();
    }

    public void refresh() throws IOException {
        Game.getScreen().refresh();
        Game.getScreen().doResizeIfNecessary();
    }

    public void close() {

        try {
            Game.getScreen().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean gameStatus() {
        return !exitThread;
    }
}