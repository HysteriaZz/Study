package other;
import java.io.FileReader;


public class FileIO {
	
		public static void main(String[] args) {
			try {
				FileReader fr = new FileReader("thinkin/src/other/FileWriter.txt");
				char[] array = new char[2];
				int len = fr.read(array);
				String str = new String(array);
				System.out.println("1=" + str + "," + "2=" + len);
				fr.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	
	
	
}