package site.ftka.ayed.modulo_ag.prac2.ej8;

import site.ftka.ayed.modulo_ag.prac2.BinaryTree;

import java.util.Objects;

public class ParcialArboles {

    // A1 Intersec. A2 = A1
    // A1 U A2 = A2
    public boolean esPrefijo(BinaryTree<Integer> a1, BinaryTree<Integer> a2) {
        // Iterar por cada elemento de A1 en espejismo con A2.
        // Si algún elemento no coincide, retornar FALSE recursivamente.

        if (!Objects.equals(a1.getData(), a2.getData())) // null-safe
            return false;

        boolean result = true;

        System.out.println(a1.getData() + " == " + a2.getData());

        if (a1.hasLeftChild()) {
            if (!a2.hasLeftChild())
                return false;

            result = esPrefijo(a1.getLeftChild(), a2.getLeftChild());
        }

        if (a1.hasRightChild()) {
            if (!a2.hasRightChild())
                return false;

            result = esPrefijo(a1.getRightChild(), a2.getRightChild());
        }

        // en esta instancia se confirma el prefijo
        return result;
    }

}