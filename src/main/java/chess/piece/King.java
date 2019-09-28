package chess.piece;

import chess.Board;
import chess.Color;
import chess.Square;
import chess.move.Direction;
import chess.move.MoveHelper;

import java.util.Arrays;
import java.util.List;

import static chess.move.Directions.*;

public class King extends Piece {

    private List<Direction> directions = Arrays.asList(up, down, left, right, upLeft, upRight, downLeft, downRight);

    public King(Square position, Color color) {
        super(position, color);
    }

    public List<Square> possibleMoves(Board board) {
        return new MoveHelper(board, position, color)
                .setDirections(directions)
                .setStepCount(1)
                .moves();
    }

    @Override
    public String toString() {
        return String.format("King(%s)", color.name().charAt(0));
    }
}
