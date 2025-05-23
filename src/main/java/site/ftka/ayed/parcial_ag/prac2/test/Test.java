package site.ftka.ayed.parcial_ag.prac2.test;

import site.ftka.ayed.parcial_ag.prac2.BinaryTree;

public class Test {

    public static void main(String[] args) {
        BinaryTree<String> A = new BinaryTree<>("A");
        BinaryTree<String> B = new BinaryTree<>("B");
        BinaryTree<String> C = new BinaryTree<>("C");

        A.addLeftChild(B);
        A.addRightChild(C);

        BinaryTree<String> D = new BinaryTree<>("D");

        B.addLeftChild(D);

        BinaryTree<String> E = new BinaryTree<>("E");
        BinaryTree<String> F = new BinaryTree<>("F");

        C.addLeftChild(E);
        C.addRightChild(F);

        BinaryTree<String> G = new BinaryTree<>("G");

        F.addRightChild(G);






        A.betweenLevels(0, 3);

        System.out.println("========================");

        A = A.mirror();
        A.betweenLevels(0, 3);
    }

}
