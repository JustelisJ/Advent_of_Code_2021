package com.code.of.advent.solutions.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {

    private FileReader() {

    }

    private static final String INPUT_BASE_PATH = "src/main/resources/inputs/day_%d";

    public static Scanner getScanner(int day, String fileName) throws FileNotFoundException {
        return new Scanner(new File(String.format(INPUT_BASE_PATH, day), fileName));
    }

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

    public static List<Byte> readInputFileSeparateCommas(int day, String fileName) {
        List<Byte> input = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(String.format(INPUT_BASE_PATH, day), fileName))) {
            while (scanner.hasNext()) {
                for(String number: scanner.next().split(",")){
                    input.add(Byte.valueOf(number));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return input;
    }

    public static List<String> readInputFileToStringList(int day, String fileName) {
        List<String> input = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(String.format(INPUT_BASE_PATH, day), fileName))) {
            while (scanner.hasNext()) {
                input.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return input;
    }

}
