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


        this.level = new Level(graphics);

    }


    public void keyPressed(Action action) {
        switch (action) {
            case LEFT:
                level.movePlayerLeft();
                break;
            case RIGHT:
                level.movePlayerRight();
                break;
            case DOWN:
                level.movePlayerDown();
                break;
            case UP:
                level.movePlayerUp();
                break;
            case ATTACK:
                break;
            case DEFFEND:
                break;
            case QUIT:
                break;
        }
        switch (action) {
            case LEFT:
                level.moveEnemy();
                break;
            case RIGHT:
                level.moveEnemy();
                break;
            case DOWN:
                level.moveEnemy();
                break;
            case UP:
                level.moveEnemy();
                break;
            case ATTACK:
                break;
            case DEFFEND:
                break;
            case QUIT:
                break;
        }
    }

    private void draw(){
        try {
            clear();
            this.level.draw();
            refresh();
            TimeUnit.MILLISECONDS.sleep(60);
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }


    public void run() {
        Thread DrawnThread = new Thread(() -> {
            while(!exitThread) {
                draw();
            }
        });
        DrawnThread.start();

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

}