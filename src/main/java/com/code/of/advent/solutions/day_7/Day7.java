package com.code.of.advent.solutions.day_7;

import com.code.of.advent.solutions.utils.FileReader;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Day7 {

    public static void main(String[] args) {
        CrabPositioning crabPositioning = new CrabPositioning(FileReader.readInputFileSeparateCommas(7, "input.txt"));
        long startTime = System.nanoTime();
        long leastUsedFuel = crabPositioning.leastFuelToMoveToOneLine();
        long endTime = System.nanoTime();
        log.info("Least fueled used - {}. Took {} milliseconds to compute.", leastUsedFuel, (endTime - startTime) / 1000000);
        startTime = System.nanoTime();
        leastUsedFuel = crabPositioning.leastFuelToMoveToOneLineWithExponentialCost();
        endTime = System.nanoTime();
        log.info("Least fueled used with increasing fuel consumption - {}. Took {} milliseconds to compute.", leastUsedFuel, (endTime - startTime) / 1000000);
    }

}
