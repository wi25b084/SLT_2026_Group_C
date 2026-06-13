package at.fhtw.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTest {

    private TicTacToe game;

    @BeforeEach
    void setUp() {
        game = new TicTacToe();
    }

    @Test
    void testHasWinner_returnTrue_whenTopRowFilled() {
        Board board = game.getBoard();
        board.place(0, 0, 'X');
        board.place(0, 1, 'X');
        board.place(0, 2, 'X');
        assertTrue(game.hasWinner());
    }

    @Test
    void testHasWinner_returnTrue_whenDiagonalFilled() {
        Board board = game.getBoard();
        board.place(0, 0, 'X');
        board.place(1, 1, 'X');
        board.place(2, 2, 'X');
        assertTrue(game.hasWinner());
    }

    @Test
    void testHasWinner_returnTrue_whenColumnFilled() {
        Board board = game.getBoard();
        board.place(0, 0, 'X');
        board.place(1, 0, 'X');
        board.place(2, 0, 'X');
        assertTrue(game.hasWinner());
    }

    @Test
    void testHasWinner_returnTrue_whenAntiDiagonalFilled() {
        Board board = game.getBoard();
        board.place(0, 2, 'X');
        board.place(1, 1, 'X');
        board.place(2, 0, 'X');
        assertTrue(game.hasWinner());
    }

    @Test
    void testHasWinner_returnFalse_whenBoardIsEmpty() {
        assertFalse(game.hasWinner());
    }

    @Test
    void testHasWinner_returnFalse_whenNoWinConditionMet() {
        Board board = game.getBoard();
        board.place(0, 0, 'X');
        board.place(0, 1, 'O');
        board.place(0, 2, 'X');
        assertFalse(game.hasWinner());
    }

    @Test
    void testSwitchCurrentPlayer_switchesFromXToO() {
        assertEquals('X', game.getCurrentPlayer().getMarker());
        game.switchCurrentPlayer();
        assertEquals('O', game.getCurrentPlayer().getMarker());
    }

    @Test
    void testSwitchCurrentPlayer_switchesBackToX() {
        game.switchCurrentPlayer();
        game.switchCurrentPlayer();
        assertEquals('X', game.getCurrentPlayer().getMarker());
    }
}