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
    TextColor color;
    Life life;

    int speed;

    public GameObject(Position position, Size size, TextColor color, Life life, int speed) {
        this.speed = 1000/speed;
        this.position = new Position(position);
        this.size = new Size(size);
        this.color = new TextColor.RGB(color.toColor().getRed(), color.toColor().getGreen(), color.toColor().getBlue());
        this.life = new Life(life);
    }

    public GameObject(GameObject other) {
        this.speed = other.speed;
        this.position = new Position(other.position);
        this.size = new Size(other.size);
        this.color = new TextColor.RGB(other.color.toColor().getRed(), other.color.toColor().getGreen(), other.color.toColor().getBlue());
        this.life = new Life(other.life);
    }

    public void draw(TextGraphics screen) {
        if (!life.isAlive()){
            return;
        }
        screen.setForegroundColor(this.color);
        for (int i = 0; i < size.getWidth(); i++) {
            for (int j = 0; j < size.getHeight(); j++) {
                screen.putString(position.getxPos()+i, position.getyPos()+j, "&");

            }

        }
        screen.putString(position.getxPos(), position.getyPos(), "&");
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

    public boolean checkCollision(GameObject otherObject){
        if(!this.life.isAlive()  || !otherObject.life.isAlive()){
            return false;
        }
        return this.position.hasCollision(otherObject.position, otherObject.size, this.size);
    }
    public Position getPosition() {
        return position;
    }

    public boolean isAlive(){
        return life.isAlive();
    }

    public void instantKill(){
        this.life.instantKill();
    }

    public void kill(){
        this.life.kill();
    }

    public void heal(){
        this.life.heal();
    }

    public Life getLife() {
        return life;
    }

    public Size calculateDistance(GameObject otherObject){
        return this.position.calculateDistance(otherObject.position);
    }


    public Size getSize() {
        return size;
    }
}
