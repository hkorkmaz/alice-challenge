package chess;


import chess.*;
import chess.exceptions.InvalidMoveException;
import chess.exceptions.InvalidPlayerException;
import chess.exceptions.PieceNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BoardTest {

    @Test
    @DisplayName("should move piece if everything is ok")
    void boardTest1() {
        Board board = new Board();
        Player player = new Player("player", Color.WHITE);

        Square source = new Square("A2");
        Square target = new Square("A3");

        board.move(player, source, target);

        assertEquals(SquareStatus.ALLY, board.squareStatus(target, Color.WHITE));
        assertEquals(SquareStatus.EMPTY, board.squareStatus(source, Color.WHITE));
    }

    @Test
    @DisplayName("should throw exception for invalid player move")
    void boardTest2() {
        Board board = new Board();
        Player player = new Player("player", Color.BLACK);

        assertThrows(InvalidPlayerException.class, () -> {
            board.move(player, new Square("A2"), new Square("A3"));
        });
    }

    @Test
    @DisplayName("should throw exception for piece is not found")
    void boardTest3() {
        Board board = new Board();
        Player player = new Player("player", Color.BLACK);

        assertThrows(PieceNotFoundException.class, () -> {
            board.move(player, new Square("D5"), new Square("D6"));
        });
    }

    @Test
    @DisplayName("should throw exception for invalid move")
    void boardTest4() {
        Board board = new Board();
        Player player = new Player("player", Color.WHITE);

        assertThrows(InvalidMoveException.class, () -> {
            board.move(player, new Square("B2"), new Square("B5"));
        });
    }


    @Test
    @DisplayName("should return square status")
    void boardTest5() {
        Board board = new Board();

        SquareStatus status1 = board.squareStatus(new Square("A1"), Color.WHITE);
        SquareStatus status2 = board.squareStatus(new Square("A8"), Color.WHITE);
        SquareStatus status3 = board.squareStatus(new Square("D5"), Color.WHITE);

        assertEquals(SquareStatus.ALLY, status1);
        assertEquals(SquareStatus.ENEMY, status2);
        assertEquals(SquareStatus.EMPTY, status3);
    }

    @Test
    @DisplayName("should return validity of a square")
    void boardTest6() {
        Board board = new Board();

        Boolean result1 = board.isSquareValid(new Square("A1"));
        Boolean result2 = board.isSquareValid(new Square("A9"));

        assertEquals(true, result1);
        assertEquals(false, result2);
    }
}