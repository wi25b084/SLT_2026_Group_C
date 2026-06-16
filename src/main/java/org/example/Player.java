package org.example;

public class Player {
    private final char marker;

    public Player(char marker) {
        marker = Character.toUpperCase(marker);
        if (marker != 'X' && marker != 'O') {
            System.out.println("Marker has to be 'X' or 'O'!");
        }
        this.marker = marker;
    }

    public char getMarker() {
        return marker;
    }
}
