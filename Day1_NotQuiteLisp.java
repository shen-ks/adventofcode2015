import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class Day1_NotQuiteLisp {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		ArrayList<Character> parentheses = new ArrayList<>();
		System.out.println("Read the input file NotQuiteLisp:");
		try (Scanner scanLine = new Scanner(
				Path.of("/Volumes/Sector 3/adventofcode2015/NotQuiteLisp.txt"), StandardCharsets.UTF_8)) {
			while (scanLine.hasNextLine()) {
				String line = scanLine.nextLine();
				for (char c : line.toCharArray()) {
					if (c == '(' || c == ')') {
						parentheses.add(c);
					}
				}
			}
			scanLine.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found" + e.getMessage());
		}
		System.out.println("Parentheses found in file: " + parentheses);
		int count = 0;
		for (int i = 0; i < parentheses.size(); i++) {
			char c = parentheses.get(i);
			if (c == '(') {
				count++;
			} else if (c == ')') {
				count--;
			}
			//puzzle 2 answer
			if(count == -1) {
				System.out.println("The basement is reached at: " + (i+1));
				
			}
		}
		//puzzle 1 answer
	System.out.println("The current floor is: " + count);

		
	}
}