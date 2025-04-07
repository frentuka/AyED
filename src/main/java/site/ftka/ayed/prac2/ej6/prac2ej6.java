package site.ftka.ayed.prac2.ej6;

/*
    Cree una clase Java llamada Transformacion que tenga como variable de instancia
        un árbol binario de números enteros y un método de instancia suma(): BinaryTree<Integer>
        el cual devuelve el árbol en el que se reemplazó el valor de cada nodo
        por la suma de todos los elementos presentes en su subárbol izquierdo y derecho.
        Asuma que los valores de los subárboles vacíos son ceros.
 */

import site.ftka.ayed.prac2.BinaryTree;

public class prac2ej6 {

    public static void main(String[] args) {
        BinaryTree<Integer> V1 = new BinaryTree<>(1);

        BinaryTree<Integer> V2 = new BinaryTree<>(2);
        BinaryTree<Integer> V3 = new BinaryTree<>(3);

        BinaryTree<Integer> V4 = new BinaryTree<>(4);
        BinaryTree<Integer> V5 = new BinaryTree<>(5);
        BinaryTree<Integer> V6 = new BinaryTree<>(6);

        BinaryTree<Integer> V7 = new BinaryTree<>(7);
        BinaryTree<Integer> V8 = new BinaryTree<>(8);

        V1.addLeftChild(V2);
        V1.addRightChild(V3);

        V2.addRightChild(V4);

        V3.addLeftChild(V5);
        V3.addRightChild(V6);

        V5.addLeftChild(V7);
        V5.addRightChild(V8);

        System.out.println(V1);
        new Transformacion(V1).suma();
        System.out.println();
        System.out.println(V1);

        // Mi solución recorre los subárboles una única vez. Cero bulto.
    }

}
