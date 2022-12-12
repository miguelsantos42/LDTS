package ObjectsTest;

import LoZ.Objects.Attributes.Life;
import LoZ.Objects.Attributes.Position;
import LoZ.Objects.Attributes.Size;
import LoZ.Objects.Bullet;
import LoZ.Objects.Enemy;
import LoZ.Objects.Player;

import java.util.stream.Stream;

import com.googlecode.lanterna.TextColor;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;
public class GameObjectTest {

    @ParameterizedTest
    @MethodSource("streamDownMoveLimit")
    public void testDownPlayerMoveLimit(Player player, int height){
        int currentPosition = player.getPosition().getyPos();
        player.moveDown();
        assertEquals(player.getPosition().getyPos(), currentPosition);
    }

    private static Stream<Arguments> streamDownMoveLimit() {
        Player gameObject1 = new Player(new Position(1, 0), new Size(1,2), new TextColor.RGB(255, 255, 255), new Life(1));
        Player gameObject2 = new Player(new Position(2, -10), new Size(3,20), new TextColor.RGB(255, 255, 255), new Life(1));
        Player gameObject3 = new Player(new Position(3, -1), new Size(10,20), new TextColor.RGB(255, 255, 255), new Life(1));


        return Stream.of(
                arguments(gameObject1,  2),
                arguments(gameObject2,  4),
                arguments(gameObject3,  101)
        );
    }
    @ParameterizedTest
    @MethodSource("streamDownMoveChanged")
    public void testDownPlayerMoveChanged(Player player, int height){
        int currentPosition = player.getPosition().getyPos();
        player.moveDown();
        assertEquals(player.getPosition().getyPos(), currentPosition-1);
    }


    private static Stream<Arguments> streamDownMoveChanged() {
        Player gameObject1 = new Player(new Position(1, 2), new Size(1,2), new TextColor.RGB(255, 255, 255), new Life(1));
        Player gameObject2 = new Player(new Position(2, 1), new Size(1,20), new TextColor.RGB(255, 255, 255), new Life(1));
        Player gameObject3 = new Player(new Position(2, 1), new Size(1,20), new TextColor.RGB(255, 255, 255), new Life(1));


        return Stream.of(
                arguments(gameObject1,  100),
                arguments(gameObject2,  100),
                arguments(gameObject3,  100)
        );
    }

    @ParameterizedTest
    @MethodSource("streamUpMoveLimit")
    public void testUpPlayerMoveLimit(Player player, int height){
        int currentPosition = player.getPosition().getyPos();
        player.moveUp(height);
        assertEquals(player.getPosition().getyPos(), currentPosition);
    }

    private static Stream<Arguments> streamUpMoveLimit() {
        Player gameObject1 = new Player(new Position(1, 2), new Size(1,2), new TextColor.RGB(255, 255, 255), new Life(1));
        Player gameObject2 = new Player(new Position(2, 1), new Size(3,3), new TextColor.RGB(255, 255, 255), new Life(1));
        Player gameObject3 = new Player(new Position(3, 1), new Size(20,20), new TextColor.RGB(255, 255, 255), new Life(1));


        return Stream.of(
                arguments(gameObject1,  2),
                arguments(gameObject2,  4),
                arguments(gameObject3,  21)
        );
    }
    @ParameterizedTest
    @MethodSource("streamUpMoveChanged")
    public void testUpPlayerMoveChanged(Player player, int height){
        int currentPosition = player.getPosition().getyPos();
        player.moveUp(height);
        assertEquals(player.getPosition().getyPos(), currentPosition+1);
    }


    private static Stream<Arguments> streamUpMoveChanged() {
        Player gameObject1 = new Player(new Position(1, 2), new Size(1,2), new TextColor.RGB(255, 255, 255), new Life(1));
        Player gameObject2 = new Player(new Position(2, 1), new Size(1,20), new TextColor.RGB(255, 255, 255), new Life(1));
        Player gameObject3 = new Player(new Position(2, 1), new Size(1,20), new TextColor.RGB(255, 255, 255), new Life(1));


        return Stream.of(
                arguments(gameObject1,  100),
                arguments(gameObject2,  100),
                arguments(gameObject3,  100)
        );
    }


    @ParameterizedTest
    @MethodSource("streamLeftMoveLimit")
    public void testLeftPlayerMoveLimit(Player player, int width){
        int currentPosition = player.getPosition().getxPos();
        player.moveLeft();
        assertEquals(player.getPosition().getxPos(), currentPosition);
    }

    private static Stream<Arguments> streamLeftMoveLimit() {
        Player gameObject1 = new Player(new Position(0, 2), new Size(1,2), new TextColor.RGB(255, 255, 255), new Life(1));
        Player gameObject2 = new Player(new Position(-1, 1), new Size(3,3), new TextColor.RGB(255, 255, 255), new Life(1));
        Player gameObject3 = new Player(new Position(-10, 1), new Size(20,20), new TextColor.RGB(255, 255, 255), new Life(1));


        return Stream.of(
                arguments(gameObject1,  2),
                arguments(gameObject2,  4),
                arguments(gameObject3,  21)
        );
    }
    @ParameterizedTest
    @MethodSource("streamLeftMoveChanged")
    public void testLeftPlayerMoveChanged(Player player, int width){
        int currentPosition = player.getPosition().getxPos();
        player.moveLeft();
        assertEquals(player.getPosition().getxPos(), currentPosition-1);
    }


