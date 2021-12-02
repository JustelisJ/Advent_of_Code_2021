package com.code.of.advent.solutions.day_2;

import com.code.of.advent.solutions.utils.FileReader;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Day2 {

    public static void main(String[] args) {
        SubmarineNavigator submarineNavigator = new SubmarineNavigator(FileReader.readInputFileToStringList(2, "input.txt"));
        log.info(String.format("Coordinate X and Y multiplication - %d", submarineNavigator.findFinalCoordinateMultiplication()));
        log.info(String.format("Coordinate X and Y multiplication with aim - %d", submarineNavigator.findFinalCoordinateMultiplicationWithAim()));
    }

}
