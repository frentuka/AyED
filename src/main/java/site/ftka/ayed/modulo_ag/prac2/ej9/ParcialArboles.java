package site.ftka.ayed.modulo_ag.prac2.ej9;

import site.ftka.ayed.modulo_ag.prac2.BinaryTree;

public class ParcialArboles {

    public static class SaDData {
        int sum, diff;
        public SaDData(int sum, int diff) {
            this.sum = sum; this.diff = diff;
        }

        @Override
        public String toString() {
            return "S" + sum + " D" + diff;
        }
    }

    public BinaryTree<SaDData> sumAndDiff(BinaryTree<Integer> arbol) {
        return sumAndDiff(arbol, 0, 0);
    }

    public BinaryTree<SaDData> sumAndDiff(BinaryTree<Integer> arbol, int sum, int parentData) {
        sum = arbol.getData() + sum;
        parentData = arbol.getData() - parentData;
        BinaryTree<SaDData> parent = new BinaryTree<>(new SaDData(sum, parentData));

        if (arbol.hasLeftChild())
            parent.addLeftChild(sumAndDiff(arbol.getLeftChild(), sum, arbol.getData()));

        if (arbol.hasRightChild())
            parent.addRightChild(sumAndDiff(arbol.getRightChild(), sum, arbol.getData()));

        return parent;
    }

}
