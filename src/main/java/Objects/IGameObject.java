package Objects;

public interface IGameObject {

    public void moveRight(int x);
    public void moveLeft(int x);
    public void moveUp(int y);
    public void moveDown(int y);

    public void doAction(int command);

}
