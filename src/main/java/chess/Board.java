package chess;

import chess.exceptions.InvalidMoveException;
import chess.exceptions.InvalidPlayerException;
import chess.exceptions.PieceNotFoundException;
import chess.piece.*;

import java.util.HashMap;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.*;

public class Board {

    public static final Integer BOARD_SIZE = 8;
    private static final char BOARD_START_X = 'A';
    private static final char BOARD_END_X = 'H';
    private static final char BOARD_START_Y = '1';
    private static final char BOARD_END_Y = '8';

    private Map<Square, Piece> pieces = new HashMap<>();

    public Board(Map<Square, Piece> pieces) {
        this.pieces.putAll(pieces);
    }

    public Board() {
        putPieces();
    }

    public void move(Player player, Square source, Square target) {
        Piece piece = pieces.get(source);
        if (piece == null)
            throw new PieceNotFoundException(source);

        if (piece.getColor() != player.getColor())
            throw new InvalidPlayerException(piece);

        if (!piece.possibleMoves(this).contains(target))
            throw new InvalidMoveException(piece, target);

        pieces.remove(source);
        piece.moveTo(target);
        pieces.put(target, piece);
    }

    public SquareStatus squareStatus(Square square, Color color) {
        if (!isSquareValid(square))
            return SquareStatus.INVALID;
        else if (hasAlly(square, color))
            return SquareStatus.ALLY;
        else if (hasEnemy(square, color))
            return SquareStatus.ENEMY;
        else
            return SquareStatus.EMPTY;
    }

    public Boolean isSquareValid(Square square) {
        return square.getStr().charAt(0) >= BOARD_START_X && square.getStr().charAt(0) <= BOARD_END_X
                && square.getStr().charAt(1) >= BOARD_START_Y && square.getStr().charAt(1) <= BOARD_END_Y;
    }

    private Boolean hasEnemy(Square position, Color color) {
        if (isEmpty(position)) {
            return false;
        }
        return pieces.get(position).getColor() != color;
    }

    private Boolean hasAlly(Square position, Color color) {
        if (isEmpty(position)) {
            return false;
        }
        return pieces.get(position).getColor() == color;
    }

    private Boolean isEmpty(Square position) {
        return pieces.get(position) == null;
    }

    private void putPieces() {
        // Pawns
        Square a2 = new Square("A2");
        for (int i = 0; i < BOARD_SIZE; i++) {
            Pawn whitePawn = new Pawn(a2.right(i), Color.WHITE);
            Pawn blackPawn = new Pawn(a2.right(i).symmetricX(), Color.BLACK);

            pieces.put(a2.right(i), whitePawn);
            pieces.put(a2.right(i).symmetricX(), blackPawn);
        }

        // Bishops
        Square c1 = new Square("C1");
        Square f1 = new Square("F1");
        pieces.put(c1, new Bishop(c1, Color.WHITE));
        pieces.put(f1, new Bishop(f1, Color.WHITE));
        pieces.put(c1.symmetricX(), new Bishop(c1.symmetricX(), Color.BLACK));
        pieces.put(f1.symmetricX(), new Bishop(f1.symmetricX(), Color.BLACK));

        // Knights
        Square b1 = new Square("B1");
        Square g1 = new Square("G1");
        pieces.put(b1, new Knight(b1, Color.WHITE));
        pieces.put(g1, new Knight(g1, Color.WHITE));
        pieces.put(b1.symmetricX(), new Knight(b1.symmetricX(), Color.BLACK));
        pieces.put(g1.symmetricX(), new Knight(g1.symmetricX(), Color.BLACK));

        // Rooks
        Square a1 = new Square("A1");
        Square h1 = new Square("H1");
        pieces.put(a1, new Rook(a1, Color.WHITE));
        pieces.put(h1, new Rook(h1, Color.WHITE));
        pieces.put(a1.symmetricX(), new Rook(a1.symmetricX(), Color.BLACK));
        pieces.put(h1.symmetricX(), new Rook(h1.symmetricX(), Color.BLACK));

        // Kings
        Square e1 = new Square("E1");
        pieces.put(e1, new King(e1, Color.WHITE));
        pieces.put(e1.symmetricX(), new King(e1.symmetricX(), Color.BLACK));

        // Queens
        Square d1 = new Square("D1");
        pieces.put(d1, new Queen(d1, Color.WHITE));
        pieces.put(d1.symmetricX(), new Queen(d1.symmetricX(), Color.BLACK));
    }

    public String toString() {
        String pipe = "|";
        String dash = "-";
        int padding = 10;
        int boardLength = 87;
        String space = " ";
        String newLine = System.lineSeparator();

        StringBuilder sb = new StringBuilder();
        sb.append(repeat(dash, boardLength)).append(newLine);

        for (char y = BOARD_END_Y; y >= BOARD_START_Y; y--) {
            sb.append(y).append(space);
            for (char x = BOARD_START_X; x <= BOARD_END_X; x++) {
                Piece piece = pieces.get(new Square(join(x, y)));
                if (piece == null)
                    sb.append(pipe).append(rightPad(dash, padding, space));
                else
                    sb.append(pipe).append(rightPad(piece.toString(), padding, space));
            }

            sb.append(newLine);
        }

        sb.append(repeat(dash, boardLength)).append(newLine).append(space).append(space);

        for (char x = BOARD_START_X; x <= BOARD_END_X; x++) {
            sb.append(pipe).append(rightPad(Character.toString(x), padding, space));
        }

        return sb.append(newLine).toString();
    }
}
