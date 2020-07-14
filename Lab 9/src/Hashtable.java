import java.util.*;

public abstract class Hashtable<T> {
    private int maxSize;
    protected int capacity = 0;
    private List<String> keys = null;
    private List<T> values = null;

    private int probeCount = 0;

    public int getProbeCount() {
        return this.probeCount;
    }

    public void resetProbeCount() {
        this.probeCount = 0;
    }

    public Hashtable() {
        this.keys = new ArrayList<String>();
        for (int i = 0; i < capacity; i++) {
            this.keys.add(null);
        }
        this.values = new ArrayList<T>();
        for (int i = 0; i < capacity; i++) {
            this.values.add(null);
        }
        this.capacity = capacity;
    }

    public int hash(String key) {
        int sum = 0;
        for (int i = 0; i < key.length(); i++) {
            sum += (int) key.charAt(i);
        }
        return sum % capacity;
    }

    public abstract int rehash(int previousHash);

    public void insert(String key, T value) {
        // determine the hash

        int hash = hash(key);

        int oldHash = hash;

        // if the hash is taken, continuously until a free space

        // is found

        while (keys.get(hash) != null) {

            hash++;

            if (hash == capacity)

                hash = 0;

            if (hash == oldHash) //This will ensure that if the hashtable is full, it stops searching and notifies the user

                throw new RuntimeException("Hashtable is full");

        }

        // insert the value at that position

        values.add(hash, value);


    }
}