package site.ftka.ayed.parcial_ag.prac2.ej4;

import site.ftka.ayed.parcial_ag.prac2.BinaryTree;

/*

    b) Cree una clase Java llamada RedBinariaLlena donde implementará lo solicitado en el método:
        retardoReenvio():int

 */

class RedBinariaLlena<Integer> extends BinaryTree<Integer> {

    public int retardoReenvio() {
        if (!this.isLeaf())
            return Math.max((int) getLeftChild().getData(), (int) getRightChild().getData());
        return (int) getData();
    }

}