import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class day42021 {

	public static void main(String[] args) {
	    try{
	      File input = new File("../AdventOfCode/'2021-4/TestInput2021-4");
	      Scanner scan = new Scanner(input);

	      String stuff = "";
	      
	      String nxtln;
	      
	      /*while(scan.hasNextLine()) {
	    	  stuff += scan.nextLine();
	      }*/
	      while(scan.hasNextLine()) {
	    	  nxtln = scan.nextLine();
	    	  if(nxtln.equals("")) stuff += "KYLE KRAUSE";
	    	  else stuff += nxtln;
	      }
	      System.out.println("done scanning" + stuff);
	      scan.close(); 

	      String[] nums = stuff.split("KYLE KRAUSE");
	      //for (String i : nums) System.out.print(i + "(next String)");
	      playbingo(nums);

	    } catch(FileNotFoundException e){
	      System.out.println("err");
	    }
	  }

	  public static void playbingo(String[] nums){
		  System.out.println("playing bingo");
		  String[] pickstr = nums[0].split(",");
		  //for (String i : nums) System.out.print(i + "(next String)");
		  System.out.println();
		  int points;
		  ArrayList<ArrayList<String>>  boards = new ArrayList<ArrayList<String>>();

		  for(int i = 1; i < nums.length; i++) boards.add(new ArrayList<String>(Arrays.asList(nums[i].split(" "))));
		  for(int i = 0; i < boards.size(); i++) {
			  for(int j = 0; j < boards.get(i).size();) {
				  if(boards.get(i).get(j).equals("")) {
					  boards.get(i).remove(j);
				  }
				  else j++;
			  }
		  }
		  ArrayList<ArrayList<String>>  cachedboards = new ArrayList<ArrayList<String>>(boards);
		  
		  for(int i = 0; i < pickstr.length; i++){
			  for(int j = 0; j < boards.size(); j++) {
				  points = checkboard(boards.get(j), cachedboards.get(j), pickstr[i]);
				  if(points != 0) System.out.println(points);
			  }
		  }
	  }

	  public static int checkboard(ArrayList<String> board, ArrayList<String> cboard, String numstr){
		  //System.out.println("Checking board");
		  ArrayList<String> winner = new ArrayList<String>();
	    
		  boolean addedone = false;
		  for(int i = 0; i < board.size(); i++){
			  if(board.get(i).equals(numstr)){
				  board.set(i, "x");
				  addedone = true;
				  break;
	      		}
		  }
	    
		  int ret = 0;
	    
		  if(addedone){
			  winner = checkrowsandcols(board, cboard);
			  if(!winner.get(0).equals("a")) {
				  //System.out.println(winner);
				  for(int i = 0; i < winner.size(); i++) ret+=Integer.parseInt(winner.get(i));
				  ret *= Integer.parseInt(numstr);
			  }
		  }
	    
		  return ret;
	  }

	  public static ArrayList<String> checkrowsandcols(ArrayList<String> board, ArrayList<String> cboard){
		  int columnind = 0;
		  int rowind = 0;
		  boolean colfull;
		  boolean rowfull;
		  ArrayList<String> col = new ArrayList<String>();
		  ArrayList<String> row = new ArrayList<String>();

		  for(int i = 0; i < board.size(); i++){
			  if(board.get(i).equals("x")) {
				  // to get column do i % 5
				  // to get row do (i * 2) / 10 
				  columnind = i % 5;
				  rowind = (int)((i * 2) / 10);
				  for(int j = 0; j < 5; j++){
					  col.add(board.get(columnind * j));
					  row.add(board.get(rowind + j));
				  }
				  System.out.println(col + " " +  row);
				  colfull = isAllSame(col);
				  rowfull = isAllSame(row);
				  if(colfull) {
					  col.clear();
					  for(int j = 0; j < 5; j++) {
						  col.add(cboard.get(columnind * j));
					  }
					  return col;
				  }
				  else if(rowfull) {
					  row.clear();
					  for(int j = 0; j < 5; j++) {
						  row.add(cboard.get(rowind + j));
					  }
					  return row;
				  }

			  }
			  col.clear();
			  row.clear();
		  }
		  ArrayList<String> ret = new ArrayList<String>();
		  ret.add("a");
		  return ret;
	  }

	  public static boolean isAllSame(ArrayList<?> list){
		  Object first=list.get(0);
		  for(int i=1;i<list.size();i++){
			  if(!list.get(i).equals(first))return false;
		  }
		  return true;
	  }

}
