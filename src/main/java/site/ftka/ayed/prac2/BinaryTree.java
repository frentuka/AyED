package site.ftka.ayed.prac2;

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
                leftChild.betweenLevels(n-1, m-1);
            if (hasRightChild())
                rightChild.betweenLevels(n-1, m-1);
        } else if (m >= 0) {
            System.out.println(this);

            if (hasLeftChild())
                leftChild.betweenLevels(0, m-1);
            if (hasRightChild())
                rightChild.betweenLevels(0, m-1);
        }
    }

    @Override
    public String toString() {
        return "BinaryTree data: " + data;
    }
}
