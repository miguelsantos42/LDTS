package LoZ;

import LoZ.GameController.ScreenController.KeyBoardObserver;
import LoZ.GameController.ScreenController.LevelController;
import LoZ.Menu.Play;
import com.googlecode.lanterna.TextColor;
import LoZ.Menu.Instructions;
import LoZ.Menu.Menu;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

//Game
public class Game{

    private static KeyBoardObserver keyBoardObserver;
    public LevelController levelController;
    private final Play play;
    private final Instructions instructions;
    public static Menu menu;

    private static Game game = null;
    protected static boolean exit;

    public static int state = 1;
    public static Font font;

    /*Constants*/
    public static final int refreshTime = 1000;
    public static final String fontPath = "square.ttf";

    /*Colors of the game*/
    public static final TextColor colorMonster =  new TextColor.RGB(0,200,50);
    public static final TextColor colorPlayer =  new TextColor.RGB(255, 255, 255);
    public static final TextColor colorScenario = new TextColor.RGB(15,20,45);

    private Game() throws URISyntaxException, FontFormatException, IOException {
        /*      Import font of the game     */
        URL resource = getClass().getClassLoader().getResource(fontPath);
        File fontFile = new File(resource.toURI());
        font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        this.menu = new Menu();
        this.levelController = new LevelController();
        this.play = new Play();
        this.instructions = new Instructions();

        keyBoardObserver = new KeyBoardObserver();
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
        menu.start();
        do {
            switch (state) {
                case 1 -> menu.run();
                case 2 -> play.run();
                case 3 -> instructions.run();
                case 4 -> exit = true;
            }
        } while (!exit);
        LoZ.Menu.State.close();
    }

    public static void main(String[] args) throws URISyntaxException, FontFormatException, IOException {
        game = getInstance();
        game.start();
    }
}