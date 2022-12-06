package LoZ.Objects.Attributes;

import LoZ.Objects.GameObject;

public class Position{

    int x;
    int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public int getxPos() {
        return x;
    }

    public int getyPos() {
        return y;
    }


    public void setxPos(int xBias) {

        x = x + xBias;
    }


    public void setyPos(int yBias) {

        y = y + yBias;
    }

    public boolean hasCollision(Position otherPosition, Size size){
        if ((otherPosition.getxPos() >= this.x && otherPosition.getxPos() <= this.x + size.getWidth()) &&
                (otherPosition.getyPos() >= this.y && otherPosition.getyPos() <= this.y + size.getHeight())){
            return true;
        }
        else{
            return false;
        }
    }
}
