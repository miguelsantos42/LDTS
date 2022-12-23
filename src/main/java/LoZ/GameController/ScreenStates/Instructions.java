package LoZ.GameController.ScreenStates;

import LoZ.GameController.ScreenController.Console;
import LoZ.GameController.ScreenController.KeyBoardObserver;
import com.googlecode.lanterna.graphics.TextGraphics;


import java.io.IOException;


public class Instructions {

    private TextGraphics screen;
    Console console;

    public Instructions(TextGraphics screen, Console console){
        this.screen = screen;
        this.console = console;
    }
    public void run() throws IOException {


    }

    public void keyPressed(KeyBoardObserver.Action action) {

        switch (action) {
            case QUIT:
                console.setState(Console.ScreenState.MENU);
                console.setGameStatus(false);
                break;
        }
        if (action != KeyBoardObserver.Action.QUIT && action != KeyBoardObserver.Action.DEFFEND && action != KeyBoardObserver.Action.ATTACK) {
            KeyBoardObserver.lastMovement = action;
        }
    }


}