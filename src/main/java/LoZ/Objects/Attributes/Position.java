package LoZ.Objects.Attributes;

import LoZ.Objects.GameObject;
import LoZ.Objects.Player;

public class Position{

    int x;
    int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position(Position position) {
        this.x = position.getxPos();
        this.y = position.getyPos();
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

        if (otherPosition.getyPos() >= this.getyPos() && otherPosition.getyPos() < this.getyPos() + size.getHeight() &&
                otherPosition.getxPos() >= this.getxPos() && otherPosition.getxPos() < this.getxPos() + size.getWidth()) {
            return true;
        }
        else if (otherPosition.getyPos() + otherSize.getHeight()  > this.getyPos() && otherPosition.getyPos() + otherSize.getHeight() <= this.getyPos() + size.getHeight() &&
                otherPosition.getxPos() + otherSize.getWidth() > this.getxPos() && otherPosition.getxPos() + otherSize.getWidth() <= this.getxPos() + size.getWidth()) {
            return true;
        }
        else if (this.getyPos() >= otherPosition.getyPos() && this.getyPos() < otherPosition.getyPos() + otherSize.getHeight() &&
                this.getxPos() >= otherPosition.getxPos() && this.getxPos() < otherPosition.getxPos() + otherSize.getWidth()) {
            return true;
        }
        else if (this.getyPos() + size.getHeight()  > otherPosition.getyPos() && this.getyPos() + size.getHeight() <= otherPosition.getyPos() + otherSize.getHeight() &&
                this.getxPos() + size.getWidth() > otherPosition.getxPos() && this.getxPos() + size.getWidth() <= otherPosition.getxPos() + otherSize.getWidth()) {
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


    public void randomizePosition(Player player, Size thisSize, int width, int height){
        this.x = (int) (Math.random() * width);
        this.y = (int) (Math.random() * height);
        if (this.hasCollision(player.getPosition(), player.getSize(), thisSize)){
            this.setxPos(player.getSize().getWidth());
            this.setyPos(player.getSize().getHeight());
        }
    }
}
