package site.ftka.ayed.parcial_ag.prac2.ej7;

/*

    Escribir en una clase ParcialArboles que contenga UNA ÚNICA variable de instancia
        de tipo BinaryTree de valores enteros NO repetidos
        y el método público con la siguiente firma:

            public boolean isLeftTree(int num)

    true: El subárbol cuya raíz es “num” tiene en su subárbol izquierdo
            una cantidad mayor estricta de árboles con un único hijo
            que en su subárbol derecho.
    false: En caso contrario.

    ● Si “num”    @Override
 no se encuentra en el árbol, devuelve false.

    ● Si el árbol con raíz “num” no cuenta con una de sus ramas,
        considere que en esa rama hay -1 árboles con único hijo.

 */

import site.ftka.ayed.parcial_ag.prac2.BinaryTree;

public class ParcialArboles {

    private BinaryTree<Integer> tree;

    public ParcialArboles(BinaryTree<Integer> tree) {
        this.tree = tree;
    }

    public boolean isLeftTree(int num) {
        Queue<BinaryTree<Integer>> cola = new Queue<BinaryTree<Integer>>();
        cola.enqueue(tree);
        cola.enqueue(null);

        BinaryTree<Integer> numTree = null;

        // permite encontrar numTree sin recorrer la totalidad del arbol
        while (!cola.isEmpty()) {
            BinaryTree<Integer> temp = cola.dequeue();

            if (temp != null) {
                // ejec
                if (temp.getData() == num) {
                    numTree = temp;
                    while (!cola.isEmpty())
                        cola.dequeue();
                } else {
                    if (temp.hasLeftChild())
                        cola.enqueue(temp.getLeftChild());

                    if (temp.hasRightChild())
                        cola.enqueue(temp.getRightChild());
                }
            } else if (!cola.isEmpty()) {
                cola.enqueue(null);
            }
        }

        if (numTree == null) {
            System.out.println(num + " not found");
            return false; // no existe arbol donde data == num
        }

        // numTree.data == num

        int left_count = numTree.hasLeftChild() ? calculateScore(numTree.getLeftChild()) : -1;
        int right_count = numTree.hasRightChild() ? calculateScore(numTree.getRightChild()) : -1;

        System.out.println("Left score: " + left_count);
        System.out.println("Right score: " + right_count);

        return left_count > right_count;
    }

    private int calculateScore(BinaryTree<Integer> numTree) {
        int res = 1;

        Queue<BinaryTree<Integer>> cola = new Queue<>();

        cola.enqueue(numTree);
        cola.enqueue(null);
        while (!cola.isEmpty()) {
            BinaryTree<Integer> temp = cola.dequeue();

            if (temp != null) {
                if (temp.isLeaf() || (temp.hasLeftChild() && temp.hasRightChild()))
                    res--;

                if (temp.hasLeftChild()) {
                    cola.enqueue(temp.getLeftChild());
                    res++;
                }

                if (temp.hasRightChild()) {
                    cola.enqueue(temp.getRightChild());
                    res++;
                }
            } else if (!cola.isEmpty()) {
                cola.enqueue(null);
            }
        }

        return res;
    }

}