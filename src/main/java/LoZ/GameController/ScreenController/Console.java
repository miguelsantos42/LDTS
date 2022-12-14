package LoZ.GameController.ScreenController;

import LoZ.GameController.LevelStateController.Level;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
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

    public static TerminalPosition lastMovement = new TerminalPosition(0, 0);

    public void keyPressed(Action action) {
        switch (action) {
            case LEFT:
                level.movePlayerLeft();
                lastMovement = lastMovement.withRelativeColumn(-1);
                break;
            case RIGHT:
                level.movePlayerRight();
                lastMovement = lastMovement.withRelativeColumn(1);
                break;
            case DOWN:
                level.movePlayerDown();
                lastMovement = lastMovement.withRelativeRow(1);
                break;
            case UP:
                level.movePlayerUp();
                lastMovement = lastMovement.withRelativeRow(-1);
                break;
            case ATTACK:
                level.playerAttack();
                break;
            case DEFFEND:
                break;
            case QUIT:
                exitThread = true;
                break;
        }
    }

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


    public void run() {

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
                }
            }catch (InterruptedException e){
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
            exitThread = true;
        }
        if(!this.level.EnemiesAreDefetead()){
            exitThread = true;
        }
    }

}