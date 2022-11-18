package LoZ.GameController.ScreenController;

import LoZ.Game;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;


import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
//Play
public class LevelController extends GameScreen{

    TextGraphics graphics;
    public static final int width = 64;
    public static final int height = 36;
    TerminalSize terminalSize = new TerminalSize(width, height);
    public Console console;


    public void run() throws IOException, URISyntaxException, FontFormatException {
        int sizeFont = 20;

        createTerminal(sizeFont, terminalSize);
        graphics = screen.newTextGraphics();
        console = new Console(graphics);
        console.addKeyBoardListener(Game.getInstance().getKeyBoardObserver());
        console.run();

        while(true){
            Game.getInstance().getKeyBoardObserver().setConsole(console);
        }


    }

    public static TerminalScreen getScreen(){return screen;}
}