package chess.piece;


import chess.Board;
import chess.Color;
import chess.Square;
import chess.piece.Queen;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class QueenTest {
    private Board board = new Board();

    @Test
    @DisplayName("should return moves")
    void queenTest() {

        Queen queen = new Queen(new Square("D5"), Color.WHITE);

        List<Square> expected = Arrays.asList(
                new Square("D6"), new Square("D7"), new Square("D4"), new Square("D3"),
                new Square("C5"), new Square("B5"), new Square("A5"), new Square("E5"), new Square("F5"),
                new Square("G5"), new Square("H5"), new Square("C4"), new Square("B3"), new Square("E4"),
                new Square("F3"), new Square("C6"), new Square("B7"), new Square("E6"), new Square("F7")
        );

        assertThat(queen.possibleMoves(board), containsInAnyOrder(expected.toArray()));
    }

}