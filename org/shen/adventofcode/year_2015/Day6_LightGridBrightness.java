package org.shen.adventofcode.year_2015;

import java.awt.Point;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Day6_LightGridBrightness {
    private HashMap<Point,Integer> lightBrightness = new HashMap<>();
    public void processInstruction(String instruction) {
        String[] parts = instruction.split(" ");
        String command = parts[0];
        int x1, y1, x2, y2;

        switch (command) {
            case "turn":
                command = parts[1]; // "on" or "off"
                x1 = Integer.parseInt(parts[2].split(",")[0]);
                y1 = Integer.parseInt(parts[2].split(",")[1]);
                x2 = Integer.parseInt(parts[4].split(",")[0]);
                y2 = Integer.parseInt(parts[4].split(",")[1]);

                for (int x = x1; x <= x2; x++) {
                    for (int y = y1; y <= y2; y++) {
                        Point light = new Point(x, y);
                        int brightness = lightBrightness.getOrDefault(light, 0);
                        if (command.equals("on")) {
                            lightBrightness.put(light, brightness + 1);
                        } else { // "off"
                            lightBrightness.put(light, Math.max(0, brightness - 1));
                        }
                    }
                }
                break;

            case "toggle":
                x1 = Integer.parseInt(parts[1].split(",")[0]);
                y1 = Integer.parseInt(parts[1].split(",")[1]);
                x2 = Integer.parseInt(parts[3].split(",")[0]);
                y2 = Integer.parseInt(parts[3].split(",")[1]);

                for (int x = x1; x <= x2; x++) {
                    for (int y = y1; y <= y2; y++) {
                        Point light = new Point(x, y);
                        int brightness = lightBrightness.getOrDefault(light, 0);
                        lightBrightness.put(light, brightness + 2);
                    }
                }
                break;
        }
    }

    public int countTotalBrightness() {
        int totalBrightness = 0;
        for (int brightness : lightBrightness.values()) {
            totalBrightness += brightness;
        }
        return totalBrightness;
    }

}

