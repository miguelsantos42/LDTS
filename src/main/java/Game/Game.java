package Game;

import Game.LevelStateController.KeyBoardObserver;
import Game.ScreenController.LevelController;
import com.googlecode.lanterna.TextColor;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;


public class Game{

    private static KeyBoardObserver keyBoardObserver;
    public LevelController levelController;

    private static Game game = null;
    protected static boolean exit;
    public static int state = 1;
    public static Font font;

    /*Constants*/
    public static final int refreshTime = 1000;
    public static final String fontPath = "square.ttf";
    /*Colors of the Game*/
    public static final TextColor colorPlayer =  new TextColor.RGB(255, 255, 255);
    public static final TextColor colorScenario = new TextColor.RGB(15,20,45);
    private Game() throws URISyntaxException, FontFormatException, IOException {
        /*      Import font of the game     */
        URL resource = getClass().getClassLoader().getResource("square.ttf");
        File fontFile = new File(resource.toURI());
        this.levelController = new LevelController();
        font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

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
        levelController.run();

    }

    public static void main(String[] args) throws URISyntaxException, FontFormatException, IOException {
        game = getInstance();
        game.start();
    }
}