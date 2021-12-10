import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Reduce {
	public ArrayList<String> bytes;
	public Reduce(ArrayList<String> alist) {
		bytes = alist;
	}
	
	
	public String reduce(ArrayList<String> bytes, int bit) {
		if(bytes.size() == 1) return bytes.get(0);
		
		int[] occ = new int[2];
		for(int i = 0; i < bytes.size(); i++) {
			if(bytes.get(i).charAt(bit) == '1') occ[1]+= 1;
			else occ[0] += 1;
		}
		
		char target;//most common number in index bit
		
		if(occ[0] == occ[1] || occ[1] > occ[0]) target = '1';
		else target = '0';
		
		System.out.println(target);
		for(int i = 0; i < bytes.size();) {
			if(bytes.get(i).charAt(bit) != target) bytes.remove(i);
			else i+=1;
		}
		
		return reduce(bytes, bit+1);
	}
	
	
}
