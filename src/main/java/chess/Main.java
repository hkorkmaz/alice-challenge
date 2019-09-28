package chess;

import chess.exceptions.InvalidMoveException;
import chess.exceptions.InvalidPlayerException;
import chess.exceptions.PieceNotFoundException;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Board board = new Board();

        Player player1 = new Player("Player1", Color.WHITE);
        Player player2 = new Player("Player2", Color.BLACK);

        System.out.println("Example move: A2 A4");
        System.out.println("Type 'exit' to quit");
        Scanner scanner = new Scanner(System.in);
        String input = "";
        Player turn = player1;

        while (!input.equals("exit")) {
            System.out.println(board);
            System.out.print(turn + " : ");
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit"))
                break;

            Square source = new Square(input.split(" ")[0]);
            Square target = new Square(input.split(" ")[1]);

            if (!board.isSquareValid(source) || !board.isSquareValid(target)) {
                System.out.println(">> ERROR: Invalid source or target");
                continue;
            }

            try {
                board.move(turn, source, target);
            } catch (InvalidMoveException | InvalidPlayerException | PieceNotFoundException e) {
                System.out.println(">> ERROR: " + e.getMessage());
                continue;
            }

            if (turn.getColor() == Color.WHITE)
                turn = player2;
            else
                turn = player1;
        }
    }
}
