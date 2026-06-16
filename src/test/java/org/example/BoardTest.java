package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
    }

    @Test
    void testIsCellEmpty_returnsTrue_whenCellIsEmpty() {
        assertTrue(board.isCellEmpty(0, 0));
    }

    @Test
    void testIsCellEmpty_returnsFalse_whenCellIsOccupied() {
        board.place(1, 1, 'X');
        assertFalse(board.isCellEmpty(1, 1));
    }

    @Test
    void testPlace_setsMarkerCorrectly() {
        board.place(0, 0, 'X');
        assertEquals('X', board.getCells()[0][0]);
    }

    @Test
    void testPlace_doesNotOverwriteOccupiedCell() {
        board.place(0, 0, 'X');
        board.place(0, 0, 'O');
        assertEquals('X', board.getCells()[0][0]);
    }

    @Test
    void testIsFull_returnsFalse_whenBoardIsEmpty() {
        assertFalse(board.isFull());
    }

    @Test
    void testIsFull_returnsTrue_whenAllCellsFilled() {
        char[] markers = {'X','O','X','O','X','O','O','X','O'};
        int idx = 0;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board.place(i, j, markers[idx++]);
        assertTrue(board.isFull());
    }

    @Test
    void testClear_emptiesAllCells() {
        board.place(0, 0, 'X');
        board.place(1, 1, 'O');
        board.clear();
        assertTrue(board.isCellEmpty(0, 0));
        assertTrue(board.isCellEmpty(1, 1));
    }

    @Test
    void testClear_boardIsNotFullAfterClear() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board.place(i, j, 'X');
        board.clear();
        assertFalse(board.isFull());
    }
}