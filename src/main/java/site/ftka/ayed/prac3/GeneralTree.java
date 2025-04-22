package site.ftka.ayed.prac3;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class GeneralTree<T> {

    private T data;
    private List<GeneralTree<T>> children = new ArrayList<>();

    public GeneralTree(T data) {
        this.data = data;
    }

    public GeneralTree(T data, List<GeneralTree<T>> children) {
        this.data = data;
        this.children = children;
    }

    public GeneralTree() {

    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<GeneralTree<T>> getChildren() {
        return children;
    }

    public void setChildren(List<GeneralTree<T>> children) {
        this.children = children;
    }

    public void addChild(GeneralTree<T> child) {
        children.add(child);
    }

    public boolean isLeaf() {
        return children == null || children.isEmpty();
    }

    public boolean hasChildren() {
        return children != null && !children.isEmpty();
    }

    public boolean isEmpty() {
        return this.data == null && !this.hasChildren();
    }

    public void removeChild(GeneralTree<T> child) {
        if (hasChildren())
            children.remove(child);
    }

    public void printPreOrder() {
        // to-do
    }

    public List<T> preOrder() {
        // to-do
        return null;
    }

    public void preOrder(List<T> list) {
        // to-do
    }

    public void postOrder() {
        // to-do
    }

    public void traversalLevelTree(GeneralTree<T> tree) {
        // to-do
    }

    public int height() {
        return 0;
    }

    public int width() {
        return 0;
    }

    public int level(T dato) {
        return 0;
    }

}