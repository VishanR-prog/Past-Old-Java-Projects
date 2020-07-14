import java.util.*;
public class BTree {

    private BNode root;

    private int count;


    // Default Constructor

    public BTree() {

        this.root = null;

        this.count = 0;

    }



    // Returns the height of the node
    private int height(BNode node) {

        // Check if node is null

        if (node == null)

            return 0;

        else

            return node.height;

    }

    // Returns the Balance Factor of the node in the BTree

    private int getBalanceFactor(BNode node) {



        if (node == null)

            return 0;

        else

            return (height(node.left) - height(node.right));

    }



    private int max(int h1, int h2) {

        if (h1 > h2)

            return h1;

        else

            return h2;

    }




    private BNode rotateLeft(BNode node) {

        BNode rightChild = node.right;

        BNode rightChildsLeft = rightChild.left;

        // Rotate

        rightChild.left = node;

        node.right = rightChildsLeft;

        // Update height

        node.height = max(height(node.left), height(node.right)) + 1;

        rightChild.height = max(height(rightChild.left), height(rightChild.right)) + 1;

        return rightChild;

    }



    private BNode rotateRight(BNode node) {

        BNode leftChild = node.left;

        BNode leftChildsRight = leftChild.right;



        leftChild.right = node;

        node.left = leftChildsRight;



        node.height = max(height(node.left), height(node.right)) + 1;

        leftChild.height = max(height(leftChild.left), height(leftChild.right)) + 1;

        return leftChild;

    }


    private BNode indexWord(BNode node, int value, int index, boolean isAVL) {

        // Check if node is null

        if (node == null)

            return new BNode(value, index);

        // Compare word with the word at the node

        if (node.value > value)

            node.left = indexWord(node.left, value, index, isAVL);

        else if (node.value < value) {

            node.right = indexWord(node.right, value, index, isAVL);

        } else {

            node.addIndex(index);

            return node;

        }

        // Update the height of the node

        node.height = 1 + max(height(node.left), height(node.right));

        // Check whether to convert to AVL

        if (isAVL) {

            // Get the balancing factor for the node

            int balanceFactor = getBalanceFactor(node);

            // Check if node is unbalanced

            if (balanceFactor > 1) {

                if (value < node.left.value) // Left-left

                    node = rotateRight(node);

                else if (value > node.left.value) { // Left-right

                    node.left = rotateLeft(node.left);

                    node = rotateRight(node);

                }

            } else if (balanceFactor < -1) {

                if (value > node.right.value) // Right-right

                    node = rotateLeft(node);

                else if (value < node.right.value) { // Right-left

                    node.right = rotateRight(node.right);

                    node = rotateLeft(node);

                }

            }

        }

        return node;

    }


    public void insertAVL(int value, int index, boolean isAVL) {

        // Check if root is null

        if (this.root == null)

            this.root = new BNode(value, index);

        else

            this.root = indexWord(this.root, value, index, isAVL);

        // Increment count

        this.count += 1;

    }


    private List getIndices(BNode node, int value) {

        // Check if node is null

        if (node == null)

            return null;

        if (node.value == value)

            return node.indexList;

        else if (node.value > value)

            return getIndices(node.left, value);

        else

            return getIndices(node.right, value);

    }


    public int[] getIndices(int value) {

        // Check if tree is null

        if (this.root == null)

            return null;

        else {

            List<Integer> list = getIndices(this.root, value);

            // Check if list is not null

            if (list != null) {

                // Create array

                int[] indices = new int[list.size()];

                // Copy list elements to array

                for (int i = 0; i < indices.length; i++)

                    indices[i] = list.get(i);

                return indices;

            } else

                return null;

        }

    }


    public int at(int index) {

        // Get all values as int array

        int[] values = new int[this.count];

        getValues(this.root, values);

        return values[index];

    }



    private void getValues(BNode node, int[] values) {

        if (node != null) {

            // Traverse left

            getValues(node.left, values);

            // Get indices of value

            List<Integer> index = node.indexList;

            // Add value at all indices in the list

            for (Integer i : index) {

                values[i] = node.value;

            }

            // Traverse right

            getValues(node.right, values);

        }

    }


    public void show() {

        // Create array

        int[] values = new int[this.count];

        // Get values at per index

        getValues(this.root, values);

        // Display values

        for (int v : values)

            System.out.print(v + " ");

    }

}
