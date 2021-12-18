package com.code.of.advent.solutions.day_7;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@AllArgsConstructor
public class CrabPositioning {

    List<Integer> initialCrabPosition;

    public int leastFuelToMoveToOneLine() {
        int mostDistantCrab = initialCrabPosition.stream().mapToInt(v -> v).max().orElseThrow();
        int cheapestPosition = -1;
        int cheapestFuel = -1;
        for(int position = 0; position < mostDistantCrab; position++) {
            int fuelCost = 0;
            for(int crab : initialCrabPosition) {
                fuelCost += Math.abs(position - crab);
            }
            if(cheapestFuel > fuelCost || cheapestFuel < 0) {
                cheapestPosition = position;
                cheapestFuel = fuelCost;
            }
        }
        log.info("Cheapest location to blast through - {}", cheapestPosition);
        return cheapestFuel;
    }

    public int leastFuelToMoveToOneLineWithExponentialCost() {
        int mostDistantCrab = initialCrabPosition.stream().mapToInt(v -> v).max().orElseThrow();
        int cheapestPosition = -1;
        int cheapestFuel = -1;
        for(int position = 0; position < mostDistantCrab; position++) {
            int fuelCost = 0;
            for(int crab : initialCrabPosition) {
                for(int i = 1; i <= Math.abs(position - crab); i++)
                    fuelCost += i;
            }
            if(cheapestFuel > fuelCost || cheapestFuel < 0) {
                cheapestPosition = position;
                cheapestFuel = fuelCost;
            }
        }
        log.info("Cheapest location to blast through - {}", cheapestPosition);
        return cheapestFuel;
    }

}
