package at.fhtw.tictactoe;

import java.util.Scanner;

public class TicTacToe {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;

    public TicTacToe() {
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
        board = new Board();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean playing = true;

        while (playing) {
            board.clear();
            currentPlayer = player1;

            boolean gameOver = false;
            while (!gameOver) {
                System.out.println("Current Player: " + currentPlayer.getMarker());
                board.print();

                int row = -1, col = -1;

                while (row < 0 || row > 2) {
                    System.out.print("row (0-2): ");
                    if (scanner.hasNextInt()) {
                        row = scanner.nextInt();
                        if (row < 0 || row > 2) {
                            System.out.println("Invalid row.");
                            row = -1;
                        }
                    } else {
                        scanner.next();
                        System.out.println("Please enter a number.");
                    }
                }

                while (col < 0 || col > 2) {
                    System.out.print("column (0-2): ");
                    if (scanner.hasNextInt()) {
                        col = scanner.nextInt();
                        if (col < 0 || col > 2) {
                            System.out.println("Invalid column.");
                            col = -1;
                        }
                    } else {
                        scanner.next();
                        System.out.println("Please enter a number.");
                    }
                }

                if (!board.isCellEmpty(row, col)) {
                    System.out.println("Cell already taken! Choose another.");
                    continue;
                }

                board.place(row, col, currentPlayer.getMarker());

                if (hasWinner()) {
                    board.print();
                    System.out.println("Player " + currentPlayer.getMarker() + " wins!");
                    gameOver = true;
                } else if (board.isFull()) {
                    board.print();
                    System.out.println("It's a draw!");
                    gameOver = true;
                } else {
                    switchCurrentPlayer();
                }
            }

            System.out.print("Play again? (y/n): ");
            String answer = scanner.next();
            if (!answer.equalsIgnoreCase("y")) playing = false;
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }

    public void switchCurrentPlayer() {
        if (currentPlayer == player1) currentPlayer = player2;
        else currentPlayer = player1;
    }

    public boolean hasWinner() {
        char[][] cells = board.getCells();
        char m = currentPlayer.getMarker();

        for (int i = 0; i < 3; i++) {
            if (cells[i][0] == m && cells[i][1] == m && cells[i][2] == m) return true;
            if (cells[0][i] == m && cells[1][i] == m && cells[2][i] == m) return true;
        }

        if (cells[0][0] == m && cells[1][1] == m && cells[2][2] == m) return true;
        if (cells[0][2] == m && cells[1][1] == m && cells[2][0] == m) return true;

        return false;
    }

    public Player getCurrentPlayer() { return currentPlayer; }
    public Board getBoard() { return board; }

public static void main(String[] args) {
        new TicTacToe().start();
    }
}