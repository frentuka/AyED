package site.ftka.ayed.modulo_ag.prac2.ej5;

/*
    Implemente una clase Java llamada ProfundidadDeArbolBinario
        que tiene como variable de instancia un árbol binario de números enteros
        y un método de instancia sumaElementosProfundidad (int p):int
        el cuál devuelve la suma de todos los nodos del árbol que se encuentren
        a la profundidad pasada como argumento.
 */

import site.ftka.ayed.modulo_ag.prac2.BinaryTree;

class ProfundidadDeArbolBinario {

    private final BinaryTree<Integer> tree;

    public ProfundidadDeArbolBinario(BinaryTree<Integer> tree) {
        this.tree = tree;
    }

    public int sumaElementosProfundidad(int p) {
        int res = 0;

        if (p > 0) {
            if (tree.hasLeftChild())
                res+= new ProfundidadDeArbolBinario(tree.getLeftChild()).sumaElementosProfundidad(p-1);

            if (tree.hasRightChild())
                res+= new ProfundidadDeArbolBinario(tree.getRightChild()).sumaElementosProfundidad(p-1);
        } else {
            res+= tree.getData();
        }

        return res;
    }



}