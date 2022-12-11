package LoZ.GameController.LevelStateController;


import LoZ.Objects.*;
import LoZ.Objects.Attributes.Life;
import LoZ.Objects.Attributes.Position;
import LoZ.Objects.Attributes.Size;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import static LoZ.GameController.ScreenController.LevelController.colorScenario;


public class Level {

    Size screenSize;

    private Player player;

    private PoolEnemies enemies;

    private PoolBullets bullets;

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
        Bullet enemyBullet = new Bullet(new Position(0,0), new Size(1,1), new TextColor.RGB(255, 0, 0), new Life(1), true);

        this.enemies = new PoolEnemies();
        this.enemies.addEnemy(new Enemy(enemyPosition, enemySize, enemyColor, enemyLife, enemyBullet));

        bullets = new PoolBullets();

    }

    public void draw() {

        screen.setBackgroundColor(colorScenario);
        screen.fillRectangle(new TerminalPosition(0,0), new TerminalSize(screenSize.getWidth(), screenSize.getHeight()), ' ');

        player.draw(screen);
        enemies.drawEnemies(screen);
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
        moveBullet();

    }
    public void moveEnemy() {
        this.enemies.moveEnemiesToPlayer(this.screenSize.getWidth(),this.screenSize.getHeight(), player, bullets);
        this.enemies.checkCollision(bullets, player);
    }

    public void moveBullet() {
        this.bullets.moveBullets(this.screenSize.getWidth(),this.screenSize.getHeight());
        this.bullets.checkCollision(enemies, player);
    }

    public boolean EnemiesAreDefetead(){
        return !enemies.leftAtLeastOneEnemy();
    }

    public boolean playerIsAlive(){
        return player.isAlive();
    }

}