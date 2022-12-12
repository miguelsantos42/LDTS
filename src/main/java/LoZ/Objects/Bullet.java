package LoZ.Objects;

import LoZ.Objects.Attributes.Life;
import LoZ.Objects.Attributes.Position;
import LoZ.Objects.Attributes.Size;
import com.googlecode.lanterna.TextColor;

public class Bullet extends GameObject{

    public enum Direction{
        LEFT, RIGHT, STOP, UP, DOWN
    }

    private String sprite;
    private boolean valid;
    private boolean isEnemyBullet;

    protected static final int SHOT_VELOCITY = 20;

    public Direction direction = Direction.STOP;


    public Bullet(Position position, Size size, TextColor textColor, Life life, Boolean isEnemyBullet, Direction direction) {
        super(position, size, textColor, life, SHOT_VELOCITY);
        valid = false;
        this.isEnemyBullet = isEnemyBullet;
        this.direction = direction;
    }

    public void moveBullet(int widht, int height){
        if(direction == Direction.LEFT){
            moveLeft();
        }
        else if(direction == Direction.RIGHT){
            moveRight(height);
        }
        else if(direction == Direction.UP){
            moveUp(height);
        }
        else if(direction == Direction.DOWN){
            moveDown();
        }
        if (position.getxPos() == 0 || position.getxPos() == widht || position.getyPos() == 0 || position.getyPos() == height){
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
        Position newPosition = new Position(position.getxPos(), position.getyPos());
        Size newSize = new Size(size.getWidth(), size.getHeight());
        TextColor newTextColor = new TextColor.RGB(color.toColor().getRed(), color.toColor().getGreen(), color.toColor().getBlue());
        Life newLife = new Life(life.getMaximumLives());

        Bullet bullet = new Bullet(newPosition, newSize, newTextColor, newLife, this.isEnemyBullet, Bullet.Direction.STOP);

        bullet.sprite = this.sprite;
        bullet.valid = this.valid;
        bullet.isEnemyBullet = this.isEnemyBullet;
        bullet.direction = this.direction;
        return bullet;
    }
}