package site.ftka.ayed.parcial_ag.prac2;

public class BinaryTree<T> {
    private T data;
    private BinaryTree<T> leftChild, rightChild;

    public BinaryTree() {}
    public BinaryTree(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BinaryTree<T> getLeftChild() {
        return leftChild;
    }

    public BinaryTree<T> getRightChild() {
        return rightChild;
    }

    public void addLeftChild(BinaryTree<T> child) {
        this.leftChild = child;
    }

    public void addRightChild(BinaryTree<T> child) {
        this.rightChild = child;
    }

    public void removeLeftChild() {
        this.leftChild = null;
    }

    public void removeRightChild() {
        this.rightChild = null;
    }

    public boolean isEmpty() {
        return this.data == null;
    }

    public boolean isLeaf() {
        return (leftChild == null) && (rightChild == null);
    }

    public boolean hasLeftChild() {
        return leftChild != null;
    }

    public boolean hasRightChild() {
        return rightChild != null;
    }

    public int countLeaves() {
        int leaves = 0;

        if (isLeaf())
            return 1;
        if (hasLeftChild())
            leaves+= leftChild.countLeaves();
        if (hasRightChild())
            leaves+= rightChild.countLeaves();

        return leaves;
    }

    public BinaryTree<T> mirror() {
        BinaryTree<T> mirrored_tree = new BinaryTree<>(data);

        if (hasLeftChild())
            mirrored_tree.rightChild = this.leftChild.mirror();
        if (hasRightChild())
            mirrored_tree.leftChild = this.rightChild.mirror();

        return mirrored_tree;
    }

    public void betweenLevels(int n, int m) {
        if (n > m) return; // top can´t be lower than bottom

        if (n > 0) {
            if (hasLeftChild())
                this.leftChild.betweenLevels(n-1, m-1);
            if (hasRightChild())
                this.rightChild.betweenLevels(n-1, m-1);
        } else if (m >= 0) {
            System.out.println(this);

            if (hasLeftChild())
                this.leftChild.betweenLevels(0, m-1);
            if (hasRightChild())
                this.rightChild.betweenLevels(0, m-1);
        }
    }

    @Override
    public String toString() {
        return toString("", SON_STATUS.NONE);
    }

    private enum SON_STATUS {
        NONE, UP, DOWN;
    }

    public String toString(String spacing, SON_STATUS sonstat) {
        if (this.isLeaf())
            return spacing + data;

        int dataLength = getData().toString().length();
        String dataLengthSpacing = " ".repeat(dataLength-1);

        String upperSpacing = spacing + (sonstat == SON_STATUS.DOWN ? "║   " : "    ") + dataLengthSpacing;
        String downSpacing = spacing + (sonstat == SON_STATUS.UP ? "║   " : "    ") + dataLengthSpacing;

        if (this.hasLeftChild() && this.hasRightChild())
            return this.getRightChild().toString(upperSpacing, SON_STATUS.UP) + "\n" +
                    spacing + data + " ══╣\n" +
                    this.getLeftChild().toString(downSpacing, SON_STATUS.DOWN);
        if (!this.hasLeftChild() && this.hasRightChild())
            return this.getRightChild().toString(upperSpacing, SON_STATUS.UP) + "\n" +
                    spacing + data + " ══╝";
        if (this.hasLeftChild() && !this.hasRightChild())
            return spacing + data + " ══╗\n" +
                    this.getLeftChild().toString(downSpacing, SON_STATUS.DOWN);

        return "" + data;
    }
}