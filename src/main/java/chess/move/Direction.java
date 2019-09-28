package chess.move;

import chess.Square;

import java.util.function.BiFunction;

public interface Direction extends BiFunction<Square, Integer, Square> {
}
