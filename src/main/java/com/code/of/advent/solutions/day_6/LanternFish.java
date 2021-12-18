package com.code.of.advent.solutions.day_6;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Slf4j
public class LanternFish {

    List<Byte> initialLanternFish;

    public int fishCountAfterDays(int days) {
        List<Byte> lanternFish = new ArrayList<>(initialLanternFish);
        for(int i = 0; i < days; i++) {
            if(i % 10 == 0){
                log.info("day {}. Fish size - {}", i+1, lanternFish.size());
            }
            List<Byte> lanternFishNextDay = new ArrayList<>();
            int newFishCount = 0;
            for (Byte fish : lanternFish) {
                fish--;
                if(fish == -1) {
                    lanternFishNextDay.add((byte) 6);
                    newFishCount++;
                } else {
                    lanternFishNextDay.add(fish);
                }
            }
            addNewFish(lanternFishNextDay, newFishCount);
            lanternFish = lanternFishNextDay;
        }
        return lanternFish.size();
    }

    private void addNewFish(List<Byte> lanternFishNextDay, int newFishCount) {
        for(int j = 0; j < newFishCount; j++) {
            lanternFishNextDay.add((byte) 8);
        }
    }

}
