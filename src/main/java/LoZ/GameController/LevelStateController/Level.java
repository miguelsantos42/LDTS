package LoZ.GameController.LevelStateController;


import LoZ.Objects.Attributes.Life;
import LoZ.Objects.Attributes.Position;
import LoZ.Objects.Attributes.Size;
import LoZ.Objects.Enemy;
import LoZ.Objects.Player;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import static LoZ.GameController.ScreenController.LevelController.colorScenario;

public class Level {

    Size screenSize;
    private Player player;
    private Enemy enemy;

    public static TextGraphics screen;

    public Level(TextGraphics screen){
        Level.screen = screen;
        screenSize = new Size(screen.getSize().getRows(), screen.getSize().getColumns()) ;

        Position playerPosition = new Position(10,10);
        Size playerSize = new Size(3,3);
        TextColor playerColor = new TextColor.RGB(255, 255, 255);
        Life playerLife = new Life(10);
        this.player = new Player(playerPosition, playerSize, playerColor, playerLife);

        Position enemyPosition = new Position(5,5);
        Size enemySize = new Size(1,1);
        TextColor enemyColor = new TextColor.RGB(135, 122, 56);
        Life enemyLife = new Life(2);
        this.enemy = new Enemy(enemyPosition, enemySize, enemyColor, enemyLife);
    }

    public void draw() {

        screen.setBackgroundColor(colorScenario);
        screen.fillRectangle(new TerminalPosition(0,0), new TerminalSize(screenSize.getWidth(), screenSize.getHeight()), ' ');
        player.draw(screen);
        enemy.draw(screen);

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

    public void moveEnemyLeft(){
        this.enemy.moveLeft();
    }
    public void moveEnemyRight(){
        this.enemy.moveRight(this.screenSize.getWidth());
    }
    public void moveEnemyUp(){
        this.enemy.moveUp(this.screenSize.getHeight());
    }
    public void moveEnemyDown(){
        this.enemy.moveDown();
    }

    public void moveEnemy() {
        if ((Math.random() * (2000))>1500) {
            moveEnemyLeft();
        }
        else if((Math.random() * (2000))>1000) {
            moveEnemyRight();
        }
        else if((Math.random() * (2000))>500) {
            moveEnemyUp();
        }
        else if((Math.random() * (2000))>0) {
            moveEnemyDown();
        }
    }




}