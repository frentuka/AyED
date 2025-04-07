package site.ftka.ayed.prac2.ej3;

/*
    Defina una clase Java denominada ContadorArbol cuya función principal es proveer métodos de
    validación sobre árboles binarios de enteros. Para ello la clase tiene como variable de instancia un
    BinaryTree<Integer>. Implemente en dicha clase un método denominado numerosPares() que
    devuelve en una estructura adecuada (sin ningún criterio de orden) todos los elementos pares del
    árbol (divisibles por 2).
 */

import site.ftka.ayed.prac2.BinaryTree;

public class prac2ej3 {

    public static void main(String[] args) {
        BinaryTree<Integer> treeD = new BinaryTree<>(4);
        BinaryTree<Integer> treeE = new BinaryTree<>(6);
        BinaryTree<Integer> treeF = new BinaryTree<>(8);
        BinaryTree<Integer> treeG = new BinaryTree<>(10);

        BinaryTree<Integer> treeB = new BinaryTree<>(2);
        BinaryTree<Integer> treeC = new BinaryTree<>(12);

        treeB.addLeftChild(treeD);
        treeB.addRightChild(treeE);
        treeC.addLeftChild(treeF);
        treeC.addRightChild(treeG);

        BinaryTree<Integer> treeA = new BinaryTree<>(100);

        treeA.addLeftChild(treeB);
        treeA.addRightChild(treeC);

        System.out.println(treeA);

        ContadorArbol contador = new ContadorArbol(treeA);
        System.out.println("inOrden: " + contador.numerosPares_inOrden());
        System.out.println("postOrden: " + contador.numerosPares_postOrden());
    }

}
