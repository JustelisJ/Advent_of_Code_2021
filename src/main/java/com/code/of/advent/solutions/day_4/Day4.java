package com.code.of.advent.solutions.day_4;

import com.code.of.advent.solutions.utils.FileReader;
import lombok.extern.slf4j.Slf4j;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Slf4j
public class Day4 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = FileReader.getScanner(4, "input.txt");
        List<Integer> bingoNumbers = Arrays.stream(scanner.nextLine().split(",")).map(Integer::parseInt).collect(Collectors.toList());
        scanner.nextLine();
        List<Board> boards = new ArrayList<>();
        int[][] boardGrid = new int[5][5];
        int y = 0;
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if(line.equals("")) {
                boards.add(new Board(boardGrid, 5));
                boardGrid = new int[5][5];
                y = 0;
            } else {
                List<Integer> lineNumbers = Arrays.stream(line.trim().split(" "))
                        .filter(s -> !s.isBlank())
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
                for(int x = 0; x < lineNumbers.size(); x++){
                    boardGrid[y][x] = lineNumbers.get(x);
                }
                y++;
            }
        }
        boards.add(new Board(boardGrid, 5));
        BingoGame bingoGame = new BingoGame(bingoNumbers, boards);
        log.info("Final score for the winning board is {}", bingoGame.winningBoardScore());
        log.info("Final score for the losing board is {}", bingoGame.losingBoardScore());
    }

}
