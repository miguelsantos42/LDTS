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
        if ((otherPosition.getxPos() >= this.x && otherPosition.getxPos() <= this.x + size.getWidth()) &&
                (otherPosition.getyPos() >= this.y && otherPosition.getyPos() <= this.y + size.getHeight())){
            return true;
        }
        else if ((otherPosition.getxPos() + otherSize.getWidth() >= this.x && otherPosition.getxPos() + otherSize.getWidth() <= this.x + size.getWidth()) &&
                (otherPosition.getyPos() + otherSize.getHeight() >= this.y && otherPosition.getyPos() + otherSize.getHeight() <= this.y + size.getHeight())){
            return true;
        }
        //Possibilidade de como verificar se há colisão (não está a funcionar neste momento)
        /*int xmin=this.getxPos();
        int xmax=this.getxPos()+size.getWidth();
        int ymin=this.getyPos();
        int ymax=this.getyPos()+size.getHeight();
        for (int i=0; i<(otherSize.getWidth()); i++)
        {
            for (int j=0; j<(otherSize.getHeight()); j++) {
                if((otherPosition.getxPos()+i)>xmin & (otherPosition.getxPos()+i)<xmax & (otherPosition.getyPos()+j)>ymin & (otherPosition.getyPos()+j)<ymax)
                    return true;
            }

        }*/
        else
            return false;


    }

    public Size calculateDistance(Position position) {
        int xDistance = this.x - position.getxPos();
        int yDistance = this.y - position.getyPos();
        return new Size(xDistance, yDistance);
    }
}
