package Objects;

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
        return x;
    }


    public void setxPos(int xPos) {
        x = x - xPos;
    }


    public void setyPos(int yPos) {
        y = y - yPos;
    }
}
