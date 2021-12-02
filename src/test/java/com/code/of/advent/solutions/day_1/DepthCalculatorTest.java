package com.code.of.advent.solutions.day_1;

import com.code.of.advent.solutions.utils.FileReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepthCalculatorTest {

    DepthCalculator depthCalculator;

    @BeforeEach
    void setup() {
        depthCalculator = new DepthCalculator(FileReader.readInputFile(1, "example.txt"));
    }

    @Test
    void exampleReading() {
        assertEquals("[199, 200, 208, 210, 200, 207, 240, 269, 260, 263]", depthCalculator.getDepthList());
    }

    @Test
    void increasingDepths_countIncreasing() {
        assertEquals(7, depthCalculator.increasingDepthCount());
    }

    @Test
    void slidingDepthSumCounter() {
        assertEquals(5, depthCalculator.slidingDepthSumCounter());
    }
}