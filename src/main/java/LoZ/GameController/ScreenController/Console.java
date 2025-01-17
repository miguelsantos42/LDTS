package LoZ.GameController.ScreenController;

import LoZ.GameController.ScreenStates.*;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFrame;

import java.io.IOException;

import LoZ.Game;
//Console
public class Console{





    static public enum ScreenState{
        MENU,
        INSTRUCTIONS,
        LEVEL,
        CLOSE,
        GAMEOVER,
        GAMEWIN
    }


    public Level level;
    public Menu menu;
    public Instructions instructions;
    public GameWin gamewin;
    public GameOver gameover;

    static ScreenState state = ScreenState.MENU;

    protected boolean runningThread = true;


    public Console(TextGraphics graphics) {

        this.level = new Level(graphics, this);
        this.menu = new Menu(graphics, this);
        this.instructions = new Instructions(graphics, this);
        this.gamewin = new GameWin(graphics, this);
        this.gameover = new GameOver(graphics, this);

    }



    public void addKeyBoardListener(KeyBoardObserver obs) {
        ((AWTTerminalFrame) Game.getScreen().getTerminal()).getComponent(0).addKeyListener(obs);
    }

    public void run(Game game){
        while (runningThread) {
            switch (state) {
                case MENU -> {
                    menu.run();
                }
                case LEVEL -> {
                    level.run();
                }
                case INSTRUCTIONS -> {
                    instructions.run();
                }
                case CLOSE -> {
                    runningThread = false;
                    close();
                }
                case GAMEWIN -> {
                    gamewin.run();
                }
                case GAMEOVER -> {
                    gameover.run();
                }

            }
        }
        close();
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
        return runningThread;
    }

    public ScreenState getState() {
        return state;
    }

    public void setState(ScreenState state) {
        this.state = state;
    }

    public void setGameStatus(boolean gameStatus) {
        this.runningThread = gameStatus;
    }
}