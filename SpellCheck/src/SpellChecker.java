import java.io.FileNotFoundException;
import java.util.*;
import java.io.File;

public class SpellChecker {
    static String filename = "C:\\Users\\visha\\Downloads\\bonk.txt";
    private ArrayList<String> dictionary = new ArrayList<String>();

    private TreeSet<String> nonDuplicates = new TreeSet<String>();


    public ArrayList<String> spell(String filename) throws FileNotFoundException {

        try (Scanner sc = new Scanner(new File("C:\\Users\\visha\\Downloads\\dictionary.txt"))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                dictionary.add(line);
            }
            sc.close();
        }
        return dictionary;
    }

    public void printNonDuplicates(ArrayList<String> filename) {
        System.out.println("Reading input from: " + filename + ": ");

        nonDuplicates.clear();

        String line = "";
        int lineNumber = 1;
        Scanner input = null;
        try {
            input = new Scanner(new File("C:\\Users\\visha\\Downloads\\bonk.txt"));
            System.out.println(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner userInput = new Scanner(System.in);

        while (input.hasNextLine()) {
            line = input.nextLine();
            // For each line, break the line into words using the following StringTokenizer
            StringTokenizer st = new StringTokenizer(line, " ()\t,.;:-%'\"");
            while (st.hasMoreTokens()) {
                String word = st.nextToken();
                word = word.toLowerCase();
                if (Character.isLetter(word.charAt(0))) {
                    if (dictionary.contains(word) == false && nonDuplicates.contains(word) == false) {
                        if (word.charAt(word.length() - 1) == 's') {
                            word = word.substring(0, word.length() - 1);
                        }
                        System.out.println(lineNumber + " : " + line);
                        lineNumber += 1;
                        System.out.println(word);
                    }
                }
            }
        }
        input.close();
    }

    public boolean inDictionary(String word, String[] dictionary) {
        return Arrays.stream(dictionary).anyMatch(word::contains);
    }

    public static void main(String[] args) throws FileNotFoundException {
        SpellChecker sc = new SpellChecker();
        sc.spell("bonk.txt");
    }
}