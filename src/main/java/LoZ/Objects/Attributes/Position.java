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
        int xmin=this.x;
        int xmax=this.x+size.getWidth();
        int ymin=this.y;
        int ymax=this.y+size.getHeight();
        int count=0;
        for (int i=0; i<(otherSize.getWidth()); i++)
        {
            for (int j=0; j<(otherSize.getHeight()); j++) {
                if((otherPosition.getxPos()+i)>=xmin & (otherPosition.getxPos()+i)<=xmax & (otherPosition.getyPos()+j)>=ymin & (otherPosition.getyPos()+j)<=ymax)
                    count++;
            }

        }
        if (count!=0) {
            return true;
        }

        else {
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
