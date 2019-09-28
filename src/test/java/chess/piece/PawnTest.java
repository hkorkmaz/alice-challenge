package chess.piece;


import chess.Board;
import chess.Color;
import chess.Square;
import chess.piece.Pawn;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class PawnTest {
    private Board board = new Board();

    @Test
    @DisplayName("should return moves")
    void pawnTest1() {

        Pawn pawn = new Pawn(new Square("D4"), Color.WHITE);

        List<Square> expected = Arrays.asList(new Square("D5"), new Square("D6"));
        assertThat(pawn.possibleMoves(board), containsInAnyOrder(expected.toArray()));
    }

    @Test
    @DisplayName("should return moves after moving")
    void pawnTest2() {

        Pawn pawn = new Pawn(new Square("D3"), Color.WHITE);
        pawn.moveTo(new Square("D4"));

        List<Square> expected = Arrays.asList(new Square("D5"));
        assertThat(pawn.possibleMoves(board), containsInAnyOrder(expected.toArray()));
    }

    @Test
    @DisplayName("should return diagonal enemy squares")
    void pawnTest3() {
        Pawn pawn = new Pawn(new Square("D6"), Color.WHITE);

        List<Square> expected = Arrays.asList(new Square("C7"), new Square("E7"));
        assertThat(pawn.possibleMoves(board), containsInAnyOrder(expected.toArray()));
    }

}