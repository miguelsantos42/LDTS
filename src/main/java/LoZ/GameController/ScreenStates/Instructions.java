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


public class Instructions {

    private TextGraphics screen;
    Console console;

    private final TextColor instructionsColorNotSelected = new TextColor.RGB(255, 255, 255);
    private final TextColor instructionsColorSelected = new TextColor.RGB(15, 20, 45);

    int column;
    int row;
    Size screenSize;

    public Instructions(TextGraphics screen, Console console){
        this.screen = screen;
        this.console = console;

        screenSize = new Size(screen.getSize().getRows(), screen.getSize().getColumns()) ;
        column = (screenSize.getWidth()/2)-3;
        row = screenSize.getHeight()/4;
    }
    public void run(){
        while(console.getState() == Console.ScreenState.INSTRUCTIONS && console.gameStatus()){
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
            screen.setBackgroundColor(instructionsColorSelected);
            screen.setForegroundColor(instructionsColorNotSelected);

            screen.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(screenSize.getWidth(), screenSize.getHeight()), ' ');

            /*Actual Instructions*/

            screen.putString(column, row, "INSTRUCTIONS:", SGR.BOLD);

            screen.putString(2, row+3, "KILL ALL THE ENEMIES TO WIN");
            screen.putString(1, row+4, "CAREFUL: YOU ONLY HAVE 2 LIVES");
            screen.putString(3, row+7, "1. PRESS Z TO SHOOT");
            screen.putString(3, row+9, "2. PRESS Arrows TO MOVE");

            screen.setForegroundColor(instructionsColorNotSelected);
            screen.putString(screenSize.getWidth() - 19, screenSize.getHeight()-2, "PRESS M TO GO BACK");

            console.refresh();
            TimeUnit.MILLISECONDS.sleep(20);
        }
            catch(InterruptedException | IOException e){
            e.printStackTrace();
        }
    }


}