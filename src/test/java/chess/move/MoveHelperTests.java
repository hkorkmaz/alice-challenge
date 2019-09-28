package chess.move;


import chess.Board;
import chess.Color;
import chess.Square;
import chess.move.Direction;
import chess.move.Directions;
import chess.move.MoveHelper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoveHelperTests {
    private Board board = new Board();

    @Test
    @DisplayName("should return moves")
    void moveHelperTest1() {

        List<Direction> directions = Arrays.asList(Directions.up, Directions.left);

        List<Square> moves = new MoveHelper(board, new Square("D5"), Color.WHITE)
                .setDirections(directions)
                .setStepCount(2)
                .moves();

        List<Square> expected = Arrays.asList(new Square("D6"), new Square("D7"), new Square("C5"), new Square("B5"));

        assertEquals(expected, moves);
        assertThat(moves, containsInAnyOrder(expected.toArray()));
    }

    @Test
    @DisplayName("shouldn't return blocked squares")
    void moveHelperTest2() {

        List<Direction> directions = Arrays.asList(Directions.up, Directions.down);

        List<Square> moves = new MoveHelper(board, new Square("D5"), Color.WHITE)
                .setDirections(directions)
                .setStepCount(8)
                .moves();

        List<Square> expected = Arrays.asList(new Square("D6"), new Square("D7"), new Square("D4"), new Square("D3"));

        assertThat(moves, containsInAnyOrder(expected.toArray()));
    }

    @Test
    @DisplayName("shouldn't return squares out of board")
    void moveHelperTest3() {

        List<Direction> directions = Arrays.asList(Directions.left);

        List<Square> moves = new MoveHelper(board, new Square("D5"), Color.WHITE)
                .setDirections(directions)
                .setStepCount(8)
                .moves();

        List<Square> expected = Arrays.asList(new Square("C5"), new Square("B5"), new Square("A5"));

        assertThat(moves, containsInAnyOrder(expected.toArray()));
    }

    @Test
    @DisplayName("shouldn't return anything if piece is blocked")
    void moveHelperTest4() {

        List<Direction> directions = Arrays.asList(Directions.up);

        List<Square> moves = new MoveHelper(board, new Square("D6"), Color.BLACK)
                .setDirections(directions)
                .setStepCount(8)
                .moves();

        assertEquals(Collections.emptyList(), moves);
    }
}