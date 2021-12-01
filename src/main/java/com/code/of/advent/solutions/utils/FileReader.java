package com.code.of.advent.solutions.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {

    private static final String INPUT_BASE_PATH = "src/main/resources/inputs/day %d";

    public static List<Integer> readInputFile(int day, String fileName) {
        List<Integer> input = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(String.format(INPUT_BASE_PATH, day), fileName))) {
            while (scanner.hasNext()) {
                input.add(Integer.valueOf(scanner.next()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return input;
    }

}
