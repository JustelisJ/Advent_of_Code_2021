package com.code.of.advent.solutions.day_6;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@AllArgsConstructor
@Slf4j
public class LanternFish {

    List<Byte> initialLanternFish;

    public long fishCountAfterDays(int days) {
        long[] dayCount = new long[9];
        for (Byte fish : initialLanternFish) {
            dayCount[fish]++;
        }
        for (int i = 0; i < days; i++) {
            long newFish = dayCount[0];
            for (int j = 0; j < 8; j++) {
                dayCount[j] = dayCount[j+1];
            }
            dayCount[6] += newFish;
            dayCount[8] = newFish;
        }
        return dayCount[0] + dayCount[1] + dayCount[2] + dayCount[3] + dayCount[4] + dayCount[5] + dayCount[6] + dayCount[7] + dayCount[8];
    }

}
