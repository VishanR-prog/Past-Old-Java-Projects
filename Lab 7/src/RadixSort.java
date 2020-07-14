import java.util.*;
public class RadixSort {

    public static void RadixSort(String[] list) {
        List<String> numbers = new ArrayList<>();
        for(String number: list) {
            numbers.add(number);
        }
        int digits = 4;
        System.out.println(numbers);
        Buckets buckets;

        for(int place = digits - 1; place >= 0; place --) {
            buckets = new Buckets();
            for(String item: numbers) {
                char digit = item.charAt(place);
                if(digit == '0') {
                    buckets.addZero(item);
                } else {
                    buckets.addOne(item);
                }
            }
            numbers = buckets.getAllInOrder();
            System.out.println(numbers);
        }
    }
    public static void main(String[] args) {
        String[] list = {"0011", "1001", "1000", "0111", "0101"};
        RadixSort(list);
    }
}
