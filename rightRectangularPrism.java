import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
public class rightRectangularPrism {
	private static final Logger MYLOGGER = Logger.getLogger(rightRectangularPrism.class.getName());
	public static void main(String[] args)  {
		MYLOGGER.setLevel(Level.INFO);
		ArrayList<String> cubeSize = new ArrayList<>();
		System.out.println("Read the input file cuboidSizeInputs:");
		try (
				Scanner scanLine = new Scanner(
						Path.of("/Volumes/Sector 3/adventofcode2015/cuboidSizeInputs.txt"), StandardCharsets.UTF_8)) {
			while (scanLine.hasNextLine()) {
				String line = scanLine.nextLine();
				cubeSize.add(line);
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found" + e.getMessage());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
//print info logger with the arraylist inputs
		MYLOGGER.info( "Cube size inputs: " + cubeSize);
		double totalSurfaceArea = 0.0;
		double totalfeetofribbon = 0.0;
		for (String input : cubeSize) {
			// Split input into length, width, and height
			String[] dimensions = input.split("x");
			double length = Double.parseDouble(dimensions[0]);
			double width = Double.parseDouble(dimensions[1]);
			double height = Double.parseDouble(dimensions[2]);
			
			// Calculate surface area and add it to running total
			double surfaceArea = calculateSurfaceAreaWithSmallestSide(length, width, height);
			totalSurfaceArea += surfaceArea;
			double ribbonlength = calculateRibbonLength(length, width, height);
			totalfeetofribbon += ribbonlength;
		}
		
		System.out.println("Total surface area: " + totalSurfaceArea);
		System.out.println("Total feet of ribbon: " + totalfeetofribbon);
	}
	public static double calculateSurfaceArea(double length, double width, double height) {
		double topAndBottomArea = 2 * length * width;
		double frontAndBackArea = 2 * length * height;
		double leftAndRightArea = 2 * width * height;
		return topAndBottomArea + frontAndBackArea + leftAndRightArea;
	}
	
	public static double calculateSurfaceAreaWithSmallestSide(double length, double width, double height) {
		double surfaceArea = calculateSurfaceArea(length, width, height);
		double smallestSideArea = Math.min(Math.min(length * width, length * height), width * height);
		return surfaceArea + smallestSideArea;
	}
	
	public static double calculateRibbonLength(double length, double width, double height) {
		double smallestPerimeter = Math.min(Math.min(2 * length + 2 * width, 2 * length + 2 * height), 2 * width + 2 * height);
		double volume = length * width * height;
		return smallestPerimeter + volume;
	}
}
