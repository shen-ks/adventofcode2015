package org.shen.adventofcode.year_2015;

import java.nio.file.Path;
import java.util.ArrayList;
public class Day6_FireHazard {

    public static void main(String[] args) {
        readInputFiletoArrayList inputReader = new readInputFiletoArrayList();
        ArrayList<String> receivedStrings;
        Path filePath = Path.of("2015_d6_1.txt");
        receivedStrings = inputReader.readLinesFromFile(String.valueOf(filePath));
        Day6_LightGrid grid = new Day6_LightGrid();
        for (String instruction : receivedStrings) {
            grid.processInstructionPuzzle1(instruction);
        }
        int litCount = grid.countLitLightspuzzle1();
        System.out.println("Number of lit lights: " + litCount);

        Day6_LightGridBrightness gridBrightness = new Day6_LightGridBrightness();
        for (String instruction : receivedStrings) {
            gridBrightness.processInstruction(instruction);
        }
        int totalBrightness = gridBrightness.countTotalBrightness();
        System.out.println("total brightness: " + totalBrightness);
    }

}
