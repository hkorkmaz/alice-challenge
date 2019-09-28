package chess.piece;

import chess.Board;
import chess.Color;
import chess.Square;
import chess.move.Direction;
import chess.move.MoveHelper;

import java.util.Arrays;
import java.util.List;

import static chess.move.Directions.*;

public class Queen extends Piece {

    private List<Direction> directions = Arrays.asList(up, down, left, right, upLeft, upRight, downLeft, downRight);

    public Queen(Square position, Color color) {
        super(position, color);
    }

    public List<Square> possibleMoves(Board board) {
        return new MoveHelper(board, position, color)
                .setDirections(directions)
                .moves();
    }

    public String toString() {
        return String.format("Queen(%s)", color.name().charAt(0));
    }
}
