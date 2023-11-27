package hust.soict.hedspi.garbage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
public class NoGarbage {
	public static void main (String[] args) throws IOException {
		File f = new File("test.txt");
		String absolute = f.getAbsolutePath();
		byte[] inputBytes = {0};
		long startTime;
		long endTime;
		inputBytes = Files.readAllBytes(Paths.get(absolute));
		startTime = System.currentTimeMillis();
		StringBuilder outputStringBuilder = new StringBuilder();
		for (byte b: inputBytes) {
			outputStringBuilder.append((char)b);
		}
		endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
	}
}