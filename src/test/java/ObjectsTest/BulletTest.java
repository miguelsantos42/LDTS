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
    public void streamCopyBulletYPos(Bullet bullet) {
        Bullet newBullet = bullet.returnCopy();
        assertEquals(newBullet.getPosition().getyPos(), bullet.getPosition().getyPos());
    }

    @ParameterizedTest
    @MethodSource("streamCopyBullet")
    public void streamCopyBulletPosition(Bullet bullet) {
        Bullet newBullet = bullet.returnCopy();
        assertNotEquals(newBullet.getPosition(), bullet.getPosition());
    }


    private static Stream<Arguments> streamCopyBullet() {
        Bullet enemyBullet = new Bullet(new Position(0,0), new Size(1,1), new TextColor.RGB(255, 0, 0), new Life(1), true, Bullet.Direction.STOP);

        return Stream.of(
                arguments(enemyBullet)
        );
    }
}
