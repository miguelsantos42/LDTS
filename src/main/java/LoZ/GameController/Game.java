package LoZ.GameController;

import LoZ.GameController.ScreenController.Console;
import LoZ.GameController.ScreenController.KeyBoardObserver;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

//Play
public class Game {


    public static final int width = 64;
    public static final int height = 36;

    TerminalSize terminalSize = new TerminalSize(width, height);

    TextGraphics graphics;

    public static Console console;

    public static final TextColor colorScenario = new TextColor.RGB(15,20,45);

    public static TerminalScreen getScreen(){return screen;}



    private static KeyBoardObserver keyBoardObserver;

    private static Game game = null;

    public static int state = 1;


    /*Constants*/
    public static final int refreshTime = 1000;




    private Game() throws URISyntaxException, FontFormatException, IOException {

        keyBoardObserver = new KeyBoardObserver();

        int sizeFont = 20;

        createTerminal(sizeFont, terminalSize);
        graphics = screen.newTextGraphics();
        console = new Console(graphics);
        console.addKeyBoardListener(getKeyBoardObserver());
    }


    public static Game getInstance() throws URISyntaxException, FontFormatException, IOException {
        if(game == null){
            game = new Game();
        }
        return game;
    }

    public KeyBoardObserver getKeyBoardObserver() {
        return keyBoardObserver;
    }

    //

    public void start() throws IOException, URISyntaxException, FontFormatException {
        console.level.run(game, console);
    }

    public static void main(String[] args) throws URISyntaxException, FontFormatException, IOException {
        game = getInstance();
        game.start();
    }

    protected static TerminalScreen screen;
    public static Font font;
    public static final String fontPath = "square.ttf";

    protected void createTerminal(int sizeFont, TerminalSize terminalSize){

        try {
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);

            terminalFactory.setTerminalEmulatorTitle("Legend of Zelda");

            /*      Import font of the game     */
            URL resource = getClass().getClassLoader().getResource(fontPath);
            File fontFile = new File(resource.toURI());
            font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
            Font loadedFont = font.deriveFont(Font.PLAIN, sizeFont);

            AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);
            terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);
            terminalFactory.setForceAWTOverSwing(true);

            Terminal terminal = terminalFactory.createTerminal();

            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null);
            screen.startScreen();
            screen.doResizeIfNecessary();


        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (FontFormatException e) {
            e.printStackTrace();
        }
    }

    public void clear() {
        screen.clear();
    }

    public void refresh() throws IOException {
        screen.refresh();
        screen.doResizeIfNecessary();
    }

    public static void close() throws IOException {

        screen.close();
    }

    protected void draw(){
        try {
            clear();
            drawText();
            refresh();
            TimeUnit.MILLISECONDS.sleep(20);
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }

    protected void drawText(){}
}