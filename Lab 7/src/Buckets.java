import java.util.*;
public class Buckets {
    private List<String> zeroBucket;
    private List<String> oneBucket;
    public Buckets() {
        zeroBucket = new ArrayList<>();
        oneBucket = new ArrayList<>();
    }
    public void addZero(String newValue) {
        zeroBucket.add(newValue);
    }
    public void addOne(String newValue) {
        oneBucket.add(newValue);
    }
    public void remZero(String newValue) {
        zeroBucket.remove(newValue);
    }
    public void remOne(String newValue) {
        oneBucket.remove(newValue);
    }
    public List<String> getAllInOrder() {
        List<String> result = new ArrayList<>();
        for (String val: oneBucket) {
            result.add(val);
        }
        for (String val: zeroBucket) {
            result.add(val);
        }
        return result;
    }

}
