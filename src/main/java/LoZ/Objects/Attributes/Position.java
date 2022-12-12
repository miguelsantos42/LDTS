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

    public boolean hasCollision(Position otherPosition, Size otherSize, Size size){
        if ((otherPosition.getxPos() > this.x && otherPosition.getxPos() < this.x + size.getWidth()) &&
                (otherPosition.getyPos() >=this.y && otherPosition.getyPos() < this.y + size.getHeight())){
            return true;
        }
        else if ((otherPosition.getxPos() + otherSize.getWidth() > this.x && otherPosition.getxPos() + otherSize.getWidth() < this.x + size.getWidth()) &&
                (otherPosition.getyPos() + otherSize.getHeight() > this.y && otherPosition.getyPos() + otherSize.getHeight() < this.y + size.getHeight())){
            return true;
        }
        else{
            return false;
        }
    }

    public Size calculateDistance(Position position) {
        int xDistance = this.x - position.getxPos();
        int yDistance = this.y - position.getyPos();
        return new Size(xDistance, yDistance);
    }
}
