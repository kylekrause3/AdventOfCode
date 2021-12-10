import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class day32020 {
	static String current = "";
	
	public static void main(String[] args) {
		try {
			File in = new File("../AdventOfCode/2020-3/Input2020-3");
			Scanner scan = new Scanner(in);
			
			ArrayList<String> slope = new ArrayList<String>();
			int pos = 1;
			int encounters = 0;
			
			ArrayList<Integer[]> paths = new ArrayList<Integer[]>(); // could probably use a normal 2d array but im lazy
			paths.add(new Integer[] {1, 1});
			paths.add(new Integer[] {3, 1});
			paths.add(new Integer[] {5, 1});
			paths.add(new Integer[] {7, 1});
			paths.add(new Integer[] {1, 2});
			
			int[] numtrees = new int[paths.size()];
			
			while(scan.hasNextLine()) slope.add(scan.nextLine());
			
			for(int i = 0; i < paths.size(); i++) {
				numtrees[i] = go(encounters, slope, pos, paths.get(i)[0], paths.get(i)[1]);
			}
			
			BigInteger ret = new BigInteger("1"); // had to do biginteger because multiplicative solution reached higher than integer max
			for(int j = 0; j < numtrees.length; j++) {
				System.out.println(numtrees[j]);
				ret = ret.multiply(BigInteger.valueOf(numtrees[j]));
			}
			System.out.println(ret);
			
		} catch(FileNotFoundException e) {
			System.out.println("err");
		}
	}
	
	
	private static int go(int encounters, ArrayList<String> slope, int pos, int right, int down) {
		for(int i = 0; i < slope.size()-down; i += down) { //i += down IS VERY IMPORTANT
			current = slope.get(i + down); //next part of slope
			pos += right;
			if(pos > current.length()) {
				pos = pos - current.length();
			}
			
			if(current.charAt(pos - 1) == '#'){
				encounters += 1;
			}
		}
		return encounters;
	}
}
