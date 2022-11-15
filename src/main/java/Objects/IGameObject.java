package Objects;

public interface IGameObject {

    public void moveRight(int xBias);
    public void moveLeft(int xBias);
    public void moveUp(int yBias);
    public void moveDown(int yBias);

    public void doAction(int command);

}
