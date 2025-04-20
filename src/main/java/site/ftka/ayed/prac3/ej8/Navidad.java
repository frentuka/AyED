package site.ftka.ayed.prac3.ej8;

/*
    Retomando el ejercicio abeto navideño visto en teoría, cree una clase Navidad que cuenta con una
    variable de instancia GeneralTree que representa al abeto (ya creado) e implemente el método con la
    firma: public String esAbetoNavidenio()
 */

import site.ftka.ayed.prac3.GeneralTree;

public class Navidad<T> {

    GeneralTree<T> tree;

    public Navidad(GeneralTree<T> tree) {
        this.tree = tree;
    }

    public String esAbetoNavidenio() {
        return bool_esAbetoNavidenio() ? "Sí" : "No";
    }

    public boolean bool_esAbetoNavidenio() {
        // check si tiene al menos 3 hijos hojas
        int leaf_amount = 0;
        for (GeneralTree<T> child : tree.getChildren()) {
            if (child.isLeaf())
                leaf_amount++;
            else {
                Navidad<T> nav = new Navidad<>(child);
                if (!nav.bool_esAbetoNavidenio())
                    return false;
            }
            if (leaf_amount >= 3) // innecesario pero bonito
                break;
        }

        return leaf_amount >= 3;
    }

}
