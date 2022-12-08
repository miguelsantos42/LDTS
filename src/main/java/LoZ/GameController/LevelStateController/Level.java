package LoZ.GameController.LevelStateController;


import LoZ.Objects.Attributes.Life;
import LoZ.Objects.Attributes.Position;
import LoZ.Objects.Attributes.Size;
import LoZ.Objects.Enemy;
import LoZ.Objects.Player;
import LoZ.Objects.PowerUp;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import static LoZ.GameController.ScreenController.LevelController.colorScenario;


public class Level {

    Size screenSize;
    private Player player;
    private Enemy enemy;

    private PowerUp powerup;

    public static TextGraphics screen;

    public Level(TextGraphics screen){
        Level.screen = screen;
        screenSize = new Size(screen.getSize().getRows(), screen.getSize().getColumns()) ;

        Position playerPosition = new Position(10,10);
        Size playerSize = new Size(3,3);
        TextColor playerColor = new TextColor.RGB(255, 255, 255);
        Life playerLife = new Life(10);
        this.player = new Player(playerPosition, playerSize, playerColor, playerLife);

        Position enemyPosition = new Position(20,20);
        Size enemySize = new Size(2,2);
        TextColor enemyColor = new TextColor.RGB(135, 122, 56);
        Life enemyLife = new Life(2);
        this.enemy = new Enemy(enemyPosition, enemySize, enemyColor, enemyLife);

        Position powerupPosition = new Position(5,5);
        Size powerupSize = new Size(1,1);
        TextColor powerupColor = new TextColor.RGB(50, 205, 50);
        Life powerupLife = new Life(1);
        this.powerup = new PowerUp(powerupPosition, powerupSize, powerupColor, powerupLife);
    }

    public void draw() {

        screen.setBackgroundColor(colorScenario);
        screen.fillRectangle(new TerminalPosition(0,0), new TerminalSize(screenSize.getWidth(), screenSize.getHeight()), ' ');
        player.draw(screen);
        enemy.draw(screen);
        powerup.draw(screen);


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

    public void enemyAction(){
        moveEnemy();
    }

    public void bulletsAction(){

    }
    public void moveEnemy() {
        this.enemy.moveRandom(this.screenSize.getWidth(),this.screenSize.getHeight());
        this.enemy.checkCollision(player);
    }

    public boolean EnemyAreDefeated(){
        return enemy.isAlive();
    }

    public boolean playerIsAlive(){
        return player.isAlive();
    }

}