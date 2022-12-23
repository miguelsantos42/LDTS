package LoZ.GameController.ScreenStates;

import LoZ.Game;
import LoZ.GameController.ScreenController.Console;
import LoZ.GameController.ScreenController.KeyBoardObserver;
import LoZ.Objects.Attributes.Size;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;


import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class GameOver {

    private TextGraphics screen;
    Console console;

    private final TextColor gameoverColorNotSelected = new TextColor.RGB(255, 255, 255);
    private final TextColor gameoverColorSelected = new TextColor.RGB(15, 20, 45);

    int column;
    int row;
    Size screenSize;

    public GameOver(TextGraphics screen, Console console){
        this.screen = screen;
        this.console = console;

        screenSize = new Size(screen.getSize().getRows(), screen.getSize().getColumns()) ;
        column = (screenSize.getWidth()/2)-3;
        row = screenSize.getHeight()/4;
    }
    public void run(){
        while(console.getState() == Console.ScreenState.GAMEOVER && console.gameStatus()){
            draw();
        }
    }

    public void keyPressed(KeyBoardObserver.Action action) {

        switch (action) {
            case QUIT:
                console.setState(Console.ScreenState.MENU);
                console.setGameStatus(false);
                break;

            case SELECT:
                console.setState(Console.ScreenState.MENU);
                break;
        }
    }

    protected void draw(){
        try {
            screen.setBackgroundColor(gameoverColorSelected);
            screen.setForegroundColor(gameoverColorNotSelected);

            screen.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(screenSize.getWidth(), screenSize.getHeight()), ' ');

            /*Actual Instructions*/

            screen.putString(column, row, "GAME OVER!", SGR.BOLD);

            screen.putString(2, row+3, "You have died.", SGR.BOLD);
            screen.putString(1, row+4, "Press Q to quit or M to go back to the menu.", SGR.BOLD);


            screen.setForegroundColor(gameoverColorNotSelected);

            console.refresh();
            TimeUnit.MILLISECONDS.sleep(20);
        }
        catch(InterruptedException | IOException e){
            e.printStackTrace();
        }
    }


}
