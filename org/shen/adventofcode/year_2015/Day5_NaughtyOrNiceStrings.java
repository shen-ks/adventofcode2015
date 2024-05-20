package org.shen.adventofcode.year_2015;

import org.shen.adventofcode.year_2015.readInputFiletoArrayList;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Day5_NaughtyOrNiceStrings {

    public static void main(String[] args) {
        readInputFiletoArrayList inputReader = new readInputFiletoArrayList();
        ArrayList<String> receivedStrings = new ArrayList<>();
        Path filePath = Path.of("2015_d5_1.txt");
        receivedStrings = inputReader.readLinesFromFile(String.valueOf(filePath));
        //System.out.println(receivedStrings);

       // int puzzle1Solution = solvePuzzle1(receivedStrings);
        //System.out.println("Puzzle 1 Solution: " + puzzle1Solution);

        int puzzle2Solution = solvePuzzle2(receivedStrings);
        System.out.println("Puzzle 2 Solution: " + puzzle2Solution);

    }

    public static int solvePuzzle1(ArrayList<String> inputData) {
        // Parse the input data and Process the parsed data to solve Puzzle 1

        int solution = 0;

        for( String inputString: inputData) {
            int vowelCount = 0;
            for (char c : inputString.toCharArray()) {
                vowelCount += (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') ? 1 : 0;
            }

            boolean doubleChar = false;
            for (int i = 0; i < inputString.length() - 1; i++) {
                doubleChar |=  inputString.charAt(i) == inputString.charAt(i + 1);
            }

            boolean forbiddenPairs = false;
            forbiddenPairs |= inputString.contains("ab") || inputString.contains("cd") || inputString.contains("pq") || inputString.contains("xy");

            if( vowelCount >= 3 && doubleChar && !forbiddenPairs){
                solution = solution +1;
            }
        }



        return solution;
    }
    public static int solvePuzzle2(ArrayList<String> inputData) {
        // Parse the input data

        // Process the parsed data to solve Puzzle 1
        // ...

        int solution = 0;
        for( String inputString: inputData) {
            // Check for non-overlapping pairs
            boolean nonOverlappingPair = false;
            boolean singleLetterRepeat = false;

            for (int i = 0; i < inputString.length() - 1; i++) {
                    for (int j = i + 1; j < inputString.length() && j + 1 < inputString.length(); j++) {
                        if (inputString.substring(i, i + 2).equals(inputString.substring(j, j + 2)) && i + 1 != j) {
                            nonOverlappingPair = true;
                            break;
                        }
                        if (nonOverlappingPair){
                            break;
                        }
                    }
                }





            // Check for single letter repeats with one letter in between
            for (int i = 0; i < inputString.length() - 2; i++) {
                String substring = inputString.substring(i,i+3);
                if (substring.equalsIgnoreCase(new StringBuilder(substring).reverse().toString())) {
                    singleLetterRepeat = true;
                    break;
                }
            }

            if(nonOverlappingPair && singleLetterRepeat){
                System.out.println(inputString + ":has both nonoverlappingpair and singleletterrepeat");
                solution = solution + 1;
            }
        }
        return solution;
    }

}
