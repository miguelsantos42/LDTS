package LoZ.Objects;

import LoZ.Objects.Attributes.Life;
import LoZ.Objects.Attributes.Position;
import LoZ.Objects.Attributes.Size;
import com.googlecode.lanterna.TextColor;

import java.util.concurrent.TimeUnit;

public class Enemy extends GameObject{

    Bullet attackType;

    public Enemy(Position position, Size size, TextColor textColor, Life life, Bullet bulletType) {
        super(position, size, textColor, life, 100);
        this.attackType = bulletType;
    }

    public Enemy(Enemy enemy){
        super(new Position(enemy.position.getxPos(), enemy.position.getyPos()),
                new Size(enemy.size.getWidth(), enemy.size.getHeight()),
                new TextColor.RGB(enemy.color.toColor().getRed(),
                        enemy.color.toColor().getGreen(),
                        enemy.color.toColor().getBlue()),
                new Life(enemy.life.getMaximumLives()), enemy.speed);
        this.attackType = new Bullet(enemy.attackType);
    }

    public void ActionAgainstPlayer(int width, int height, Player player, PoolBullets poolBullets, double randomState){
        if (randomState>3.5) {
            double rand = Math.random() * 4;
            moveRandom(width, height, rand);
        }
        else if(randomState>2) {
            if(player.getPosition().getxPos() > this.position.getxPos()){
                this.moveRight(width);
            }
            else if(player.getPosition().getxPos() < this.position.getxPos()){
                this.moveLeft();
            }
        }
        else if(randomState > 0.5) {
            if(player.getPosition().getyPos() > this.position.getyPos()){
                this.moveUp(height);
            }
            else if(player.getPosition().getyPos() < this.position.getyPos()){
                this.moveDown();
            }
        }
        else{
            doAttack(poolBullets, player);
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void moveRandom(int width, int height, double randomState){

        if (randomState>3) {
            moveLeft();
        }
        else if(randomState>2) {
            moveRight(width);
        }
        else if(randomState > 1 ) {
            moveUp(height);
        }
        else{
            moveDown();
        }
    }

    public void doAttack(PoolBullets poolBullets, Player player){
        Bullet bullet = new Bullet(attackType);
        Size distance = calculateDistance(player);

        bullet.position.setxPos(this.position.getxPos());
        bullet.position.setyPos(this.position.getyPos());

        if (Math.abs(distance.getHeight()) > Math.abs(distance.getWidth())){
            if (distance.getHeight() > 0){
                bullet.direction = Bullet.Direction.LEFT;
                bullet.position.setyPos(-1);
            }
            else{
                bullet.direction = Bullet.Direction.RIGHT;
                bullet.position.setxPos(this.size.getWidth());
            }
        }

        else if ((Math.abs(distance.getHeight()) < Math.abs(distance.getWidth())) || (Math.abs(distance.getHeight()) == Math.abs(distance.getWidth()))){
            if (distance.getWidth() > 0){
                bullet.direction = Bullet.Direction.DOWN;
                bullet.position.setxPos(this.size.getHeight());
            }
            else{
                bullet.direction = Bullet.Direction.UP;
                bullet.position.setxPos(-1);
            }
        }

        poolBullets.addBullet(bullet);
    }

    public Enemy returnCopy(){
        Enemy Enemy = new Enemy(this);
        return Enemy;
    }

    public void copy(Enemy enemy){
        this.position = new Position(enemy.position);
        this.size = new Size(enemy.size);
        super.color = new TextColor.RGB(enemy.color.toColor().getRed(),
                enemy.color.toColor().getGreen(),
                enemy.color.toColor().getBlue());
        this.life = new Life(enemy.life);
        this.speed = enemy.speed;
        this.attackType = new Bullet(enemy.attackType);

    }

}
