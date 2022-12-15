package LoZ.GameController.LevelStateController;


import LoZ.GameController.ScreenController.Console;
import LoZ.Objects.*;
import LoZ.Objects.Attributes.Life;
import LoZ.Objects.Attributes.Position;
import LoZ.Objects.Attributes.Size;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import static LoZ.GameController.ScreenController.LevelController.*;


public class Level {

    Size screenSize;

    private Player player;

    private PoolEnemies enemies;

    private PoolBullets bullets;

    private PoolPowerUps powerups;

    public static TextGraphics screen;

    private final TextColor playerColor = new TextColor.RGB(255, 255, 255);
    private final TextColor enemyColor = new TextColor.RGB(135, 122, 56);

    private final TextColor bulletEnemyColor = new TextColor.RGB(255, 0, 0);

    private final TextColor bulletPlayerColor = new TextColor.RGB(148, 0, 211);

    private final TextColor powerupColor = new TextColor.RGB(50, 205, 50);

    Enemy typeEnemy;
    PowerUp typePowerUp;

    Bullet enemyBullet;
    Bullet playerBullet;

    public Level(TextGraphics screen){
        Level.screen = screen;
        screenSize = new Size(screen.getSize().getRows(), screen.getSize().getColumns()) ;

        Position playerPosition = new Position(10,10);
        Size playerSize = new Size(3,3);

        Life playerLife = new Life(2);
        playerBullet = new Bullet(new Position(0,0), new Size(1,1), bulletPlayerColor, new Life(1), false, Bullet.Direction.STOP);
        this.player = new Player(playerPosition, playerSize, playerColor, playerLife, playerBullet);

        Position enemyPosition = new Position(20,20);
        Size enemySize = new Size(2,2);
        Life enemyLife = new Life(2);
        enemyBullet = new Bullet(new Position(0,0), new Size(1,1), bulletEnemyColor, new Life(1), true, Bullet.Direction.STOP);

        typeEnemy = new Enemy(enemyPosition, enemySize, enemyColor, enemyLife, enemyBullet);

        Position powerupPosition = new Position(20,20);
        Size powerupSize = new Size(1,1);
        Life powerupLife = new Life(1);
        enemyBullet = new Bullet(new Position(0,0), new Size(1,1), bulletEnemyColor, new Life(1), true, Bullet.Direction.STOP);

        typePowerUp = new PowerUp(powerupPosition, powerupSize, powerupColor, powerupLife);

        this.enemies = new PoolEnemies(typeEnemy);
        bullets = new PoolBullets(enemyBullet);
        powerups = new PoolPowerUps(typePowerUp);


        this.enemies.addEnemy(typeEnemy, player, screenSize.getWidth(), screenSize.getHeight());
        //this.powerups.addPowerUp(typePowerUp, player, screenSize.getWidth(), screenSize.getHeight());


    }

    public void draw() {

        screen.setBackgroundColor(colorScenario);
        screen.fillRectangle(new TerminalPosition(0,0), new TerminalSize(screenSize.getWidth(), screenSize.getHeight()), ' ');

        player.draw(screen);
        enemies.drawEnemies(screen);
        bullets.drawBullets(screen);
        player.drawInfo(screen);
    }

    private void drawInfo(){
    }

    public void movePlayerLeft(){
        this.player.moveLeft();
        checkPlayerCollisions();
    }
    public void movePlayerRight(){
        this.player.moveRight(this.screenSize.getWidth());
        checkPlayerCollisions();
    }
    public void movePlayerUp(){
        this.player.moveUp(this.screenSize.getHeight());
        checkPlayerCollisions();
    }
    public void movePlayerDown(){
        this.player.moveDown();
        checkPlayerCollisions();
    }

    public void playerAttack(Console.Action lastAction){
        this.player.doAttack(bullets, lastAction);
    }


    public void enemyAction(){
        this.enemies.moveEnemiesToPlayer(this.screenSize.getWidth(),this.screenSize.getHeight(), player, bullets);
        maybeAddEnemy();
        checkAllCollisions();
    }

    public void bulletsAction() {
        this.bullets.moveBullets(this.screenSize.getWidth(), this.screenSize.getHeight());
        checkAllCollisions();
    }

    public void checkAllCollisions(){
        for (Enemy enemy : this.enemies.getPoolEnemy()) {
            for(Bullet bullet : this.bullets.getPoolBullets()){
                if (!bullet.isEnemy()) {
                    bullet.checkCollision(enemy, 0);
                }
            }
            enemy.checkCollision(this.player, 0);
        }
        for (Bullet bullet : this.bullets.getPoolBullets()) {
            if (bullet.isEnemy()) {
                bullet.checkCollision(this.player, 0);
            }
        }
    }
    public void checkPlayerCollisions(){
        for (Enemy enemy : this.enemies.getPoolEnemy()) {
            enemy.checkCollision(this.player, 0);
        }
        for (Bullet bullet : this.bullets.getPoolBullets()) {
            if (bullet.isEnemy()) {
                bullet.checkCollision(this.player, 0);
            }
        }
        for (PowerUp powerup : this.powerups.getPoolPowerUps()) {
            powerup.checkCollision(this.player, 1);
        }
    }

    public void maybeAddEnemy(){
        if (Math.random()*100 >95){
            this.enemies.addEnemy(this.typeEnemy, this.player, this.screenSize.getWidth(), this.screenSize.getHeight());
        };
    }

    public boolean EnemiesAreDefetead(){
        return !enemies.leftAtLeastOneEnemy();
    }

    public boolean playerIsAlive(){
        return player.isAlive();
    }

}