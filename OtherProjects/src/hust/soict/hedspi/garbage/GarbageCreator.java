package hust.soict.dsai.garbage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
public class GarbageCreator {
	public static void main (String[] args) throws IOException {
		File f = new File("test.txt");
		String absolute = f.getAbsolutePath();
		byte[] inputBytes = {0};
		long startTime;
		long endTime;
		inputBytes = Files.readAllBytes(Paths.get(absolute));
		startTime = System.currentTimeMillis();
		
		String outputString = "";
		for (byte b: inputBytes) {
			outputString += (char)b;
		}
		//Observation: The system hanged for a long time
		
		endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
	}
}