package LoZ.GameController.ScreenController;

import LoZ.Game;
import LoZ.GameController.LevelStateController.Level;

import LoZ.GameController.Menu.Play;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
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

    public static Action lastMovement = Action.LEFT;

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
                level.playerAttack(lastMovement);
                break;
            case DEFFEND:
                break;
            case QUIT:
                close();

                break;
        }
        if (action != Action.QUIT && action != Action.DEFFEND && action != Action.ATTACK) {
            lastMovement = action;
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

    private void gameOver(){

        try{
            clear();
            TextGraphics graphics = Play.getScreen().newTextGraphics();

            graphics.setBackgroundColor(Game.colorScenario);
            graphics.setForegroundColor(Game.colorPlayer);
            graphics.fillRectangle(new TerminalPosition(0,0), new TerminalSize(Play.width, Play.height), ' ');
            graphics.putString(Play.width/2-5,Play.height/2, "GAME OVER");

            //Reminder of how to quit the game
            graphics.putString(Play.width-9, Play.height-2, "Q: QUIT");

            Play.getScreen().refresh();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    private void gameWin(){

        try{
            clear();
            TextGraphics graphics = Play.getScreen().newTextGraphics();

            graphics.setBackgroundColor(Game.colorScenario);
            graphics.setForegroundColor(Game.colorPlayer);
            graphics.fillRectangle(new TerminalPosition(0,0), new TerminalSize(Play.width, Play.height), ' ');
            graphics.putString(Play.width/2-5,Play.height/2, "YOU WIN!");

            //Reminder of how to quit the game
            graphics.putString(Play.width-9, Play.height-2, "Q: QUIT");

            Play.getScreen().refresh();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void checkGameStatus() throws IOException {
        if(!this.level.playerIsAlive()){
            exitThread = true;
            gameOver();
        }
        if(this.level.EnemiesAreDefetead()){
            exitThread = true;
            gameWin();
        }
    }

    void close() {
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