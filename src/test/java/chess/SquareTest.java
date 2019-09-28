package chess;

import chess.Square;
import chess.move.Directions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SquareTest {

    @Test
    @DisplayName("test moves with step=1")
    void testMovesWithoutStep() {
        Square d5 = new Square("D5");

        assertEquals(new Square("C5"), d5.left(1));
        assertEquals(new Square("E5"), d5.right(1));
        assertEquals(new Square("D6"), d5.up(1));
        assertEquals(new Square("D4"), d5.down(1));
    }

    @Test
    @DisplayName("test moves with step=2")
    void testMovesWithStep2() {
        Square d5 = new Square("D5");

        assertEquals(new Square("B5"), d5.left(2));
        assertEquals(new Square("F5"), d5.right(2));
        assertEquals(new Square("D7"), d5.up(2));
        assertEquals(new Square("D3"), d5.down(2));
    }

    @Test
    @DisplayName("test symmetricity")
    void testSymmetric() {
        Square a1 = new Square("A1");

        assertEquals(new Square("A8"), a1.symmetricX());
    }

    @Test
    @DisplayName("test directions")
    void testDirections() {
        Square d5 = new Square("D5");

        assertEquals(new Square("C4"), Directions.downLeft.apply(d5, 1));
        assertEquals(new Square("E4"), Directions.downRight.apply(d5, 1));
        assertEquals(new Square("C6"), Directions.upLeft.apply(d5, 1));
        assertEquals(new Square("E6"), Directions.upRight.apply(d5, 1));
    }
}