    private static Stream<Arguments> streamLeftMoveChanged() {
        Player gameObject1 = new Player(new Position(1, 2), new Size(1,2), new TextColor.RGB(255, 255, 255), new Life(1));
        Player gameObject2 = new Player(new Position(2, 1), new Size(1,20), new TextColor.RGB(255, 255, 255), new Life(1));
        Player gameObject3 = new Player(new Position(2, 1), new Size(1,20), new TextColor.RGB(255, 255, 255), new Life(1));


        return Stream.of(
                arguments(gameObject1,  100),
                arguments(gameObject2,  100),
                arguments(gameObject3,  100)
        );
    }

    @ParameterizedTest
    @MethodSource("streamRightMoveLimit")
    public void testRightPlayerMoveLimit(Player player, int width){
        int currentPosition = player.getPosition().getxPos();
        player.moveLeft();
        assertEquals(player.getPosition().getxPos(), currentPosition);
    }

    private static Stream<Arguments> streamRightMoveLimit() {
        Player gameObject1 = new Player(new Position(0, 2), new Size(1,2), new TextColor.RGB(255, 255, 255), new Life(1));
        Player gameObject2 = new Player(new Position(-1, 1), new Size(3,3), new TextColor.RGB(255, 255, 255), new Life(1));
        Player gameObject3 = new Player(new Position(-10, 1), new Size(20,20), new TextColor.RGB(255, 255, 255), new Life(1));


        return Stream.of(
                arguments(gameObject1,  2),
                arguments(gameObject2,  4),
                arguments(gameObject3,  21)
        );
    }
    @ParameterizedTest
    @MethodSource("streamRightMoveChanged")
    public void testRightPlayerMoveChanged(Player player, int width){
        int currentPosition = player.getPosition().getxPos();
        player.moveLeft();
        assertEquals(player.getPosition().getxPos(), currentPosition-1);
    }


    private static Stream<Arguments> streamRightMoveChanged() {
        Player gameObject1 = new Player(new Position(1, 2), new Size(1,2), new TextColor.RGB(255, 255, 255), new Life(1));
        Player gameObject2 = new Player(new Position(2, 1), new Size(1,20), new TextColor.RGB(255, 255, 255), new Life(1));
        Player gameObject3 = new Player(new Position(2, 1), new Size(1,20), new TextColor.RGB(255, 255, 255), new Life(1));


        return Stream.of(
                arguments(gameObject1,  100),
                arguments(gameObject2,  100),
                arguments(gameObject3,  100)
        );
    }


    @ParameterizedTest
    @MethodSource("streamCheckCollision")
    public void testCheckCollision(Player player, Enemy enemy, boolean expected){
        int lifePlayer = player.getLife().getCurrentLives();
        player.checkCollision(enemy);
        assertEquals(expected, player.getLife().getCurrentLives() == lifePlayer);
    }


    private static Stream<Arguments> streamCheckCollision() {
        Player gameObject = new Player(new Position(0, 0), new Size(100,200), new TextColor.RGB(255, 255, 255), new Life(1));

        Bullet enemyBullet = new Bullet(new Position(0,0), new Size(1,1), new TextColor.RGB(255, 0, 0), new Life(1), true, Bullet.Direction.STOP);

        Enemy enemy1 = new Enemy(new Position(100, 200), new Size(100,200), new TextColor.RGB(255, 255, 255), new Life(1), enemyBullet);
        Enemy enemy2 = new Enemy(new Position(300, 300), new Size(100,200), new TextColor.RGB(255, 255, 255), new Life(1), enemyBullet);
        Enemy enemy3 = new Enemy(new Position(2, 1), new Size(100,200), new TextColor.RGB(255, 255, 255), new Life(1), enemyBullet);
        Enemy enemy4 = new Enemy(new Position(300, 200), new Size(100,200), new TextColor.RGB(255, 255, 255), new Life(1), enemyBullet);


        return Stream.of(
                arguments(gameObject,  enemy1, true),
                arguments(gameObject,  enemy2, true),
                arguments(gameObject,  enemy3, false),
                arguments(gameObject,  enemy4, true)
        );
    }

    @ParameterizedTest
    @MethodSource("streamCalculateDistance")
    public void testCalculateYDistance(Bullet player, Bullet enemy, Size size){
        Size distance = player.calculateDistance(enemy);
        assertEquals(size.getHeight(), distance.getHeight());
    }

    @ParameterizedTest
    @MethodSource("streamCalculateDistance")
    public void testCalculateXDistance(Bullet player, Bullet enemy, Size size){
        Size distance = player.calculateDistance(enemy);
        assertEquals(size.getWidth(), distance.getWidth());
    }


    private static Stream<Arguments> streamCalculateDistance() {
        Bullet enemyBullet1 = new Bullet(new Position(10,10), new Size(1,1), new TextColor.RGB(255, 0, 0), new Life(1), true, Bullet.Direction.LEFT);
        Bullet enemyBullet2 = new Bullet(new Position(10,10), new Size(1,1), new TextColor.RGB(255, 0, 0), new Life(1), true, Bullet.Direction.RIGHT);
        Bullet enemyBullet3 = new Bullet(new Position(20,0), new Size(1,1), new TextColor.RGB(255, 0, 0), new Life(1), true, Bullet.Direction.DOWN);
        Bullet enemyBullet4 = new Bullet(new Position(0,20), new Size(1,1), new TextColor.RGB(255, 0, 0), new Life(1), true, Bullet.Direction.UP);

        return Stream.of(
                arguments(enemyBullet1, enemyBullet2, new Size(0, 0)),
                arguments(enemyBullet1, enemyBullet3, new Size(-10, 10)),
                arguments(enemyBullet1, enemyBullet4, new Size(10, -10))
        );
    }



}
