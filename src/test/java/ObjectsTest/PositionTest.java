package ObjectsTest;

import LoZ.Objects.Attributes.Position;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class PositionTest {

    Position position;

    @ParameterizedTest
    @MethodSource("streamPositionConstructor")
    public void testXPositonConstructor(int x, int y){
        this.position = new Position(x, y);
        assertEquals(x, this.position.getxPos());
    }

    @ParameterizedTest
    @MethodSource("streamPositionConstructor")
    public void testYPositonConstructor(int x, int y){
        this.position = new Position(x, y);
        assertEquals(y, this.position.getyPos());
    }


    @ParameterizedTest
    @MethodSource("streamPositionMove")
    public void testYPositionMove(int x, int y, int xPos, int yPos){
        this.position = new Position(x, y);

        this.position.setyPos(yPos);

        assertEquals(y - yPos, this.position.getyPos());
    }

    @ParameterizedTest
    @MethodSource("streamPositionMove")
    public void testXPositionMove(int x, int y, int xPos, int yPos){
        this.position = new Position(x, y);

        this.position.setxPos(xPos);

        assertEquals(x - xPos, this.position.getxPos());
    }


    private static Stream<Arguments> streamPositionConstructor() {
        return Stream.of(
                arguments(1, 2),
                arguments(2, 2),
                arguments(10, 15)
        );
    }


    private static Stream<Arguments> streamPositionMove() {
        return Stream.of(
                arguments(1, 2, 1, 2),
                arguments(2, 2, 1, 1),
                arguments(10, 15, 6, 5)
        );
    }
}
