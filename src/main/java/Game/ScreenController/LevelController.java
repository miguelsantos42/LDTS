package Game.ScreenController;

import Game.Game;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;


import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;


public class LevelController extends GameScreen {

    TextGraphics graphics;
    public static final int width = 100;
    public static final int height = 100;
    TerminalSize terminalSize = new TerminalSize(width, height);
    public Console console;


    public void run() throws IOException, URISyntaxException, FontFormatException {
        int sizeFont = 20;


        createTerminal(sizeFont, terminalSize);
        graphics = screen.newTextGraphics();
        console = new Console(graphics);
        console.addKeyBoardListener(Game.getInstance().getKeyBoardObserver());
        console.run();

        while(Game.state == 2){
            Game.getInstance().getKeyBoardObserver().setConsole(console);
        }

    }

    public static TerminalScreen getScreen(){return screen;}
}