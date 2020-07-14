import java.util.*;

public class SortNumbers {
    interface Comparator<T> {
        int compare(T a, T b);
    }

    abstract class ArraySort<T> {
        public Comparator<T> comparator;

        abstract public void iSort(T[] inArray);

        //abstract public T[] oSort(T[] inArray);
        public abstract long iSortTimed(T[] inArray);

        public void setComparator(Comparator<T> comparator) {
            this.comparator = comparator;
        }

        public void bubbleSort(int[] iarray) {

            int n = iarray.length;
            int temp = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 1; j < (n - i); j++) {

                    if (iarray[j - 1] > iarray[j]) {
                        temp = iarray[j - 1];
                        iarray[j - 1] = iarray[j];
                        iarray[j] = temp;
                    }

                }
            }
        }

        public void quickSort(int[] arr, int low, int high) {
            if (arr == null || arr.length == 0)
                return;

            if (low >= high)
                return;

            // pick the pivot
            int middle = low + (high - low) / 2;
            int pivot = arr[middle];

            // make left < pivot and right > pivot
            int i = low, j = high;
            while (i <= j) {
                while (arr[i] < pivot) {
                    i++;
                }

                while (arr[j] > pivot) {
                    j--;
                }

                if (i <= j) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    i++;
                    j--;
                }
            }

            // recursively sort two sub parts
            if (low < j)
                quickSort(arr, low, j);

            if (high > i)
                quickSort(arr, i, high);
        }

        public class sortNumbers {
            BubbleSort<Integer> bsorti = new BubbleSort<Integer>();

            class BubbleSort<T> extends ArraySort<T> {
                Integer[] iarray = new Integer[5];
                iarray[0]=1
                iarray[1]=3
                iarray[2]=3
                iarray[3]=6
                iarray[4]=4

                public void iSort(T[] inArray) {
                    print(inArray);
                    bsorti.iSort(iarray);
                }

                @Override
                public long iSortTimed(T[] inArray) {
                    return 0;
                }

                private int numberSwaps = 0;

                void oSort(T[] inArray) {
                    final int last = inArray.length - 1;
                    for (int end = last; end > 0; end--) {
                        for (int i = 1; i <= end; i++) {
                            // No need for compareTo here; it does exactly the same thing.
                            if (inArray[i] == inArray[i - 1]) {
                                swap((Integer[]) inArray, i, i - 1);
                                numberSwaps++;
                            }
                        }
                    }
                    System.out.println("Needed " + numberSwaps + " swaps.");
                }

                private void swap(Integer[] array], int from, int to) {
                    int temp = array[from];
                    array[from] = array[to];
                    array[to] = temp;
                }
            }

            void print(T[] a) {
                for (T t : a) {
                    System.out.print(t);
                    System.out.print(" ");
                }
                System.out.print("\n");
            }
        }
    }

    public class MergeSort {
        public void main(String[] args) {
            Integer[] a = {1, 3, 3, 6, 4};
            mergeSort(a);
            System.out.println(Arrays.toString(a));
        }

        public void mergeSort(Comparable[] a) {
            Comparable[] tmp = new Comparable[a.length];
            mergeSort(a, tmp, 0, a.length - 1);
        }


        private void mergeSort(Comparable[] a, Comparable[] tmp, int left, int right) {
            if (left < right) {
                int center = (left + right) / 2;
                mergeSort(a, tmp, left, center);
                mergeSort(a, tmp, center + 1, right);
                merge(a, tmp, left, center + 1, right);
            }
        }

        private void merge(Comparable[] a, Comparable[] tmp, int left, int right, int rightEnd) {
            int leftEnd = right - 1;
            int k = left;
            int num = rightEnd - left + 1;

            while (left <= leftEnd && right <= rightEnd)
                if (a[left].compareTo(a[right]) <= 0)
                    tmp[k++] = a[left++];
                else
                    tmp[k++] = a[right++];

            while (left <= leftEnd)    // Copy rest of first half
                tmp[k++] = a[left++];

            while (right <= rightEnd)  // Copy rest of right half
                tmp[k++] = a[right++];

            // Copy tmp back
            for (int i = 0; i < num; i++, rightEnd--)
                a[rightEnd] = tmp[rightEnd];
        }
    }
}

