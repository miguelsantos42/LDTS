package LoZ.Objects.Attributes;

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
}
