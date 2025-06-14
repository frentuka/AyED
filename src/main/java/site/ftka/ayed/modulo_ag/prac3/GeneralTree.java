package site.ftka.ayed.modulo_ag.prac3;

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

    /// The vertical stretch of the tree, from root to last sub-child
    ///
    /// # Returns
    /// `int` Height of the tree
    public int height() {
        int tallestChildrenHeight = 0;

        for (GeneralTree<T> child : getChildren()) {
            int childHeight = child.height();
            if (childHeight > tallestChildrenHeight)
                tallestChildrenHeight = childHeight;
        }

        return 1 + tallestChildrenHeight;
    }

    /// The horizontal span of the widest part of the tree
    ///
    /// # Returns
    /// `int` Width of the tree
    public int width() {

        int
            treesOnNextLevel = 0,
            treesOnThisLevel = 1,
            treesRemainingOnThisLevel = 1,
            maxWidth = 0;

        Queue<GeneralTree<T>> treeQueue = new Queue<>();
        treeQueue.enqueue(this);

        while (!treeQueue.isEmpty()) {
            GeneralTree<T> actualTree = treeQueue.dequeue();

            treesRemainingOnThisLevel--;
            treesOnNextLevel+= actualTree.getChildren().size();

            if (treesRemainingOnThisLevel == 0) {
                if (treesOnThisLevel > maxWidth)
                    maxWidth = treesOnThisLevel;
                treesOnThisLevel = treesOnNextLevel;
                treesRemainingOnThisLevel = treesOnThisLevel;
                treesOnNextLevel = 0;
            }

            for (GeneralTree<T> child : actualTree.getChildren())
                treeQueue.enqueue(child);
        }

        return maxWidth;
    }


    public int level(T data) {
        Queue<GeneralTree<T>> queue = new Queue<>();
        queue.enqueue(this);

        int
            actualLevel = 0,
            treesOnNextLevel = 0,
            treesOnThisLevel = 1,
            treesRemainingOnThisLevel = 1;

        while (!queue.isEmpty()) {
            GeneralTree<T> actualTree = queue.dequeue();

            if (actualTree.getData() == data)
                return actualLevel;

            treesRemainingOnThisLevel--;
            treesOnNextLevel+= actualTree.getChildren().size();

            // new level or end of tree
            if (treesRemainingOnThisLevel == 0) {
                actualLevel++;
                treesOnThisLevel = treesOnNextLevel;
                treesRemainingOnThisLevel = treesOnThisLevel;
                treesOnNextLevel = 0;
            }

            for (GeneralTree<T> child : actualTree.getChildren())
                queue.enqueue(child);
        }

        return -1; // not found
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
        return toString("", SubtreePosition.First);
    }

    public enum SubtreePosition {
        First, Middle, Top, Bottom
    }

    public String toString(String prefix, SubtreePosition treePos /* true: uppermost | false: downmost | null: mid */) {
        if (isLeaf())
            return toString();

        String data = getData() == null ? "Null" : getData().toString();
        prefix+= " ".repeat(data.length() + 2);

        // base case: only 1 children
        if (getChildren().size() == 1)
            return data + " ══ " + getChildren().getFirst().toString(prefix, SubtreePosition.Middle);

        // exception case: multiple children (funny part)
        StringBuilder toReturn = new StringBuilder();
        toReturn.append(data).append(" ═");

        if (treePos == SubtreePosition.Bottom)
            prefix = prefix.replace("║", " ");

        for (int i = 0; i < getChildren().size(); i++) {
            // is it the first?
            if (i == 0)
                toReturn.append("╦ ")
                        .append(getChildren().get(i).toString(prefix + "║ ", treePos == SubtreePosition.Top || treePos == SubtreePosition.First ? SubtreePosition.Top : SubtreePosition.Middle))
                        .append("\n");
            else
            if (i == getChildren().size() - 1) // which is not 0
                toReturn.append(prefix)
                        .append("╚ ")
                        .append(getChildren().get(i).toString(prefix + "║ ", treePos == SubtreePosition.Bottom  || treePos == SubtreePosition.First ? SubtreePosition.Bottom : SubtreePosition.Middle));
            else
                toReturn.append(prefix)
                        .append("╠ ")
                        .append(getChildren().get(i).toString(prefix + "║ ", SubtreePosition.Middle))
                        .append("\n");
        }

        return toReturn.toString();
    }

}