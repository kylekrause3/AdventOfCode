import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class day22020 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> split = new ArrayList<String>();
		try {
			File input = new File("C:\\Users\\Kyle Krause\\eclipse-workspace\\Advent-Of-Code\\2020-2.1\\Input.txt");
			Scanner scan = new Scanner(input);
			while(scan.hasNextLine()) {
				String data = scan.nextLine();
				//split = Arrays.asArray(data.split(":", 2));
				
				
				//System.out.println(split[0] + split[1]);
			}
		} catch(FileNotFoundException e) {
			System.out.println("Err");
		}
	}

}
