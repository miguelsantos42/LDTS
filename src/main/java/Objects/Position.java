package Objects;

public class Position implements IPosition{

    int x;
    int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int getxPos() {
        return x;
    }

    @Override
    public int getyPos() {
        return y;
    }

    @Override
    public void setxPos(int xPos) {
        x = x - xPos;
    }

    @Override
    public void setyPos(int yPos) {
        y = y - yPos;
    }
}
