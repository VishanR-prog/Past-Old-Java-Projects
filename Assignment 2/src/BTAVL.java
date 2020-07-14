public class BTAVL {
    public static void main(String[] args) {

        // Check for command line argument

        if (args.length > 0) {

            // Get seed value

            int seed = Integer.parseInt(args[0]);

            // Get integer range

            int max = Integer.parseInt(args[1]);

            // Get stream length

            int streamLen = Integer.parseInt(args[2]);

            // Create Stream

            Stream stream = new Stream(max, seed);

            // Create StreamProcessor

            StreamProcessor proc = new StreamProcessor(true);

            // Time for tree setup

            long treeSetUp = 0;

            treeSetUp = System.nanoTime();

            // Start adding values

            for (int i = 0; i < streamLen; i++) {

                // Get value

                int value = stream.getNext();

                // Uncomment following only for debugging

                // System.out.println(value);

                // Add value to StreamProcessor

                proc.consume(value);

            }

            treeSetUp = System.nanoTime() - treeSetUp;

            // Show stream

            proc.show();

            System.out.println();

            // Perform operations

            long searchTimeTtl = 0;

            int searchCount = 0;

            long atTimeTtl = 0;

            int atCount = 0;



            for (int i = 3; i < args.length; i++) {

                System.out.println();

                // Check if search

                if (args[i].contains("search")) {

                    // Increment count

                    searchCount += 1;

                    // Get value to search

                    int value = Integer.parseInt(args[i].substring(args[i].indexOf("=") + 1));

                    // Get indices of value

                    long ttlTime = System.nanoTime();

                    int[] array = proc.search(value);

                    ttlTime = System.nanoTime() - ttlTime;

                    // Add to searchTimeTtl

                    searchTimeTtl += ttlTime;

                    // Display

                    System.out.print("search(" + value + ") returns ");

                    if (array != null) {

                        System.out.print("[");

                        for (int j = 0; j < array.length; j++) {

                            if (j == 0)

                                System.out.print(array[j]);

                            else

                                System.out.print(", " + array[j]);

                        }

                        System.out.print("]");

                    } else

                        System.out.print(-1);

                } else if (args[i].contains("at")) { // at

                    // Increment count

                    atCount += 1;

                    // Get value to search

                    long ttlTime = System.nanoTime();

                    int value = Integer.parseInt(args[i].substring(args[i].indexOf("=") + 1));

                    ttlTime = System.nanoTime() - ttlTime;

                    // Add to atTimeTtl

                    atTimeTtl += ttlTime;

                    System.out.print("at(" + value + ") returns " + proc.at(value));

                }

            }

            // Display times

            System.out.println("\ntime(tree setup) = " + ((treeSetUp * 1.0) / 1000000) + " ms");

            System.out.println("time(average search) = " + (((searchTimeTtl * 1.0) / 1000000) / searchCount) + " ms");

            System.out.println("time(average at) = " + (((atTimeTtl * 1.0) / 1000000) / atCount) + " ms");

        } else

            System.out.println("Please provide command line arguments.");

    }
}
