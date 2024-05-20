package org.shen.adventofcode.year_2015;

import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

public class Day6_LightGrid {
    private Set<Point> litLightspuzzle1 = new HashSet<>();
    private HashSet<Point, Integer> litLightspuzzle2 = new HashSet<>();

    public void processInstructionPuzzle1(String instruction) {
        String[] parts = instruction.split(" ");

        String command = parts[0];
        int x1, y1, x2, y2;


        switch (command) {
            case "turn":
                command = parts[1]; // Get "on" or "off"
                x1 = Integer.parseInt(parts[2].split(",")[0]);
                y1 = Integer.parseInt(parts[2].split(",")[1]);
                x2 = Integer.parseInt(parts[4].split(",")[0]);
                y2 = Integer.parseInt(parts[4].split(",")[1]);

                for (int x = x1; x <= x2; x++) {
                    for (int y = y1; y <= y2; y++) {
                        Point light = new Point(x, y);
                        if (command.equals("on")) {
                            litLightspuzzle1.add(light); // Turn on
                        } else { // "off"
                            litLightspuzzle1.remove(light); // Turn off
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
                        if (litLightspuzzle1.contains(light)) {
                            litLightspuzzle1.remove(light); // Light is on, turn it off
                        } else {
                            litLightspuzzle1.add(light);     // Light is off, turn it on
                        }
                    }
                }
                break;
        }
    }

    // ... (rest of the class: countLitLights, etc.)
    public int countLitLightspuzzle1() {
        return litLightspuzzle1.size();
    }

    public void processInstructionPuzzle2(String instruction) {
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
                        int brightness = litLightspuzzle2.get(light, 0);
                        if (command.equals("on")) {
                            litLightspuzzle2.add(light, brightness + 1);
                        } else { // "off"
                            litLightspuzzle2.add(light, Math.max(0, brightness - 1));
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
                        int brightness = litLightspuzzle2.get(light, 0);
                        litLightspuzzle2.add(light, brightness + 2);
                    }
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + command);
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

