package site.ftka.ayed.parcial_ag.prac2.ej6;

import site.ftka.ayed.parcial_ag.prac2.BinaryTree;

class Transformacion {

    BinaryTree<Integer> tree;

    public Transformacion(BinaryTree<Integer> tree) {
        this.tree = tree;
    }

    public BinaryTree<Integer> suma() {
        int res = 0;

        if (tree.hasLeftChild()) {
            res+= tree.getLeftChild().getData();
            tree.addLeftChild(new Transformacion(tree.getLeftChild()).suma());
            res+= tree.getLeftChild().getData();
        }

        if (tree.hasRightChild()) {
            res+= tree.getRightChild().getData();
            tree.addRightChild(new Transformacion(tree.getRightChild()).suma());
            res+= tree.getRightChild().getData();
        }

        if (tree.isLeaf())
            tree.setData(0);
        else
            tree.setData(res);

        return tree;
    }






}