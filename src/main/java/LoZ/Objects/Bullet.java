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


    public Bullet(Position position, Size size, TextColor textColor, Life life) {
        super(position, size, textColor, life, SHOT_VELOCITY);
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
    }

    public boolean isValid() {
        return valid;
    }

    public boolean isEnemy() {
        return isEnemyBullet;
    }


}