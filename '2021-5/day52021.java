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
			/*
			 * [0,9, 5,9]
[8,0, 0,8]
[9,4, 3,4]
[2,2, 2,1]
[7,0, 7,4]
[6,4, 2,0]
[0,9, 2,9]
[3,4, 1,4]
[0,0, 8,8]
[5,5, 8,2]
			 * 
			 * 
			 */
		} catch(FileNotFoundException e) {
			System.out.println(e);
		}
	}

}
