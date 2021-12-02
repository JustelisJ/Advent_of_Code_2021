package com.code.of.advent.solutions.day_1;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class DepthCalculator {

    private List<Integer> depths;

    public int increasingDepthCount() {
        int count = 0;
        int previous = depths.get(0);
        for (Integer depth : depths) {
            if (previous < depth) {
                count++;
            }
            previous = depth;
        }
        return count;
    }

    public int slidingDepthSumCounter() {
        int count = 0;
        int previousSum = Integer.MAX_VALUE;
        for (int i = 0; i < depths.size() - 2; i++) {
            int slidingSum = depths.get(i) + depths.get(i + 1) + depths.get(i + 2);
            if (previousSum < slidingSum) {
                count++;
            }
            previousSum = slidingSum;
        }
        return count;
    }

    public String getDepthList() {
        return depths.toString();
    }

}
