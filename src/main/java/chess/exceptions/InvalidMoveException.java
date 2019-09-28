package chess.exceptions;

import chess.Square;
import chess.piece.Piece;

public class InvalidMoveException extends RuntimeException {

    public InvalidMoveException(Piece piece, Square target) {
        super(String.format("%s at %s can't move to %s", piece, piece.getPosition(), target));
    }
}
