package LoZ.GameController.ScreenStates;

import LoZ.GameController.ScreenController.Console;
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

    public void keyPressed(LoZ.GameController.ScreenController.Console.Action action) {

        switch (action) {
            case QUIT:
                console.setState(LoZ.GameController.ScreenController.Console.ScreenState.MENU);
                console.setGameStatus(false);
                break;
        }
        if (action != LoZ.GameController.ScreenController.Console.Action.QUIT && action != LoZ.GameController.ScreenController.Console.Action.DEFFEND && action != LoZ.GameController.ScreenController.Console.Action.ATTACK) {
            LoZ.GameController.ScreenController.Console.lastMovement = action;
        }
    }


}