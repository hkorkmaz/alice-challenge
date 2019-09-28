package chess.piece;

import chess.Board;
import chess.Color;
import chess.Square;
import chess.SquareStatus;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Knight extends Piece {

    public Knight(Square position, Color color) {
        super(position, color);
    }

    public List<Square> possibleMoves(Board board) {
        Square s1 = position.left(1).down(2);
        Square s2 = position.left(1).up(2);
        Square s3 = position.right(1).down(2);
        Square s4 = position.right(1).up(2);

        Square s5 = position.left(2).down(1);
        Square s6 = position.left(2).up(1);
        Square s7 = position.right(2).down(1);
        Square s8 = position.right(2).up(1);

        return Stream.of(s1, s2, s3, s4, s5, s6, s7, s8)
                .filter(square -> {
                    SquareStatus status = board.squareStatus(square, color);
                    return status == SquareStatus.ENEMY || status == SquareStatus.EMPTY;
                }).collect(Collectors.toList());
    }

    public String toString() {
        return String.format("Knight(%s)", color.name().charAt(0));
    }
}
