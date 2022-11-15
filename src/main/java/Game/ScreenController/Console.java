package Game.ScreenController;

import Game.LevelStateController.KeyBoardObserver;
import Game.LevelStateController.Level;
import Objects.Player;
import Objects.Position;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFrame;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Console{

    public enum Action{
        UP,
        DOWN,
        LEFT,
        RIGHT,
        ATTACK,
        DEFFEND
    }

    protected Level level;
    protected boolean exitThread = false;


    public Console(TextGraphics graphics) {

        Player player = new Player(new Position(10,10));

        this.level = new Level(graphics, player);

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