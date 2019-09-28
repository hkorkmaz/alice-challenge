package chess.exceptions;

import chess.Square;

public class PieceNotFoundException extends RuntimeException {
    public PieceNotFoundException(Square square) {
        super(String.format("Piece not found in %s", square));
    }
}
