package Game.LevelStateController;


import Objects.Player;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;

import static Game.Game.colorScenario;

public class Level {

    private final int height;
    private final int width;
    protected Player player;


    public static TextGraphics screen;

    public Level(TextGraphics screen, Player player){
        Level.screen = screen;
        this.height = screen.getSize().getRows();
        this.width = screen.getSize().getColumns();
        this.player = player;
    }

    public void draw() {
        screen.setBackgroundColor(colorScenario);
        screen.fillRectangle(new TerminalPosition(0,0), new TerminalSize(width, height), ' ');
        drawInfo();
        player.draw(screen);
    }

    private void drawInfo(){
    }

    public void movePlayerLeft(){
    }
    public void movePlayerRight(){
    }
    public void movePlayerUp(){
    }
    public void movePlayerDown(){
    }




}