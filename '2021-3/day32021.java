import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class day32021 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			File in = new File("../AdventOfCode/'2021-3/Input2021-3");
			Scanner scan = new Scanner(in);
			
			ArrayList<String> bytes= new ArrayList<String>(); //needs to be string or else 00100 would just be 100
			
			while(scan.hasNextLine()) {
				bytes.add(scan.nextLine());
			}
			scan.close();
			diagnostic(bytes);
			System.out.println();
			
			/*	THIS PART IS THE PROBLEM */
			
			//rating(reduce(bytes, 0, true), reduce(bytes, 0, false));
			rating(reduce(bytes, 0, true), reduce(bytes, 0, false));
			
			/* END OF PROBLEM */
			
		} catch(FileNotFoundException e) {
			System.out.println("err");
		}
	}
	
	private static void diagnostic(ArrayList<String> bytes) {
		int bytelength = bytes.get(0).length();
		int[] count = new int[bytelength];
		String bytestr = "";
		
		for(int i = 0; i < bytes.size(); i++) {
			bytestr = bytes.get(i);
			for(int j = 0; j < bytelength; j++) {
				if(bytestr.charAt(j) == '1') count[j] += 1;
			}
		}
		
		String gamma = "";
		String epsilon = "";
		
		for(int i = 0; i < count.length; i++) {
			if(count[i] > (int)(bytes.size() / 2)) {
				gamma += "1";
				epsilon += "0";
			}
			else {
				gamma += "0";
				epsilon += "1";
			}
		}
		
		System.out.println(gamma + " " + epsilon);
		
		int g = Integer.parseInt(gamma, 2);
		int e = Integer.parseInt(epsilon, 2);
		
		System.out.println("" + g + " * " + e + " = " + (g * e));
	}
	
	private static String reduce(ArrayList<String> bytes, int bit, boolean rating) {
		bytes = new ArrayList<String>(bytes); //need this so we don't mutate the original alist
		
		if(bytes.size() == 1) return bytes.get(0);
		
		int[] occ = new int[2];
		for(int i = 0; i < bytes.size(); i++) {
			if(bytes.get(i).charAt(bit) == '1') occ[1]+= 1;
			else occ[0] += 1;
		}
		
		char target;//most common number in index bit
		if(rating) {
			if(occ[0] == occ[1] || occ[1] > occ[0]) target = '1';
			else target = '0';
		}
		else {
			if(occ[0] == occ[1] || occ[1] > occ[0]) target = '0';
			else target = '1';
		}
	
		
		for(int i = 0; i < bytes.size();) {
			if(bytes.get(i).charAt(bit) != target) bytes.remove(i);
			else i+=1;
		}
		
		return reduce(bytes, bit+1, rating);
	}
	
	private static void rating(String b1, String b2) {
		System.out.println(b1 + " " + b2);
		
		int byte1 = Integer.parseInt(b1, 2);
		int byte2 = Integer.parseInt(b2, 2);
		
		System.out.println("" + byte1 + " * " + byte2 + " = " + (byte1 * byte2));
	}
}
