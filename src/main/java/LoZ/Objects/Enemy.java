package LoZ.Objects;

import LoZ.Objects.Attributes.Life;
import LoZ.Objects.Attributes.Position;
import LoZ.Objects.Attributes.Size;
import com.googlecode.lanterna.TextColor;

public class Enemy extends GameObject{

    Bullet attackType;
    public Enemy(Position position, Size size, TextColor textColor, Life life, Bullet bulletType) {
        super(position, size, textColor, life, 100);
        this.attackType = bulletType;
    }
    public void moveTowardsPlayer(int width, int height, Player player, PoolBullets poolBullets, double randomState){
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
        Bullet bullet = attackType.returnCopy();
        bullet.position.setxPos(this.position.getxPos());
        bullet.position.setyPos(this.position.getyPos());
        bullet.setValid(true);
        Size distance = calculateDistance(player);
        if (Math.abs(distance.getHeight()) > Math.abs(distance.getWidth())){
            if (distance.getHeight() > 0){
                bullet.direction = Bullet.Direction.DOWN;
            }
            else{
                bullet.direction = Bullet.Direction.UP;
            }
        }
        else{
            if (distance.getWidth() > 0){
                bullet.direction = Bullet.Direction.LEFT;
            }
            else{
                bullet.direction = Bullet.Direction.RIGHT;
            }
        }
        poolBullets.addBullet(bullet);
    }
}
