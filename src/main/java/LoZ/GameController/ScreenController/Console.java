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

    protected Level level;
    protected boolean exitThread = false;


    public Console(TextGraphics graphics) {

        this.level = new Level(graphics, this);

    }

    public static Action lastMovement = Action.LEFT;


    public void run(Game levelController) {

        Thread enemyThread = new Thread(() -> {
            while(!exitThread) {
                level.enemyAction();
                level.draw(this);
            }
        });

        Thread bulletsThread = new Thread(() -> {
            while(!exitThread) {
                level.bulletsAction();
                level.draw(this);
            }
        });

        enemyThread.start();
        bulletsThread.start();

        new Thread(() -> {
            try {

                while (!exitThread){
                    Thread.sleep(800);
                    checkGameStatus();
                }
            }catch (InterruptedException | IOException e){
                e.printStackTrace();
            }

        }).start();
    }


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

    private void checkGameStatus() throws IOException {
        if(!this.level.playerIsAlive()){
            close();
        }
        if(this.level.EnemiesAreDefetead()){
            exitThread = true;
        }
    }

    public void close() {
        exitThread = true;
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