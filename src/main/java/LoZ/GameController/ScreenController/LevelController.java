package LoZ.GameController.ScreenController;

import LoZ.Game;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;


import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
//Play
public class LevelController extends GameScreen{

    TextGraphics graphics;
    public static final int width = 100;
    public static final int height = 50;
    TerminalSize terminalSize = new TerminalSize(width, height);
    public Console console;

    public static final TextColor colorScenario = new TextColor.RGB(15,20,45);

    public void run() throws IOException, URISyntaxException, FontFormatException {
        int sizeFont = 20;

        createTerminal(sizeFont, terminalSize);
        graphics = screen.newTextGraphics();
        console = new Console(graphics);
        console.addKeyBoardListener(Game.getInstance().getKeyBoardObserver());
        console.run();

        while(gameStatus()){
            Game.getInstance().getKeyBoardObserver().setConsole(console);
        }


    }

    public boolean gameStatus(){
        return console.gameStatus();
    }

    public static TerminalScreen getScreen(){return screen;}
}