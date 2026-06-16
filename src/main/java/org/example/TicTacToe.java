package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class TicTacToe {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;

    public TicTacToe(){
        board = new Board();
    }

    public void start() throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        String line;
        do {
            System.out.println("Player 1: Please select your marker (X/O)");
            line = br.readLine();
            line = line.toUpperCase();
        } while (!line.equals("X") && !line.equals("O"));
        Player playerOne = new Player(line.charAt(0));
        char markerTwo = playerOne.getMarker() == 'X' ? 'O' : 'X';
        Player playerTwo = new Player(markerTwo);
        player1 = playerOne;
        player2 = playerTwo;
        currentPlayer = playerOne;
    }

    public void switchCurrentPlayer() {
        currentPlayer = currentPlayer == player1 ? player2 : player1;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Board getBoard(){
        return board;
    }
}
