package org.shen.adventofcode.year_2015;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

import org.shen.adventofcode.year_2015.readInputFiletoArrayList;
import org.shen.adventofcode.year_2015.Day6_LightGrid;
public class Day6_FireHazard {

    public static void main(String[] args) throws IOException {
        readInputFiletoArrayList inputReader = new readInputFiletoArrayList();
        ArrayList<String> receivedStrings = new ArrayList<>();
        Path filePath = Path.of("2015_d6_1.txt");
        receivedStrings = inputReader.readLinesFromFile(String.valueOf(filePath));
        Day6_LightGrid grid = new Day6_LightGrid();
        for (String instruction : receivedStrings) {
            grid.processInstructionPuzzle1(instruction);
        }
        int litCount = grid.countLitLightspuzzle1();
        System.out.println("Number of lit lights: " + litCount);

    }

}
