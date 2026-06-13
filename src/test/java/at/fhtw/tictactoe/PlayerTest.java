package at.fhtw.tictactoe;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    @Test
    void testGetMarker_returnsX() {
        Player player = new Player('X');
        assertEquals('X', player.getMarker());
    }

    @Test
    void testGetMarker_returnsO() {
        Player player = new Player('O');
        assertEquals('O', player.getMarker());
    }
}