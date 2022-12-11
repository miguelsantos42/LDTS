package LoZ.Objects;

import LoZ.Game;
import LoZ.Objects.Attributes.Life;
import LoZ.Objects.Attributes.Position;
import LoZ.Objects.Attributes.Size;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Bullet extends GameObject{



    public enum Direction{
        LEFT, RIGHT, STOP, UP, DOWN
    }

    private String sprite;
    private boolean valid;
    private boolean isEnemyBullet;

    protected static final int SHOT_VELOCITY = 700;

    protected Direction moveDirection = Direction.STOP;


    public Bullet(Position position, Size size, TextColor textColor, Life life, Boolean isEnemyBullet) {
        super(position, size, textColor, life, SHOT_VELOCITY);
        valid = false;
        this.isEnemyBullet = isEnemyBullet;
    }

    public void moveBullet(int widht, int height){
        if(moveDirection == Direction.LEFT){
            moveLeft();
        }
        else if(moveDirection == Direction.RIGHT){
            moveRight(height);
        }
        else if(moveDirection == Direction.UP){
            moveUp(height);
        }
        else if(moveDirection == Direction.DOWN){
            moveDown();
        }
        if (position.getxPos() < 0 || position.getxPos() > widht || position.getyPos() < 0 || position.getyPos() > height){
            valid = false;
        }
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public boolean isEnemy() {
        return isEnemyBullet;
    }

    public Bullet returnCopy(){
        Bullet bullet = new Bullet(this.position, this.size, super.color, this.life, this.isEnemyBullet);
        bullet.sprite = this.sprite;
        bullet.valid = this.valid;
        bullet.isEnemyBullet = this.isEnemyBullet;
        bullet.moveDirection = this.moveDirection;
        return bullet;
    }
}