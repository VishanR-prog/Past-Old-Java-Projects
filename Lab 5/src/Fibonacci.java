public class Fibonacci {
    public static int callCount;
    public static int fibonacciRec (int n) {
        if (n <= 1)  {
            callCount++;
            return n;
        }
        else {
            callCount++;
            return fibonacciRec(n-1) + fibonacciRec(n-2);
        }
    }
    public  static int fibonacciIter (int n) {
        if (n <= 1) {
            callCount++;
            return n;
        }
        int fib = 1;
        int prevFib = 1;
        for (int i=2; i < n; i++) {
            int temp = fib;
            fib+= prevFib;
            callCount++;
        }
        return fib;
    }
    public static void main(String[] args) {
        System.out.println("Fibonacci:");
        int n = 15;
        int recursiveResult = fibonacciRec(n);
        int recursiveCalls = getCallCount();
        System.out.printf("Recursive result: %d (%d recursive calls)\n",
                recursiveResult, recursiveCalls);
        resetCallCount();
        int iterativeResult = fibonacciIter(n);
        int iterations = getCallCount();
        System.out.printf("Iterative result: %d (%d iterations)\n",
                iterativeResult, iterations);
    }

    private static int resetCallCount() {
    return callCount = 0;
    }
    private static int getCallCount() {
    return callCount;
    }
}
