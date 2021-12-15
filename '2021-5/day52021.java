import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class day52021 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			/***** init file into alist string[] *****/
			File file = new File("../AdventOfCode/'2021-5/TestInput2021-5");
			Scanner scan = new Scanner(file);
			ArrayList<String[]> cords = new ArrayList<String[]>();
			
			while(scan.hasNextLine()) {
				cords.add(scan.nextLine().split(" -> "));
			}
			
		} 
		catch(FileNotFoundException e) {
			System.out.println(e);
		}
	}

}
