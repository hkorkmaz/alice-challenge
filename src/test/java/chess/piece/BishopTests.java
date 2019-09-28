package chess.piece;

import chess.Board;
import chess.Color;
import chess.Square;
import chess.piece.Bishop;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class BishopTests {
    private Board board = new Board();

    @Test
    @DisplayName("should return moves")
    void bishopTest() {

        Bishop bishop = new Bishop(new Square("D5"), Color.WHITE);

        List<Square> expected = Arrays.asList(
            new Square("C4"), new Square("B3"), new Square("C6"), new Square("B7"),
            new Square("E4"), new Square("F3"), new Square("E6"), new Square("F7")
        );

        assertThat(bishop.possibleMoves(board), containsInAnyOrder(expected.toArray()));
    }

}