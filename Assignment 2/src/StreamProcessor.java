
public class StreamProcessor {
    private int index;
    private BTree storage;
    private boolean isAVL;

    // YOU MIGHT HAVE TO MODIF THIS CLASS BY ADDING NEW METHODS AND MEMBERS

    public StreamProcessor(boolean isAVL) {
        this.index = 0;
        this.storage = new BTree();
        this.isAVL = isAVL;
    }

    public void consume(int value)
    {
        storage.insertAVL(value, index, isAVL);
        index++;
    }


    public int[] search(int value) {

        // YOU NEED TO IMPLEMENT THIS METHOD

        return storage.getIndices(value);
    }

    public int at(int i) {

        // YOU NEED TO IMPLEMENT THIS METHOD

        return storage.at(i);
    }

    public void show() {
        System.out.print("Stream: ");
        storage.show();
    }
}
