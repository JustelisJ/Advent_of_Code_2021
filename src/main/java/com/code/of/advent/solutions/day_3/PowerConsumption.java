package com.code.of.advent.solutions.day_3;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class PowerConsumption {

    List<String> report;

    public int findPowerConsumption() {
        int[] oneBitCounter = getBits1ByLocation(report);
        String gammaBinary = "";
        String epsilonBinary = "";
        for (int j : oneBitCounter) {
            if (j * 2 > report.size()) {
                gammaBinary = gammaBinary.concat("1");
                epsilonBinary = epsilonBinary.concat("0");
            } else {
                gammaBinary = gammaBinary.concat("0");
                epsilonBinary = epsilonBinary.concat("1");
            }
        }
        int gamma = Integer.parseInt(gammaBinary, 2);
        int epsilon = Integer.parseInt(epsilonBinary, 2);
        return gamma * epsilon;
    }

    private int[] getBits1ByLocation(List<String> diagnostics) {
        int[] oneBitCounter = new int[report.get(0).length()];
        for (String binary : diagnostics) {
            char[] bits = binary.toCharArray();
            for (int i = 0; i < bits.length; i++) {
                if (bits[i] == '1') {
                    oneBitCounter[i]++;
                }
            }
        }
        return oneBitCounter;
    }

    public int getLifeSupportRating() {
        String oxygenRating = findOxygenGeneratorRating();
        String co2Rating = findCo2ScrubberRating();
        return Integer.parseInt(oxygenRating, 2) * Integer.parseInt(co2Rating, 2);
    }

    private String findCo2ScrubberRating() {
        List<String> reportCopy = new ArrayList<>(report);
        int i = 0;
        while (reportCopy.size() > 1) {
            List<String> reportToRemove = new ArrayList<>(reportCopy);
            int[] oneBitCounter = getBits1ByLocation(reportToRemove);
            for (String diagnostic : reportCopy) {
                if (diagnostic.charAt(i) != determineReverseBit(oneBitCounter, i, reportCopy)) {
                    reportToRemove.remove(diagnostic);
                }
            }
            reportCopy = new ArrayList<>(reportToRemove);
            i++;
        }
        return reportCopy.get(0);
    }

    private String findOxygenGeneratorRating() {
        List<String> reportCopy = new ArrayList<>(report);
        int i = 0;
        while (reportCopy.size() > 1) {
            List<String> reportToRemove = new ArrayList<>(reportCopy);
            int[] oneBitCounter = getBits1ByLocation(reportToRemove);
            for (String diagnostic : reportCopy) {
                if (diagnostic.charAt(i) != determineTheBit(oneBitCounter, i, reportCopy)) {
                    reportToRemove.remove(diagnostic);
                }
            }
            reportCopy = new ArrayList<>(reportToRemove);
            i++;
        }
        return reportCopy.get(0);
    }

    private char determineTheBit(int[] oneBitCounter, int i, List<String> diagnostics) {
        if (oneBitCounter[i] * 2 >= diagnostics.size()) {
            return '1';
        } else {
            return '0';
        }
    }

    private char determineReverseBit(int[] oneBitCounter, int i, List<String> diagnostics) {
        if(determineTheBit(oneBitCounter, i, diagnostics) == '1') {
            return '0';
        } else {
            return '1';
        }
    }
}
