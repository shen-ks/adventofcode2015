import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class WebpageInputReader {
	
	public static void main(String[] args) {
		ArrayList<String> lines = readWebpageToArrayList("https://example-files.online-convert.com/document/txt/example.txt");
		for (String line : lines) {
			System.out.println(line);
		}
	}
	
	public static ArrayList<String> readWebpageToArrayList(String urlString) {
		ArrayList<String> lines = new ArrayList<>();
		try {
			URL url = new URL(urlString);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			
			Scanner scanner = new Scanner(conn.getInputStream());
			while (scanner.hasNextLine()) {
				lines.add(scanner.nextLine());
			}
			scanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}
}
