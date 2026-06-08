package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main
{
    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        String line;
        //Start game, initiallize
        System.out.println("Welcome to TicTacToe!");
        TicTacToe game = new TicTacToe();
        game.start();
        int row = 0, column = 0;
        while (true) {
            //run gameXX
            System.out.println("Player " + game.getCurrentPlayer().getMarker() + ": please make your move!");
            game.getBoard().print();
            System.out.println("Choose a row (0-2): ");
            line = br.readLine();
            try {
                row = Integer.parseInt(line);
                if (row <0 || row > 2) {
                    System.err.println("Row Number not allowed!");
                    continue;
                }
            } catch (NumberFormatException nfe) {
                System.err.println("Input row not a number!");
            }
            System.out.println("Choose a column (0-2): ");
            line = br.readLine();
            try {
                column = Integer.parseInt(line);
                if (column <0 || column > 2) {
                    System.err.println("Column Number not allowed!");
                    continue;
                }
            } catch (NumberFormatException nfe) {
                System.err.println("Input Column not a number!");
            }
            if (!game.getBoard().isCellEmpty(row, column)) {
                System.err.println("Cell is not empty");
            } else {
                game.getBoard().place(row, column, game.getCurrentPlayer().getMarker());
                if (game.hasWinner()) {
                        System.out.println("Player " + game.getCurrentPlayer().getMarker() + " has won!");
                        if (gameEnd()) {
                            game.getBoard().clear();
                            game.start();
                        } else {
                            break;
                        }
                } else if (game.getBoard().isFull()) {
                    System.out.println("It's a draw!");
                    if (gameEnd()) {
                        game.getBoard().clear();
                        game.start();
                    } else {
                        break;
                    }
                }
                else {
                    game.switchCurrentPlayer();
                }
            }
        }
    }

    private static boolean gameEnd() throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        String line;

        System.out.println("Enter 'q' to end or any other key to restart");

        line = br.readLine();
        return !line.equalsIgnoreCase("q");
    }
}
