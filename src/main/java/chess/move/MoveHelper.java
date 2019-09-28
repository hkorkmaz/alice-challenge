package chess.move;

import chess.Board;
import chess.Color;
import chess.Square;
import chess.SquareStatus;

import java.util.ArrayList;
import java.util.List;

public class MoveHelper {

    private Board board;
    private Square position;
    private Color color;

    private List<Direction> directions = new ArrayList<>();
    private Integer stepCount = Board.BOARD_SIZE;

    public MoveHelper(Board board, Square position, Color color) {
        this.board = board;
        this.position = position;
        this.color = color;
    }

    public MoveHelper setDirections(List<Direction> directions) {
        this.directions.addAll(directions);
        return this;
    }

    public MoveHelper setStepCount(Integer stepCount) {
        this.stepCount = stepCount;
        return this;
    }

    public List<Square> moves() {
        List<Square> result = new ArrayList<>();

        for (Direction direction : directions) {
            boolean blockedPath = false;

            for (int step = 1; step <= stepCount; step++) {
                Square nextSquare = direction.apply(position, step);
                SquareStatus nextSquareStatus = board.squareStatus(nextSquare, color);

                if (!blockedPath) {
                    switch (nextSquareStatus) {
                        case EMPTY:
                            result.add(nextSquare);
                            break;
                        case ALLY:
                        case INVALID:
                            blockedPath = true;
                            break;
                        case ENEMY:
                            result.add(nextSquare);
                            blockedPath = true;
                    }

                }
            }
        }
        return result;
    }
}
