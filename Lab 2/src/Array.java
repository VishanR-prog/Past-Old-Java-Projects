import java.util.InputMismatchException;
import java.util.Scanner;
public class Array {

    private static int size = 100;

    public static void main(String[] args) {

        try {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter list: ");
            size = input.nextInt();
            int[] numbers = new int[size];
            for (int i = 0; i < size; i++) {
                numbers[i] = input.nextInt();
            }
            if (isSorted(numbers)) System.out.print("The list is already sorted.\n");
            else System.out.print("The list is not sorted.\n");
        } catch (InputMismatchException i) {
            i.printStackTrace();
            System.err.println("Entered value is not an integer");
        }


    }

    public static boolean isSorted(int[] list) {

        for (int i = 0; i < list.length - 1; i++) {

            if (list[i] > list[i + 1]) return false;

        }
        return true;
    }
    public static void printArray(int[] array, int numberPerLine) {

        for (int i = 0; i < array.length; i++) {

            System.out.printf("%4d ", array[i]);
            if ((i + 1) % numberPerLine == 0) System.out.println("");
        }
    }
}

