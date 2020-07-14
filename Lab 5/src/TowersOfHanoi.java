public class TowersOfHanoi {
    public static void solveHanoi(int source, int swap, int Dest, int size) {
        if (source == 0) {
            System.out.println("Moving Disc " + source + " to " + size);
        } else {
            solveHanoi(source-1, swap, size, Dest);
            System.out.println("Moving Disc " + source +  " from " + swap + " to " + size);
            solveHanoi(source-1, Dest, swap, size);
        }
    }
    public static void main(String[] args) {
        System.out.println("Towers of Hanoi:");
        solveHanoi(1, 3, 2, 4);
    }
}
