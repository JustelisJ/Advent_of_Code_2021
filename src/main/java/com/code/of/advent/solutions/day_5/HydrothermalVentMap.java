package com.code.of.advent.solutions.day_5;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@AllArgsConstructor
public class HydrothermalVentMap {

    List<String> ventMapping;

    public int countOfVerticalHorizontalPointsOverlapping() {
        int[][] seaFloorMap = makeRequiredMap();
        Pattern linePattern = Pattern.compile("^(?<x1>\\d+),(?<y1>\\d+) -> (?<x2>\\d+),(?<y2>\\d+)");
        for (String line : ventMapping) {
            Matcher matcher = linePattern.matcher(line);
            if (matcher.find()) {
                Point[] bothPoints = getBothPoints(matcher);
                int x1 = bothPoints[0].getX();
                int y1 = bothPoints[0].getY();
                int x2 = bothPoints[1].getX();
                int y2 = bothPoints[1].getY();
                if (x1 == x2 || y1 == y2) {//only work on non-diagonal lines
                    if (x1 == x2) {
                        if (y1 < y2) {
                            for (int i = y1; i <= y2; i++) {
                                seaFloorMap[i][x1]++;
                            }
                        } else {
                            for (int i = y2; i <= y1; i++) {
                                seaFloorMap[i][x1]++;
                            }
                        }
                    } else {
                        if (x1 < x2) {
                            for (int i = x1; i <= x2; i++) {
                                seaFloorMap[y1][i]++;
                            }
                        } else {
                            for (int i = x2; i <= x1; i++) {
                                seaFloorMap[y1][i]++;
                            }
                        }
                    }
                }
            }
        }
        return findTilesWhereLinesOverlap(seaFloorMap);
    }

    public int countOfVerticalHorizontalAndDiagonalPointsOverlapping() {
        int[][] seaFloorMap = makeRequiredMap();
        Pattern linePattern = Pattern.compile("^(?<x1>\\d+),(?<y1>\\d+) -> (?<x2>\\d+),(?<y2>\\d+)");
        for (String line : ventMapping) {
            Matcher matcher = linePattern.matcher(line);
            if (matcher.find()) {
                Point[] bothPoints = getBothPoints(matcher);
                int x1 = bothPoints[0].getX();
                int y1 = bothPoints[0].getY();
                int x2 = bothPoints[1].getX();
                int y2 = bothPoints[1].getY();
                if (x1 == x2 || y1 == y2) {//only work on non-diagonal lines
                    if (x1 == x2) {
                        if (y1 < y2) {
                            for (int i = y1; i <= y2; i++) {
                                seaFloorMap[i][x1]++;
                            }
                        } else {
                            for (int i = y2; i <= y1; i++) {
                                seaFloorMap[i][x1]++;
                            }
                        }
                    } else {
                        if (x1 < x2) {
                            for (int i = x1; i <= x2; i++) {
                                seaFloorMap[y1][i]++;
                            }
                        } else {
                            for (int i = x2; i <= x1; i++) {
                                seaFloorMap[y1][i]++;
                            }
                        }
                    }
                } else { //handling diagonals
                    int diff = Math.abs(x1 - x2);
                    for (int i = 0; i <= diff; i++) {
                        if (x1 > x2) {
                            if (y1 > y2) {
                                seaFloorMap[x1 - i][y1 - i]++;
                            } else {
                                seaFloorMap[x1 - i][y1 + i]++;
                            }
                        } else {
                            if (y1 > y2) {
                                seaFloorMap[x1 + i][y1 - i]++;
                            } else {
                                seaFloorMap[x1 + i][y1 + i]++;
                            }
                        }
                    }
                }
            }
        }
        return findTilesWhereLinesOverlap(seaFloorMap);
    }

    private int findTilesWhereLinesOverlap(int[][] seaFloorMap) {
        int count = 0;
        for (int[] ints : seaFloorMap) {
            for (int anInt : ints) {
                if (anInt > 1)
                    count++;
            }
        }
        return count;
    }

    private int[][] makeRequiredMap() {
        int maxX = 0;
        int maxY = 0;
        Pattern linePattern = Pattern.compile("^(?<x1>\\d+),(?<y1>\\d+) -> (?<x2>\\d+),(?<y2>\\d+)");
        for (String line : ventMapping) {
            Matcher matcher = linePattern.matcher(line);
            if (matcher.find()) {
                maxX = setMaxX(maxX, matcher);
                maxY = setMaxY(maxY, matcher);
            }
        }
        return new int[maxY + 1][maxX + 1];
    }

    private int setMaxY(int maxY, Matcher matcher) {
        if (Integer.parseInt(matcher.group("y1")) > maxY) {
            maxY = Integer.parseInt(matcher.group("y1"));
        }
        if (Integer.parseInt(matcher.group("y2")) > maxY) {
            maxY = Integer.parseInt(matcher.group("y2"));
        }
        return maxY;
    }

    private int setMaxX(int maxX, Matcher matcher) {
        if (Integer.parseInt(matcher.group("x1")) > maxX) {
            maxX = Integer.parseInt(matcher.group("x1"));
        }
        if (Integer.parseInt(matcher.group("x2")) > maxX) {
            maxX = Integer.parseInt(matcher.group("x2"));
        }
        return maxX;
    }

    private Point[] getBothPoints(Matcher matcher) {
        int x1 = Integer.parseInt(matcher.group("x1"));
        int x2 = Integer.parseInt(matcher.group("x2"));
        int y1 = Integer.parseInt(matcher.group("y1"));
        int y2 = Integer.parseInt(matcher.group("y2"));
        return new Point[]{new Point(x1, y1), new Point(x2, y2)};
    }

    @AllArgsConstructor
    @Getter
    private class Point {
        private int x;
        private int y;
    }

}
