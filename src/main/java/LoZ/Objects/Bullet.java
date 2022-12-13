package LoZ.Objects;

import LoZ.Game;
import LoZ.Objects.Attributes.Life;
import LoZ.Objects.Attributes.Position;
import LoZ.Objects.Attributes.Size;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Bullet extends GameObject{
    public static final int LEFT = 1, RIGHT = 2, STOP = 3, UP = 4, DOWN = 5;
    private String sprite;
    private boolean valid;
    private boolean isEnemyBullet;

    protected static final int SHOT_VELOCITY = 700;
    protected boolean move = false;
    //protected int direção = 3;


    public Bullet(Position position, Size size, TextColor textColor, Life life) {
        super(position, size, textColor, life, SHOT_VELOCITY);
    }

    public void moveBullet(){
        if(valid && isEnemyBullet){
            this.position.setyPos(this.position.getyPos() + 1);
        }
        else {
            this.position.setyPos(this.position.getyPos() - 1);
        }

    }

    public void draw(TextGraphics screen) {
        if(valid) screen.putString(position.getxPos(), position.getyPos(), Character.toString(this.sprite.charAt(0)));
    }

    public boolean isValid() {
        return valid;
    }

    /*public void used(Position position, boolean isFromEnemy) {
        this.position = position;
        this.sprite = sprite;
        this.isEnemyBullet = isFromEnemy;
        this.valid = true;
        if (this.isEnemyBullet){
            this.color = Game.colorEnemy;
        }
        else{
            this.color = Game.colorPlayer;
        }
    }*/

    public void notUsed() {
        this.position = outside;
        this.valid = false;
    }

    public boolean isEnemy() {
        return isEnemyBullet;
    }

    public void used(Position position, String z, boolean b) {

    }
}