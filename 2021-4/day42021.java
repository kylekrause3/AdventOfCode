import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day42021 {

	public static void main(String[] args) {
	    try{
	      File input = new File("./testinput42021");
	      Scanner scan = new Scanner(input);

	      String stuff = "";

	      while(scan.hasNextLine()) stuff += scan.nextLine();
	      scan.close(); 

	      String[] nums = stuff.split("\n\n");

	      playbingo(nums);

	    } catch(FileNotFoundException e){
	      System.out.println("err");
	    }
	  }

	  public static void playbingo(String[] nums){
	    String[] pickstr = nums[0].split(",");
	    ArrayList<String[]>  boards = new ArrayList();

	    for(int i = 1; i > nums.length; i++) boards.add(nums[i].split(" "));

	    for(int i = 0; i < pickstr.length; i++){
	      for(int j = 0; j < boards.size(); j++) checkboard(boards.get(j), pickstr[i]);
	    }
	  }

	  public static void checkboard(String[] board, String numstr){
	    ArrayList<String> winner = new ArrayList();
	    boolean addedone = false;
	    for(int i = 0; i < board.length; i++){
	      if(board[i].equals(numstr)){
	        board[i] = "x";
	        addedone = true;
	        break;
	      }
	    }

	    int[][] counter = new int[2][5];

	    if(addedone){
	      winner = checkrowsandcols(board);
	      if(winner != null);
	    }

	  }

	  public static ArrayList<String> checkrowsandcols(String[] board){
	    int columnind = 0;
	    int rowind = 0;
	    boolean colfull;
	    boolean rowfull;
	    ArrayList<String> col = new ArrayList();
	    ArrayList<String> row = new ArrayList();

	    for(int i = 0; i < board.length; i++){
	      if(board[i].equals("x")) {
	        // to get column do i % 5
	        // to get row do (i * 2) / 10 
	        columnind = i % 5;
	        rowind = (int)((i * 2) / 10);
	        for(int j = 0; j < 5; j++){
	          col.add(board[columnind * j]);
	          row.add(board[rowind + j]);
	        }
	        colfull = isAllSame(col);
	        rowfull = isAllSame(row);
	        if(colfull) return col;
	        else if(rowfull) return row;

	      }
	      col.clear();
	      row.clear();
	    }
	    return null;
	  }

	  public static boolean isAllSame(ArrayList<?> list){
	    Object first=list.get(0);
	    for(int i=1;i<list.size();i++){
	      if(!list.get(i).equals(first))return false;
	    }
	    return true;
	  }

}
