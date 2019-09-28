package chess.piece;

import chess.Board;
import chess.Color;
import chess.Square;
import chess.move.Direction;
import chess.move.Directions;
import chess.move.MoveHelper;

import java.util.Arrays;
import java.util.List;

public class Bishop extends Piece {

    private List<Direction> directions = Arrays.asList(Directions.downLeft, Directions.upLeft, Directions.downRight, Directions.upRight);

    public Bishop(Square position, Color color) {
        super(position, color);
    }

    public List<Square> possibleMoves(Board board) {
        return new MoveHelper(board, position, color)
                .setDirections(directions)
                .moves();
    }

    @Override
    public String toString() {
        return String.format("Bishop(%s)", color.name().charAt(0));
    }
}
