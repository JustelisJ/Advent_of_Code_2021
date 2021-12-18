package com.code.of.advent.solutions.day_6;

import com.code.of.advent.solutions.utils.FileReader;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Day6 {

    public static void main(String[] args) {
        LanternFish lanternFish = new LanternFish(FileReader.readInputFileSeparateCommas(6, "input.txt"));
        long startTime = System.nanoTime();
        long fishCount = lanternFish.fishCountAfterDays(80);
        long endTime = System.nanoTime();
        log.info("Lantern fish population after 80 days grows to - {}. Took {} milliseconds to compute.", fishCount, (endTime - startTime) / 1000000);
        startTime = System.nanoTime();
        fishCount = lanternFish.fishCountAfterDays(256);
        endTime = System.nanoTime();
        log.info("Lantern fish population after 256 days grows to - {}. Took {} milliseconds to compute.", fishCount, (endTime - startTime) / 1000000);
    }

}
