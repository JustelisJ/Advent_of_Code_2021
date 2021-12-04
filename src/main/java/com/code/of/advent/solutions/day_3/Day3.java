package com.code.of.advent.solutions.day_3;

import com.code.of.advent.solutions.utils.FileReader;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Day3 {

    public static void main(String[] args) {
        PowerConsumption powerConsumption = new PowerConsumption(FileReader.readInputFileToStringList(3, "input.txt"));
        log.info("The power consumption of the submarine is {}", powerConsumption.findPowerConsumption());
        log.info("The life support rating of the submarine is {}", powerConsumption.getLifeSupportRating());
    }

}
