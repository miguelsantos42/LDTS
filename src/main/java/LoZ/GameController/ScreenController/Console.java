package LoZ.GameController.ScreenController;

import LoZ.GameController.LevelStateController.Level;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFrame;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
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

    private void draw(){
        try {
            clear();
            this.level.draw();
            refresh();
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }


    public void run(LevelController levelController) {

        Thread enemyThread = new Thread(() -> {
            while(!exitThread) {
                level.enemyAction();
                draw();
            }
        });

        Thread bulletsThread = new Thread(() -> {
            while(!exitThread) {
                level.bulletsAction();
                draw();
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
        ((AWTTerminalFrame) LevelController.getScreen().getTerminal()).getComponent(0).addKeyListener(obs);
    }

    public void clear() {
        LevelController.getScreen().clear();
    }

    public void refresh() throws IOException {
        LevelController.getScreen().refresh();
        LevelController.getScreen().doResizeIfNecessary();
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
            LevelController.getScreen().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean gameStatus() {
        return !exitThread;
    }
}