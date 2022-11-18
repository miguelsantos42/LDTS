package LoZ.GameController.LevelStateController;


import LoZ.Objects.Attributes.Life;
import LoZ.Objects.Attributes.Position;
import LoZ.Objects.Attributes.Size;
import LoZ.Objects.Player;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;


import static LoZ.Game.colorScenario;
//LEVEL
public class Level {

    Size screenSize;
    private Player player;

    public static TextGraphics screen;

    public Level(TextGraphics screen){
        Level.screen = screen;
        screenSize = new Size(screen.getSize().getRows(), screen.getSize().getColumns()) ;

        Position playerPosition = new Position(10,10);
        Size playerSize = new Size(3,3);
        TextColor playerColor = new TextColor.RGB(255, 255, 255);
        Life playerLife = new Life(10);
        this.player = new Player(playerPosition, playerSize, playerColor, playerLife);
    }

    public void draw() {

        screen.setBackgroundColor(colorScenario);
        screen.fillRectangle(new TerminalPosition(0,0), new TerminalSize(screenSize.getWidth(), screenSize.getHeight()), ' ');
        player.draw(screen);

    }

    private void drawInfo(){
    }

    public void movePlayerLeft(){
        this.player.moveLeft();
    }
    public void movePlayerRight(){
        this.player.moveRight(this.screenSize.getWidth());
    }
    public void movePlayerUp(){
        this.player.moveUp(this.screenSize.getHeight());
    }
    public void movePlayerDown(){
        this.player.moveDown();
    }




}