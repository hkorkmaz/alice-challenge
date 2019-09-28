package chess.piece;

import chess.Board;
import chess.Color;
import chess.Square;
import chess.SquareStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Pawn extends Piece {
    private boolean hasMoved = false;

    public Pawn(Square position, Color color) {
        super(position, color);
    }

    public List<Square> possibleMoves(Board board) {
        Integer step = color == Color.WHITE ? 1 : -1;
        Stream<Square> diagonalMoves = diagonalMoves(step, board);
        Stream<Square> straightMoves = straightMoves(step, board);

        return Stream.concat(diagonalMoves, straightMoves).collect(Collectors.toList());
    }

    public void moveTo(Square newPosition) {
        super.moveTo(newPosition);
        this.hasMoved = true;
    }

    private Stream<Square> straightMoves(Integer step, Board board) {
        List<Square> possibilities = new ArrayList<>();
        possibilities.add(position.up(step));

        if (!hasMoved) {
            possibilities.add(position.up(step).up(step));
        }

        return possibilities.stream().filter(square -> {
            SquareStatus status = board.squareStatus(square, color);
            return status == SquareStatus.EMPTY && board.isSquareValid(square);
        });
    }

    private Stream<Square> diagonalMoves(Integer step, Board board) {
        List<Square> possibilities = new ArrayList<>();
        possibilities.add(position.up(step).left(1));
        possibilities.add(position.up(step).right(1));

        return possibilities.stream().filter(square -> {
            SquareStatus status = board.squareStatus(square, color);
            return status == SquareStatus.ENEMY && board.isSquareValid(square);
        });
    }

    public String toString() {
        return String.format("Pawn(%s)", color.name().charAt(0));
    }
}
