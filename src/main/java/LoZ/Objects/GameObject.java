package LoZ.Objects;

import LoZ.Game;
import LoZ.Objects.Attributes.Life;
import LoZ.Objects.Attributes.Position;
import LoZ.Objects.Attributes.Size;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.concurrent.TimeUnit;

abstract public class GameObject {
    Position position;
    Size size;
    private final TextColor color;
    private  Life life;

    int speed;

    public GameObject(Position position, Size size, TextColor color, Life life, int speed) {
        this.speed = speed;
        this.position = position;
        this.size = size;
        this.color = color;
        this.life = life;
    }

    public void draw(TextGraphics screen) {
        if (!life.isAlive()){
            return;
        }
        screen.setForegroundColor(this.color);
        for (int i = 0; i < size.getWidth(); i++) {
            for (int j = 0; j < size.getHeight(); j++) {
                screen.putString(position.getxPos()+i, position.getyPos()+j, "a");

            }

        }
        screen.putString(position.getxPos(), position.getyPos(), "a");
    }

    public void moveRight(int width){
        if((this.position.getxPos() + this.size.getWidth()) < width && life.isAlive())
            this.position.setxPos(+1);
        try {
            TimeUnit.MILLISECONDS.sleep(Game.refreshTime/speed);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void moveLeft(){
        if(this.position.getxPos() > 0 && this.life.isAlive())
            this.position.setxPos(-1);
        try {
            TimeUnit.MILLISECONDS.sleep(Game.refreshTime/speed);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void moveDown(){
        if(this.position.getyPos() > 0 && this.life.isAlive())
            this.position.setyPos(-1);
        try {
            TimeUnit.MILLISECONDS.sleep(Game.refreshTime/speed);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void moveUp(int height){
        if((this.position.getyPos() + this.size.getHeight()) < height && this.life.isAlive())
            this.position.setyPos(+1);
        try {
            TimeUnit.MILLISECONDS.sleep(Game.refreshTime/speed);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void checkCollision(GameObject otherObject){
        if(!this.life.isAlive()  || !otherObject.life.isAlive()){
            return;
        }
        if (this.position.hasCollision(otherObject.position, otherObject.size, this.size)){
            this.life.kill();
            otherObject.life.kill();
        }
    }
    public Position getPosition() {
        return position;
    }

    public boolean isAlive(){
        return life.isAlive();
    }
}
