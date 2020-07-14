import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class circuitdesign {

    static String filename = "C:\\Users\\visha\\Downloads\\data.txt";
    Scanner scanner = null;

    public void readFileByLine (String filename) {
        File file = new File(filename);
        try  {
            scanner = new Scanner(file);


        } catch(FileNotFoundException e)
        {
            System.out.println("Error opening the file " + filename);
            System.exit(0);
        }

        while (scanner.hasNextLine());
        {

            String line = scanner.nextLine();
            System.out.println(line);

        }
    }


    public static void main(String[] args) {
        circuitdesign sc = new circuitdesign();
        sc.readFileByLine(filename);
    }

}
