package chess.exceptions;

import chess.piece.Piece;

public class InvalidPlayerException extends RuntimeException {

    public InvalidPlayerException(Piece piece) {
        super(String.format("Player can not move %s at %s", piece, piece.getPosition()));
    }
}
