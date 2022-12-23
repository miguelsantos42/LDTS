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

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static LoZ.Game.colorScenario;

public class Menu{
    TextGraphics screen;

    Console console;
    int menuOptionSelected = 1;
    int column;
    int row;
    Size screenSize;

    private final TextColor menuColorNotSelected = new TextColor.RGB(255, 255, 255);
    private final TextColor menuColorSelected = new TextColor.RGB(135, 122, 56);

    public Menu(TextGraphics screen, Console console){
        this.screen = screen;
        this.console = console;

        screenSize = new Size(screen.getSize().getRows(), screen.getSize().getColumns()) ;
        column = (screenSize.getWidth()/2)-3;
        row = screenSize.getHeight()/4;
    }
    public void run(){
        while(console.getState() == Console.ScreenState.MENU && console.gameStatus()){
            draw();
        }
    }

    private void draw(){
        try {
            console.clear();
            screen.setBackgroundColor(colorScenario);
            screen.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(screenSize.getWidth(), screenSize.getHeight()), ' ');

            screen.setBackgroundColor(Game.colorScenario);
            screen.setForegroundColor(menuColorNotSelected);
            screen.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(screenSize.getWidth(), screenSize.getHeight()), ' ');

            /*Actual Menu*/

            screen.putString(screenSize.getHeight(), screenSize.getWidth(), "MENU", SGR.BOLD);

            switch (this.menuOptionSelected) {
                case 1 -> {     //PLAY
                    screen.setForegroundColor(menuColorSelected);
                    screen.putString(column - 2, row + 4, "> PLAY");
                    screen.setForegroundColor(menuColorNotSelected);
                    screen.putString(column - 4, row + 6, "INSTRUCTIONS");
                    screen.putString(column, row + 8, "EXIT");
                }
                case 2 -> {     //INSTRUCTIONS
                    screen.putString(column, row + 4, "PLAY");
                    screen.setForegroundColor(menuColorSelected);
                    screen.putString(column - 6, row + 6, "> INSTRUCTIONS");
                    screen.setForegroundColor(menuColorNotSelected);
                    screen.putString(column, row + 8, "EXIT");
                }
                case 3 -> {     //QUIT
                    screen.putString(column, row + 4, "PLAY");
                    screen.putString(column - 4, row + 6, "INSTRUCTIONS");
                    screen.setForegroundColor(menuColorSelected);
                    screen.putString(column - 2, row + 8, "> EXIT");
                    screen.setForegroundColor(menuColorNotSelected);
                }

            }
            console.refresh();
            TimeUnit.MILLISECONDS.sleep(20);
        }
        catch(InterruptedException | IOException e){
            e.printStackTrace();
        }
    }

    private void moveCursorUp(){
        if(this.menuOptionSelected > 1) {
            this.menuOptionSelected = menuOptionSelected - 1;
        };
    }

    private void moveCursorDown(){
        if(this.menuOptionSelected < 3) {
            this.menuOptionSelected = menuOptionSelected + 1;
        };
    }

    private void select() {
        switch (this.menuOptionSelected) {
            case 1 -> console.setState(Console.ScreenState.LEVEL);
            case 2 -> console.setState(Console.ScreenState.INSTRUCTIONS);
            case 3 -> console.setState(Console.ScreenState.CLOSE);
        }
    }


    public void keyPressed(KeyBoardObserver.Action action) {
        switch (action) {
            case DOWN:
                moveCursorUp();
                break;
            case UP:
                moveCursorDown();
                break;
            case QUIT:
                console.setState(Console.ScreenState.CLOSE);
                console.setGameStatus(false);
                break;
            case SELECT:
                select();
                break;

        }
        if (action != KeyBoardObserver.Action.QUIT && action != KeyBoardObserver.Action.DEFFEND && action != KeyBoardObserver.Action.ATTACK) {
            KeyBoardObserver.lastMovement = action;
        }
    }
}
