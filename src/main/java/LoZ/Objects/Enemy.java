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
    public void moveTowardsPlayer(int width, int height, Player player, PoolBullets poolBullets){
        double rand = Math.random() * 4;
        doAttack(poolBullets);
        if (rand>3) {
            moveRandom(width, height);
        }
        else if(rand>2) {
            if(player.getPosition().getxPos() > this.position.getxPos()){
                this.moveRight(height);
            }
            else if(player.getPosition().getxPos() < this.position.getxPos()){
                this.moveLeft();
            }
        }
        else if(rand > 1 ) {
            if(player.getPosition().getyPos() > this.position.getyPos()){
                this.moveRight(width);
            }
            else if(player.getPosition().getyPos() < this.position.getyPos()){
                this.moveLeft();
            }
        }
        else{
            doAttack(poolBullets);
            System.out.println("Attack");
        }
    }
    public void moveRandom(int width, int height){
        double rand = Math.random() * 4;
        if (rand>3) {
            moveLeft();
        }
        else if(rand>2) {
            moveRight(width);
        }
        else if(rand > 1 ) {
            moveUp(height);
        }
        else{
            moveDown();
        }
    }

    public void doAttack(PoolBullets poolBullets){
        Bullet bullet = attackType.returnCopy();
        bullet.position.setxPos(this.position.getxPos());
        bullet.position.setyPos(this.position.getyPos());
        poolBullets.addBullet(bullet);
    }
}
