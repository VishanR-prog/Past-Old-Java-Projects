public class AVLNode {
    public AVLNode left = null;
    public AVLNode right = null;
    public int value = 0;
    public AVLNode parent = null;

    public AVLNode insert(int newValue) {
        // perform binary-search style insertion
        if (newValue < this.value) {
            // insert the value to the left sub-tree
            if (this.left == null) {
                AVLNode newNode = new AVLNode();
                newNode.value = newValue;
                newNode.parent = this;
                this.left = newNode;
            } else {
                this.left.insert(newValue);
            }
        } else {
            // insert the value into the right sub-tree
            if (this.right == null) {
                AVLNode newNode = new AVLNode();
                newNode.value = newValue;
                newNode.parent = this;
                this.right = newNode;
            } else {
                this.right.insert(newValue);
            }
        }

        return rebalance();
    }

    // Right Rotate
    public AVLNode rotateRight(AVLNode a) {
        AVLNode b = a.left;
        b.parent = a.parent;

        a.left = b.right;

        if (a.left != null)
            a.left.parent = a;

        b.right = a;
        a.parent = b;

        if (b.parent != null) {
            if (b.parent.right == a) {
                b.parent.right = b;
            } else {
                b.parent.left = b;
            }
        }

        return b;
    }

    // Left Rotate
    public AVLNode rotateLeft(AVLNode a) {
        AVLNode b = a.right;
        a.parent = b.parent;

        a.right = b.left;
        if (a.right != null)
            a.right.parent = a;

        b.left = a;
        a.parent = b;

        if (b.parent != null) {
            if (b.parent.right == a) {
                b.parent.right = b;
            } else {
                b.parent.left = b;
            }
        }
        return b;
    }

    public AVLNode rebalance() {
        // balance the tree (if necessary)
        if (getBalance() == 2) {
            rotateRight();
        }
        if (getBalance() == -2) {
            rotateLeft();
        }

        return null;
    }

    private void rotateLeft() {
    }

    private void rotateRight() {
    }
    

    public int getBalance() {
        int rightHeight = 0;
        if (this.right != null) {
            rightHeight = this.right.getHeight();
        }

        int leftHeight = 0;
        if (this.left != null) {
            leftHeight = this.left.getHeight();
        }

        return rightHeight - leftHeight;
    }

    public void print(int depth) {
        if (this.right != null) {
            this.right.print(depth + 1);
        }

        for (int i = 0; i < depth; i++) {
            System.out.print("\t");
        }
        System.out.println(this.value);

        if (this.left != null) {
            this.left.print(depth + 1);
        }
    }

    public int getHeight() {
        int leftHeight = 1;
        if (left != null) {
            leftHeight = left.getHeight() + 1;
        }

        int rightHeight = 0;
        if (right != null) {
            rightHeight = right.getHeight() + 1;
        }

        return (leftHeight > rightHeight) ? leftHeight : rightHeight;
    }
}

