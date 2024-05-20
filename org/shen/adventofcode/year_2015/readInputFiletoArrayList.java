package org.shen.adventofcode.year_2015;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class readInputFiletoArrayList {


    public  ArrayList<String> readLinesFromFile (String filename){
        ArrayList<String> ArrayListoflines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                ArrayListoflines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ArrayListoflines;
    }


}