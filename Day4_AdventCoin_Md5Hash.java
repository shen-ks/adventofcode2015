import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Day4_AdventCoin_Md5Hash {
		public static void main(String[] args) throws NoSuchAlgorithmException {
			String secretKey = "iwrupvqb";
			int num = 1;
			String hash = "";
			MessageDigest md = MessageDigest.getInstance("MD5");
			while (!hash.startsWith("000000")) {
				num++;
				String input = secretKey + num;
				md.update(input.getBytes());
				byte[] digest = md.digest();
				hash = bytesToHex(digest);
			}
			System.out.println("Lowest positive number is: " + num);
		}
		
		public static String bytesToHex(byte[] bytes) {
			StringBuilder sb = new StringBuilder();
			for (byte b : bytes) {
				sb.append(String.format("%02x", b));
			}
			return sb.toString();
		}
	}

