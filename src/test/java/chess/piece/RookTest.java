package chess.piece;


import chess.Board;
import chess.Color;
import chess.Square;
import chess.piece.Rook;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class RookTest {
    private Board board = new Board();

    @Test
    @DisplayName("should return moves")
    void rookTest() {

        Rook rook = new Rook(new Square("D5"), Color.WHITE);

        List<Square> expected = Arrays.asList(
                new Square("D6"), new Square("D7"), new Square("D4"), new Square("D3"),
                new Square("C5"), new Square("B5"), new Square("A5"), new Square("E5"),
                new Square("F5"), new Square("G5"), new Square("H5")
        );

        assertThat(rook.possibleMoves(board), containsInAnyOrder(expected.toArray()));
    }

}