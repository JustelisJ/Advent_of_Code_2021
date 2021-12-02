package com.code.of.advent.solutions.day_1;

import com.code.of.advent.solutions.utils.FileReader;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Day1 {

    public static void main(String[] args) {
        DepthCalculator depthCalculator = new DepthCalculator(FileReader.readInputFile(1, "input.txt"));
        log.info(String.format("Increasing depths - %d", depthCalculator.increasingDepthCount()));
        log.info(String.format("Sliding depth count - %d", depthCalculator.slidingDepthSumCounter()));
    }

}
