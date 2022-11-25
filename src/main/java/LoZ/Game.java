package LoZ;

import LoZ.GameController.ScreenController.KeyBoardObserver;
import LoZ.GameController.ScreenController.LevelController;
import com.googlecode.lanterna.TextColor;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

//Game
public class Game{

    private static KeyBoardObserver keyBoardObserver;
    public LevelController levelController;

    private static Game game = null;

    public static int state = 1;
    public static Font font;

    /*Constants*/
    public static final int refreshTime = 1000;
    public static final String fontPath = "square.ttf";

    private Game() throws URISyntaxException, FontFormatException, IOException {
        /*      Import font of the game     */
        URL resource = getClass().getClassLoader().getResource(fontPath);
        File fontFile = new File(resource.toURI());
        font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        this.levelController = new LevelController();

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



    public void start() throws IOException, URISyntaxException, FontFormatException {
        while (true){
            levelController.run();
        }

    }

    public static void main(String[] args) throws URISyntaxException, FontFormatException, IOException {
        game = getInstance();
        game.start();
    }
}