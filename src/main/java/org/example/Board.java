package org.example;

public class Board {
    private char[][] cells;

    public Board() {
        cells = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j <3; j++) {
                cells[i][j]=' ';
            }
        }
    }

    public boolean isCellEmpty(int x, int y) {
        return cells[x][y]==' ';
    }

    public void place(int x, int y, char marker) {
        if (isCellEmpty(x,y)) {
            cells[x][y]=marker;
        } else {
            System.err.println("Selected Cell is not empty");
        }
    }

    public void print() {
        String sep = "▁▁▁▁▁▁▁";
        System.out.println(sep);
        for (int x = 0; x < 3; x++) {
            System.out.print("|");
            for (int y = 0; y < 3; y++) {
                System.out.print(cells[x][y]);
                System.out.print("|");
            }
            System.out.println();
        }
        System.out.println("▔▔▔▔▔▔▔");
    }

    public boolean isFull() {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (cells[x][y] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public char[][] getCells() {
        return cells;
    }

}
