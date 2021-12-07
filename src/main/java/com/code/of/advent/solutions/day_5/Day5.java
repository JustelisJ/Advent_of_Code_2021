package com.code.of.advent.solutions.day_5;

import com.code.of.advent.solutions.utils.FileReader;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Day5 {

    public static void main(String[] args) {
        HydrothermalVentMap map = new HydrothermalVentMap(FileReader.readInputFileToStringList(5, "input.txt"));
        log.info("Points where at least two lines overlap without diagonals - {}", map.countOfVerticalHorizontalPointsOverlapping());
        log.info("Points where at least two lines overlap with diagonals - {}", map.countOfVerticalHorizontalAndDiagonalPointsOverlapping());
    }

}
