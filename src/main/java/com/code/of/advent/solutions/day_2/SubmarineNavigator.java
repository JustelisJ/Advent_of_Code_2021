package com.code.of.advent.solutions.day_2;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@AllArgsConstructor
@Slf4j
public class SubmarineNavigator {

    public static final String DISTANCE = "distance";
    public static final String ACTION = "action";
    List<String> submarineMoves;

    public int findFinalCoordinateMultiplication() {
        int x = 0;
        int y = 0;

        Pattern movePattern = Pattern.compile("^(?<action>[a-zA-Z]+) (?<distance>[0-9]+)");
        for (String move : submarineMoves) {
            Matcher matcher = movePattern.matcher(move);
            matcher.find();
            int distance = Integer.parseInt(matcher.group(DISTANCE));
            switch (matcher.group(ACTION)) {
                case "forward":
                    x += distance;
                    break;
                case "down":
                    y += distance;
                    break;
                case "up":
                    y -= distance;
                    break;
                default:
                    log.error("Invalid action: {} {}", matcher.group(ACTION), matcher.group(DISTANCE));
            }
        }

        return x * y;
    }

    public int findFinalCoordinateMultiplicationWithAim() {
        int x = 0;
        int y = 0;
        int aim = 0;

        Pattern movePattern = Pattern.compile("^(?<action>[a-zA-Z]+) (?<distance>[0-9]+)");
        for (String move : submarineMoves) {
            Matcher matcher = movePattern.matcher(move);
            matcher.find();
            int distance = Integer.parseInt(matcher.group(DISTANCE));
            switch (matcher.group(ACTION)) {
                case "forward":
                    x += distance;
                    y += aim * distance;
                    break;
                case "down":
                    aim += distance;
                    break;
                case "up":
                    aim -= distance;
                    break;
                default:
                    log.error("Invalid action: {} {}", matcher.group(ACTION), matcher.group(DISTANCE));
            }
        }

        return x * y;
    }

}
