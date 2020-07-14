import java.util.*;
public class BNode {
    protected int value;
    protected List<Integer> indexList = new ArrayList<Integer>();
    protected int height;
    protected BNode left;
    protected BNode right;

    public BNode(int value, int index) {
        this.value = value;
        addIndex(index);
        this.height = 1;
        this.left = null;
        this.right = null;
    }
    public void addIndex(int index) {
        if(!this.indexList.contains(index))
            this.indexList.add(index);
    }

    @Override
    public String toString() {
        return this.indexList.toString();
    }
}
