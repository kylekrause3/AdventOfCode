import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Day12021{
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> alist = new ArrayList<Integer>();
		int cache = Integer.MAX_VALUE;
		int current = 0;
		int counter = 0;
		try {
			File input = new File("../AdventOfCode/'2021-1/Input");
			Scanner scan = new Scanner(input);
			while(scan.hasNextLine()) {
				alist.add(scan.nextInt());
				/*int data = scan.nextInt();
				if(data > cache) counter += 1;
				cache = data;*/
			}
		} catch(FileNotFoundException e) {
			System.out.println("Err");
		}
		
		for(int i = 0; i < alist.size()-2; i++) {
			current = alist.get(i) + alist.get(i+1) + alist.get(i + 2);
			if(current > cache) counter += 1;
			cache = current;
		}
		System.out.println(counter);
	}
}