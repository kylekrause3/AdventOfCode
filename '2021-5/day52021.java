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
			generate(cords);
		} 
		catch(FileNotFoundException e) {
			System.out.println(e);
		}
	}
	
	
	public static void generate(ArrayList<String[]> cords){
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		int x1, y1, x2, y2;
		
		for(int i = 0; i < cords.size(); i++) {
			x1 = Integer.parseInt(cords.get(i)[0].split(",", 2)[0]);
			y1 = Integer.parseInt(cords.get(i)[0].split(",", 2)[1]);
			x2 = Integer.parseInt(cords.get(i)[1].split(",", 2)[0]);
			y2 = Integer.parseInt(cords.get(i)[1].split(",", 2)[1]);
			
			int[] max = new int[] {bigger(x1, x2), bigger(y1, y2)};
			
			
			int xadded = 0;
			if(x1 == x2 || y1 == y2) {//if the line is vertical or it is horizontal(part 1)
				if(graph.get(0).size()/*size of x axis*/ < max[0]) {
					for(int j = 0; j < max[0]; j++) {
						graph.get(0).add(0);
						xadded += 1;
					}
					for(int j = 0; j < graph.size(); j++) {
						for(int k = 0; k < xadded; k++) {
							graph.get(j).add(0);
						}
					}
					xadded = 0;
				}
				if(graph.size()/*size of y axis*/ < max[1]) {
					
				}
			}
			
		}
		
	}
	
	public static int bigger(int a, int b) {
		if(a > b) return a;
		else return b;
	}

}
