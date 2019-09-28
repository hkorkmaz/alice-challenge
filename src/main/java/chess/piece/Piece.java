package chess.piece;

import chess.Board;
import chess.Color;
import chess.Square;

import java.util.List;

public abstract class Piece {

    protected Square position;
    protected Color color;

    public Piece(Square position, Color color){
        this.position = position;
        this.color = color;
    }

    public abstract List<Square> possibleMoves(Board board);

    public void moveTo(Square newPostion){
        this.position = newPostion;
    }

    public Color getColor() {
        return color;
    }

    public Square getPosition() {
        return position;
    }

}
