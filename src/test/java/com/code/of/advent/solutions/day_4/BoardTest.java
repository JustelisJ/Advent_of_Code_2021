package com.code.of.advent.solutions.day_4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    int[][] grid;

    @BeforeEach
    void setup() {
        grid = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
    }

    @Test
    void gridCreation() {
        String gridAsString =
                "1 2 3\n" +
                        "4 5 6\n" +
                        "7 8 9";
        Board newBoard = new Board(grid, 3);
        assertEquals(gridAsString, newBoard.toString());
    }

    @Test
    void markNumberRow() {
        String markedBoard =
                "X X X\n" +
                        "4 5 6\n" +
                        "7 8 9";
        Board newBoard = new Board(grid, 3);
        newBoard.markNumber(1);
        newBoard.markNumber(2);
        newBoard.markNumber(3);
        assertEquals(markedBoard, newBoard.toString());
    }

    @Test
    void markNumberRow_2() {
        String markedBoard =
                "1 2 3\n" +
                        "X X X\n" +
                        "7 8 9";
        Board newBoard = new Board(grid, 3);
        newBoard.markNumber(4);
        newBoard.markNumber(5);
        newBoard.markNumber(6);
        assertEquals(markedBoard, newBoard.toString());
    }

    @Test
    void markNumberRow_3() {
        String markedBoard =
                "1 2 3\n" +
                        "4 5 6\n" +
                        "X X X";
        Board newBoard = new Board(grid, 3);
        newBoard.markNumber(7);
        newBoard.markNumber(8);
        newBoard.markNumber(9);
        assertEquals(markedBoard, newBoard.toString());
    }

    @Test
    void markNumberColumn() {
        String markedBoard =
                "X 2 3\n" +
                        "X 5 6\n" +
                        "X 8 9";
        Board newBoard = new Board(grid, 3);
        newBoard.markNumber(1);
        newBoard.markNumber(4);
        newBoard.markNumber(7);
        assertEquals(markedBoard, newBoard.toString());
    }

    @Test
    void markNumberColumn_2() {
        String markedBoard =
                "1 X 3\n" +
                        "4 X 6\n" +
                        "7 X 9";
        Board newBoard = new Board(grid, 3);
        newBoard.markNumber(2);
        newBoard.markNumber(5);
        newBoard.markNumber(8);
        assertEquals(markedBoard, newBoard.toString());
    }

    @Test
    void markNumberColumn_3() {
        String markedBoard =
                "1 2 X\n" +
                        "4 5 X\n" +
                        "7 8 X";
        Board newBoard = new Board(grid, 3);
        newBoard.markNumber(3);
        newBoard.markNumber(6);
        newBoard.markNumber(9);
        assertEquals(markedBoard, newBoard.toString());
    }

    @Test
    void markTriggersBingo() {
        String markedBoard =
                "1 2 X\n" +
                        "4 5 X\n" +
                        "7 8 X";
        Board newBoard = new Board(grid, 3);
        assertFalse(newBoard.markNumber(3));
        assertFalse(newBoard.markNumber(6));
        assertTrue(newBoard.markNumber(9));
        assertEquals(markedBoard, newBoard.toString());
    }

    @Test
    void sumOfUnmarkedNumbers() {
        String markedBoard =
                "1 2 X\n" +
                        "4 5 X\n" +
                        "7 8 X";
        Board newBoard = new Board(grid, 3);
        assertFalse(newBoard.markNumber(3));
        assertFalse(newBoard.markNumber(6));
        assertTrue(newBoard.markNumber(9));
        assertEquals(markedBoard, newBoard.toString());
        assertEquals(1 + 2 + 4 + 5 + 7 + 8, newBoard.sumOfUnmarkedNumbers());
    }

}