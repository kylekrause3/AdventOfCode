import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class day2 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            ArrayList<Object[]> dirs = new ArrayList<Object[]>();
            String[] split = new String[2];
            int[] position = new int[] {0, 0};
            int aim = 0;
            File data = new File("C:\\Users\\megae\\eclipse-workspace\\Advent-Of-Code\\2021-2\\Input2021-2");
            Scanner scan = new Scanner(data);
            
            while(scan.hasNextLine()) {
                split = scan.nextLine().split(" ");
                dirs.add(new Object[] {new String(split[0]), Integer.valueOf(split[1])});
            }
            for(int i = 0; i < dirs.size(); i++) {
                switch (dirs.get(i)[0].toString()) {
                    case "forward":
                        position[0] += ((Integer)dirs.get(i)[1]).intValue();
                        position[1] += aim * ((Integer)dirs.get(i)[1]).intValue();
                        break;
                    case "down":
                        aim += ((Integer)dirs.get(i)[1]).intValue();
                        break;
                    case "up":
                        aim -= ((Integer)dirs.get(i)[1]).intValue();
                        break;
                }
            }
            
            
            System.out.println("" + position[0] + ", " + position[1] + " = " + (position[0] * position[1]));
        } catch(FileNotFoundException e) {
            System.out.println("err");
        }
    }

}