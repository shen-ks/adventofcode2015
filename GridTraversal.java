import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Scanner;
public class GridTraversal {
	public static void main(String[] args) throws IOException {
		int[] positionSanta = new int[]{0, 0};
		int[] positionRobot = new int[]{0, 0};
		int i = 0;
		
		HashSet<String> visitedBySanta = new HashSet<>();
		HashSet<String> visitedByRobot = new HashSet<>();
		visitedBySanta.add("0,0");
		visitedByRobot.add("0,0");
		System.out.println("Read the input file \"Directions for Santa \":");
		try (Scanner scanLine = new Scanner(Path.of("/Volumes/Sector 3/adventofcode2015/Day3_GridPatternInput.txt"), StandardCharsets.UTF_8)) {
			while (scanLine.hasNextLine()) {
				String path = scanLine.nextLine();
				for (char step : path.toCharArray()) {
					System.out.println("Step " + step + " index:" + i);
					
					if (i % 2 == 0) {
						System.out.println("Santa is at " + positionSanta[0] + "," + positionSanta[1]);
						switch (step) {
							case '>' -> positionSanta[1]++;
							case '<' -> positionSanta[1]--;
							case '^' -> positionSanta[0]++;
							case 'v' -> positionSanta[0]--;
						}
					
					String cell = positionSanta[0] + "," + positionSanta[1];
						System.out.println("Cell " + cell + " visited by Santa");
					if (visitedBySanta.contains(cell) || visitedByRobot.contains(cell)){
						System.out.println("Cell " + cell + " visited by Santa more than once");
					} else {
						visitedBySanta.add(cell);
					}
				}
				else{
					System.out.println("Robot is at " + positionRobot[0] + "," + positionRobot[1]);
						switch (step) {
							case '>' -> positionRobot[1]++;
							case '<' -> positionRobot[1]--;
							case 'v' -> positionRobot[0]--;
							case '^' -> positionRobot[0]++;
						}
					String cell = positionRobot[0] + "," + positionRobot[1];
						System.out.println("Cell " + cell + " visited by Robot");
						
						if (visitedByRobot.contains(cell) || visitedBySanta.contains(cell)) {
						System.out.println("Cell " + cell + " visited by Robot / Santa more than once");
					} else {
						visitedByRobot.add(cell);
					}
				}
				i++;
				}
			}
   		}
		visitedByRobot.removeAll(visitedBySanta);
		System.out.println("Cells visited by Santa at least once: " + visitedBySanta.size() + " \n Cells visited by Robot at least once: " + visitedByRobot.size());
		
	}
}