package ObjectsTest;

import Objects.Position;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.Test;

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


    private static Stream<Arguments> streamPositionConstructor() {
        return Stream.of(
                arguments(1, 2),
                arguments(2, 2),
                arguments(10, 15)
        );
    }
}
