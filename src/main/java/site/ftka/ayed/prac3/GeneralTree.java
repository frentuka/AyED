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

/*
    Some symbols I'm going to need for symmetric design:

    ╔ -> First children
    ╠ -> Intermediate children
    ╬ -> Middle children for unpair trees
    ╚ -> Last children

-> Symmetric design:
    How it should look with a pair amount of children:
    ╔ A
    ╠ B
X ══╣
    ╠ C
    ╚ D

    How it should look with an unpair amount of children:
    ╔ A
    ╠ B
X ══╬ C
    ╠ D
    ╚ E


    Symbols for non-symmetric design:
    ╦ -> First children (if there's more than 1)
    ═ -> First children (if there's only 1)
    ╠ -> Middle children
    ╚ -> Last children

-> Non-symmetric design:
X ══╦ A
    ╠ B
    ╠ C
    ╚ D
*/


    @Override
    public String toString() {
        // base: no children
        if (isLeaf())
            return isEmpty() ? "Null" : data.toString();
        return toString("");
    }

    public String toString(String prefix) {
        if (isLeaf())
            return toString();

        String data = getData() == null ? "Null" : getData().toString();
        prefix+= " ".repeat(data.length() + 2);

        // base case: only 1 children
        if (getChildren().size() == 1)
            return data + " ══ " + getChildren().getFirst().toString(prefix);

        // exception case: multiple children (funny part)
        StringBuilder toReturn = new StringBuilder();
        toReturn.append(data).append(" ═");

        for (int i = 0; i < getChildren().size(); i++) {
            // is it the first?
            if (i == 0)
                toReturn.append("╦ ")
                        .append(getChildren().get(i).toString(prefix + "║ "))
                        .append("\n");
            else
            if (i == getChildren().size() - 1) // which is not 0
                toReturn.append(prefix)
                        .append("╚ ")
                        .append(getChildren().get(i).toString(prefix + "║ "));
            else
                toReturn.append(prefix)
                        .append("╠ ")
                        .append(getChildren().get(i).toString(prefix + "║ "))
                        .append("\n");
        }

        return toReturn.toString();
    }
}