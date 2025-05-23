package site.ftka.ayed.parcial_ag.prac2.ej8;

import site.ftka.ayed.parcial_ag.prac2.BinaryTree;

public class prac2ej8 {

    // test unit
    public static void main(String[] args) {
        // TEST 1. A1

        BinaryTree<Integer> A1_65 = new BinaryTree<>(65);

        BinaryTree<Integer> A1_37 = new BinaryTree<>(37);
        BinaryTree<Integer> A1_81 = new BinaryTree<>(81);

        BinaryTree<Integer> A1_47 = new BinaryTree<>(47);
        BinaryTree<Integer> A1_93 = new BinaryTree<>(93);

        A1_65.addLeftChild(A1_37);
        A1_65.addRightChild(A1_81);

        A1_37.addRightChild(A1_47);
        A1_81.addRightChild(A1_93);

        System.out.println(A1_65);

        // TEST 1. A2

        BinaryTree<Integer> A2_65 = new BinaryTree<>(65);

        BinaryTree<Integer> A2_37 = new BinaryTree<>(37);
        BinaryTree<Integer> A2_81 = new BinaryTree<>(81);

        BinaryTree<Integer> A2_22 = new BinaryTree<>(22);
        BinaryTree<Integer> A2_47 = new BinaryTree<>(47);
        BinaryTree<Integer> A2_76 = new BinaryTree<>(76);
        BinaryTree<Integer> A2_93 = new BinaryTree<>(93);

        BinaryTree<Integer> A2_11 = new BinaryTree<>(11);
        BinaryTree<Integer> A2_29 = new BinaryTree<>(29);
        BinaryTree<Integer> A2_85 = new BinaryTree<>(85);
        BinaryTree<Integer> A2_94 = new BinaryTree<>(94);

        A2_65.addLeftChild(A2_37);
        A2_65.addRightChild(A2_81);

        A2_37.addLeftChild(A2_22);
        A2_37.addRightChild(A2_47);
        A2_81.addLeftChild(A2_76);
        A2_81.addRightChild(A2_93);

        A2_22.addLeftChild(A2_11);
        A2_22.addRightChild(A2_29);
        A2_93.addLeftChild(A2_85);
        A2_93.addRightChild(A2_94);

        System.out.println(A2_65);

        ParcialArboles parcial = new ParcialArboles();
        System.out.println("Test 1 | Expected: true | Result: " + parcial.esPrefijo(A1_65, A2_65));

        // TEST 2. A1

        BinaryTree<Integer> A3_65 = new BinaryTree<>(65);
        BinaryTree<Integer> A3_37 = new BinaryTree<>(37);
        BinaryTree<Integer> A3_81 = new BinaryTree<>(81);
        BinaryTree<Integer> A3_47 = new BinaryTree<>(47);
        BinaryTree<Integer> A3_93 = new BinaryTree<>(93);

        A3_65.addLeftChild(A3_37);
        A3_65.addRightChild(A3_81);
        A3_37.addRightChild(A3_47);
        A3_81.addRightChild(A3_93);

        System.out.println(A3_65);

        // TEST 2. A2

        BinaryTree<Integer> A4_65 = new BinaryTree<>(65);
        BinaryTree<Integer> A4_37 = new BinaryTree<>(37);
        BinaryTree<Integer> A4_81 = new BinaryTree<>(81);
        BinaryTree<Integer> A4_22 = new BinaryTree<>(22);
        BinaryTree<Integer> A4_47 = new BinaryTree<>(47);
        BinaryTree<Integer> A4_76 = new BinaryTree<>(76);
        BinaryTree<Integer> A4_11 = new BinaryTree<>(11);
        BinaryTree<Integer> A4_29 = new BinaryTree<>(29);

        A4_65.addLeftChild(A4_37);
        A4_65.addRightChild(A4_81);
        A4_37.addLeftChild(A4_22);
        A4_37.addRightChild(A4_47);
        A4_81.addLeftChild(A4_76);
        A4_22.addLeftChild(A4_11);
        A4_22.addRightChild(A4_29);

        System.out.println(A4_65);
        System.out.println("Test 2 | Expected: false | Result: " + parcial.esPrefijo(A3_65, A4_65));
    }

}