package ObjectsTest;

import LoZ.Objects.Attributes.Life;
import LoZ.Objects.Attributes.Position;
import LoZ.Objects.Attributes.Size;
import LoZ.Objects.Bullet;
import LoZ.Objects.Player;
import com.googlecode.lanterna.TextColor;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class BulletTest {

    @ParameterizedTest
    @MethodSource("streamCopyBullet")
    public void testCopyBulletYPos(Bullet bullet) {
        Bullet newBullet = bullet.returnCopy();
        assertEquals(newBullet.getPosition().getyPos(), bullet.getPosition().getyPos());
    }

    @ParameterizedTest
    @MethodSource("streamCopyBullet")
    public void testCopyBulletPosition(Bullet bullet) {
        Bullet newBullet = bullet.returnCopy();
        assertNotEquals(newBullet.getPosition(), bullet.getPosition());
    }


    private static Stream<Arguments> streamCopyBullet() {
        Bullet enemyBullet = new Bullet(new Position(0,0), new Size(1,1), new TextColor.RGB(255, 0, 0), new Life(1), true, Bullet.Direction.STOP);

        return Stream.of(
                arguments(enemyBullet)
        );
    }

    @ParameterizedTest
    @MethodSource("streamMoveBullet")
    public void testMoveYBullet(Bullet bullet, Position position) {
        bullet.moveBullet(100, 100);
        assertEquals(position.getyPos(), bullet.getPosition().getyPos());
    }

    @ParameterizedTest
    @MethodSource("streamMoveBullet")
    public void testMoveXBullet(Bullet bullet, Position position) {
        bullet.moveBullet(100, 100);
        assertEquals(position.getxPos(), bullet.getPosition().getxPos());
    }

    private static Stream<Arguments> streamMoveBullet() {
        Bullet enemyBullet1 = new Bullet(new Position(10,10), new Size(1,1), new TextColor.RGB(255, 0, 0), new Life(1), true, Bullet.Direction.LEFT);
        Bullet enemyBullet2 = new Bullet(new Position(10,10), new Size(1,1), new TextColor.RGB(255, 0, 0), new Life(1), true, Bullet.Direction.RIGHT);
        Bullet enemyBullet3 = new Bullet(new Position(10,10), new Size(1,1), new TextColor.RGB(255, 0, 0), new Life(1), true, Bullet.Direction.DOWN);
        Bullet enemyBullet4 = new Bullet(new Position(10,10), new Size(1,1), new TextColor.RGB(255, 0, 0), new Life(1), true, Bullet.Direction.UP);

        return Stream.of(
                arguments(enemyBullet1, new Position(10,10)),
                arguments(enemyBullet2, new Position(10,10)),
                arguments(enemyBullet3, new Position(10,10)),
                arguments(enemyBullet4, new Position(10,10))

        );
    }


}
