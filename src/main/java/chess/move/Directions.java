package chess.move;

import chess.Square;

public interface Directions {

    Direction up = Square::up;
    Direction down = Square::down;
    Direction left = Square::left;
    Direction right = Square::right;

    Direction upRight = (p, step) -> p.up(step).right(step);
    Direction downRight = (p, step) -> p.down(step).right(step);
    Direction upLeft = (p, step) -> p.up(step).left(step);
    Direction downLeft = (p, step) -> p.down(step).left(step);
}
