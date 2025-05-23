package site.ftka.ayed.parcial_ag.prac2.ej3;

/*
        Defina una clase Java denominada ContadorArbol cuya función principal es proveer métodos de
    validación sobre árboles binarios de enteros. Para ello la clase tiene como variable de instancia un
    BinaryTree<Integer>. Implemente en dicha clase un método denominado numerosPares() que
    devuelve en una estructura adecuada (sin ningún criterio de orden) todos los elementos pares del
    árbol (divisibles por 2).
 */

import site.ftka.ayed.parcial_ag.prac2.BinaryTree;

import java.util.ArrayList;

class ContadorArbol {

    private BinaryTree<Integer> tree;

    public ContadorArbol(BinaryTree<Integer> tree) {
        this.tree = tree;
    }

    // Implemente en dicha clase un método denominado numerosPares()
    // que devuelve en una estructura adecuada (sin ningún criterio de orden)
    // todos los elementos pares del árbol (divisibles por 2).

    // a) Implemente el método realizando un recorrido InOrden.
    public ArrayList<Integer> numerosPares_inOrden() {
        ArrayList<Integer> res = new ArrayList<>();

        if (this.tree.hasLeftChild()) {
            ContadorArbol izq = new ContadorArbol(this.tree.getLeftChild());
            res.addAll(izq.numerosPares_inOrden());
        }

        if (this.tree.getData() % 2 == 0)
            res.add(this.tree.getData());

        if (this.tree.hasRightChild()) {
            ContadorArbol der = new ContadorArbol(this.tree.getRightChild());
            res.addAll(der.numerosPares_inOrden());
        }

        return res;
    }

    // b) Implemente el método realizando un recorrido PostOrden.
    public ArrayList<Integer> numerosPares_postOrden() {
        ArrayList<Integer> res = new ArrayList<>();

        if (this.tree.hasLeftChild()) {
            ContadorArbol izq = new ContadorArbol(this.tree.getLeftChild());
            res.addAll(izq.numerosPares_postOrden());
        }

        if (this.tree.hasRightChild()) {
            ContadorArbol der = new ContadorArbol(this.tree.getRightChild());
            res.addAll(der.numerosPares_postOrden());
        }

        if (this.tree.getData() % 2 == 0)
            res.add(this.tree.getData());

        return res;
    }

}
