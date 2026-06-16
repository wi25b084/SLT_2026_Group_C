package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    @Test
    void testGetMarker_returnsX_whenCreatedWithX() {
        Player player = new Player('X');
        assertEquals('X', player.getMarker());
    }

    @Test
    void testGetMarker_returnsO_whenCreatedWithO() {
        Player player = new Player('O');
        assertEquals('O', player.getMarker());
    }

    @Test
    void testGetMarker_convertsLowerCaseToUpper() {
        Player player = new Player('x');
        assertEquals('X', player.getMarker());
    }

    @Test
    void testGetMarker_returnsInvalidMarker_whenNotXorO() {
        Player player = new Player('A');
        assertNotEquals('X', player.getMarker());
        assertNotEquals('O', player.getMarker());
    }
}