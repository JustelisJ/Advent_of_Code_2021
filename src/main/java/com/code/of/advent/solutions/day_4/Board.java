package com.code.of.advent.solutions.day_4;

public class Board {

    private int[][] grid;
    private int squireSize;
    private boolean[][] markedGrid;

    public Board(int[][] grid, int squireSize) {
        this.grid = grid;
        this.squireSize = squireSize;
        this.markedGrid = new boolean[squireSize][squireSize];
    }

    public boolean markNumber(int number) {
        for (int y = 0; y < squireSize; y++) {
            for (int x = 0; x < squireSize; x++) {
                if (grid[y][x] == number) {
                    markedGrid[y][x] = true;
                    return checkBingo(x, y);
                }
            }
        }
        return false;
    }

    private boolean checkBingo(int x, int y) {
        return checkRow(y) || checkColumn(x);
    }

    private boolean checkColumn(int x) {
        for (int i = 0; i < squireSize; i++) {
            if (!markedGrid[i][x])
                return false;
        }
        return true;
    }

    private boolean checkRow(int y) {
        for (int i = 0; i < squireSize; i++) {
            if (!markedGrid[y][i])
                return false;
        }
        return true;
    }

    public int sumOfUnmarkedNumbers() {
        int sum = 0;
        for (int y = 0; y < squireSize; y++) {
            for (int x = 0; x < squireSize; x++) {
                if (!markedGrid[y][x]) {
                    sum += grid[y][x];
                }
            }
        }
        return sum;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int y = 0; y < squireSize; y++) {
            for (int x = 0; x < squireSize; x++) {
                if (markedGrid[y][x]) {
                    result.append("X");
                } else {
                    result.append(grid[y][x]);
                }

                if (x != squireSize - 1)
                    result.append(" ");
            }
            if (y != squireSize - 1)
                result.append("\n");
        }
        return result.toString();
    }

}
