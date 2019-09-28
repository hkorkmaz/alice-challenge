package chess.piece;


import chess.Board;
import chess.Color;
import chess.Square;
import chess.piece.Knight;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class KnightTests {
    private Board board = new Board();

    @Test
    @DisplayName("should return moves")
    void knightTest() {

        Knight knight = new Knight(new Square("D5"), Color.WHITE);

        List<Square> expected = Arrays.asList(
                new Square("C3"), new Square("C7"), new Square("E3"), new Square("E7"),
                new Square("B4"), new Square("B6"), new Square("F4"), new Square("F6")
        );

        assertThat(knight.possibleMoves(board), containsInAnyOrder(expected.toArray()));
    }

    @Test
    @DisplayName("should return moves jumping over ally pieces")
    void knightTest2() {

        Knight knight = new Knight(new Square("D3"), Color.WHITE);

        List<Square> expected = Arrays.asList(
                new Square("B4"), new Square("C5"), new Square("E5"), new Square("F4")
        );

        assertThat(knight.possibleMoves(board), containsInAnyOrder(expected.toArray()));
    }

}