package com.code.of.advent.solutions.day_4;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class BingoGame {

    private List<Integer> drawnNumbers;
    private List<Board> boards;

    public int winningBoardScore() {
        Board winningBoard = null;
        int winningNumber = 0;
        searchWinner:
        for (Integer number : drawnNumbers) {
            for (Board board : boards) {
                if (board.markNumber(number)) {
                    winningBoard = board;
                    winningNumber = number;
                    break searchWinner;
                }
            }
        }
        if (winningBoard == null)
            throw new RuntimeException("Something went wrong. No winners");
        return winningBoard.sumOfUnmarkedNumbers() * winningNumber;
    }

    public int losingBoardScore() {
        Board losingBoard = null;
        int lastLosingNumber = 0;
        for (Integer number : drawnNumbers) {
            List<Board> boardsCopy = new ArrayList<>(boards);
            for (Board board : boards) {
                if (board.markNumber(number)) {
                    losingBoard = board;
                    boardsCopy.remove(board);
                    lastLosingNumber = number;
                }
            }
            boards = boardsCopy;
            if(boards.isEmpty())
                break;
        }
        if (losingBoard == null)
            throw new RuntimeException("Something went wrong. No winners");
        return losingBoard.sumOfUnmarkedNumbers() * lastLosingNumber;
    }

}
