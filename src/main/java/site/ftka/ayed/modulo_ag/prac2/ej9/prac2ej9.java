package site.ftka.ayed.modulo_ag.prac2.ej9;

import site.ftka.ayed.modulo_ag.prac2.BinaryTree;

public class prac2ej9 {

    public static void main(String[] args) {
        ParcialArboles parcial = new ParcialArboles();

        BinaryTree<Integer> A5_20 = new BinaryTree<>(20);
        BinaryTree<Integer> A5_5 = new BinaryTree<>(5);
        BinaryTree<Integer> A5_30 = new BinaryTree<>(30);
        BinaryTree<Integer> A5_neg5 = new BinaryTree<>(-5);
        BinaryTree<Integer> A5_10 = new BinaryTree<>(10);
        BinaryTree<Integer> A5_50 = new BinaryTree<>(50);
        BinaryTree<Integer> A5_neg9 = new BinaryTree<>(-9);
        BinaryTree<Integer> A5_1 = new BinaryTree<>(1);
        BinaryTree<Integer> A5_4 = new BinaryTree<>(4);
        BinaryTree<Integer> A5_6 = new BinaryTree<>(6);

// Level 1
        A5_20.addLeftChild(A5_5);
        A5_20.addRightChild(A5_30);

// Level 2
        A5_5.addLeftChild(A5_neg5);
        A5_5.addRightChild(A5_10);
        A5_30.addLeftChild(A5_50);
        A5_30.addRightChild(A5_neg9);

// Level 3
        A5_10.addLeftChild(A5_1);
        A5_50.addRightChild(A5_4);

// Level 4
        A5_4.addRightChild(A5_6);

        System.out.println(A5_20);

        System.out.println("\n");
        System.out.println(parcial.sumAndDiff(A5_20));
    }

}