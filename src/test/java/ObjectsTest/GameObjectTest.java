package ObjectsTest;

import LoZ.Objects.Attributes.Life;
import LoZ.Objects.Attributes.Position;
import LoZ.Objects.Attributes.Size;
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

    @ParameterizedTest
    @MethodSource("streamDownMoveChanged")
    public void testDownPlayerMoveChanged(Player player, int height){
        int currentPosition = player.getPosition().getyPos();
        player.moveDown();
        assertEquals(player.getPosition().getyPos(), currentPosition-1);
    }


    private static Stream<Arguments> streamDownMoveLimit() {
        Player gameObject1 = new Player(new Position(1, 2), new Size(1,2), new TextColor.RGB(255, 255, 255), new Life(1));
        Player gameObject2 = new Player(new Position(2, 1), new Size(3,20), new TextColor.RGB(255, 255, 255), new Life(1));
        Player gameObject3 = new Player(new Position(3, 1), new Size(10,20), new TextColor.RGB(255, 255, 255), new Life(1));


        return Stream.of(
                arguments(gameObject1,  2),
                arguments(gameObject2,  4),
                arguments(gameObject3,  101)
        );
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


}
