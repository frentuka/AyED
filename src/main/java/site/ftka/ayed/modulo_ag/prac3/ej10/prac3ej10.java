package site.ftka.ayed.modulo_ag.prac3.ej10;

import site.ftka.ayed.modulo_ag.prac3.GeneralTree;

import java.util.ArrayList;
import java.util.List;

public class prac3ej10 {


	public static void main(String[] args) {
		GeneralTree<Integer> tree = new GeneralTree<>(1);

		GeneralTree<Integer> tree_1 = new GeneralTree<>(0);
		GeneralTree<Integer> tree_2 = new GeneralTree<>(1);
		GeneralTree<Integer> tree_3 = new GeneralTree<>(1);

		tree.addChild(tree_1);
		tree.addChild(tree_2);
		tree.addChild(tree_3);

		GeneralTree<Integer> tree_1_1 = new GeneralTree<>(1);
		GeneralTree<Integer> tree_1_2 = new GeneralTree<>(1);

		tree_1.addChild(tree_1_1);
		tree_1.addChild(tree_1_2);

		GeneralTree<Integer> tree_1_1_1 = new GeneralTree<>(1);
		GeneralTree<Integer> tree_1_1_2 = new GeneralTree<>(1);
		GeneralTree<Integer> tree_1_1_3 = new GeneralTree<>(1);

		tree_1_1.addChild(tree_1_1_1);
		tree_1_1.addChild(tree_1_1_2);
		tree_1_1.addChild(tree_1_1_3);

		//

		GeneralTree<Integer> tree_2_1 = new GeneralTree<>(1);
		GeneralTree<Integer> tree_2_2 = new GeneralTree<>(0);

		tree_2.addChild(tree_2_1);
		tree_2.addChild(tree_2_2);

		GeneralTree<Integer> tree_2_2_1 = new GeneralTree<>(0);

		tree_2_2.addChild(tree_2_2_1);

		GeneralTree<Integer> tree_2_2_1_1 = new GeneralTree<>(1);

		tree_2_2_1.addChild(tree_2_2_1_1);

		//

		GeneralTree<Integer> tree_3_1 = new GeneralTree<>(0);

		tree_3.addChild(tree_3_1);

		GeneralTree<Integer> tree_3_1_1 = new GeneralTree<>(0);

		tree_3_1.addChild(tree_3_1_1);

		GeneralTree<Integer> tree_3_1_1_1 = new GeneralTree<>(0);
		GeneralTree<Integer> tree_3_1_1_2 = new GeneralTree<>(0);

		tree_3_1_1.addChild(tree_3_1_1_1);
		tree_3_1_1.addChild(tree_3_1_1_2);

		System.out.println(tree);
		System.out.println(resolver(tree));
	}

	public static List<Integer> resolver(GeneralTree<Integer> arbol) {
		List<Integer> maxPath = new ArrayList<>();
		List<Integer> currentPath = new ArrayList<>();
		int[] maxValue = new int[]{Integer.MIN_VALUE};

		resolver(arbol, 0, 0, currentPath, maxPath, maxValue);
		return maxPath;
	}

	private static void resolver(GeneralTree<Integer> tree, int level,
	                             int currentSum, List<Integer> currentPath,
	                             List<Integer> maxPath, int[] maxValue) {

		int data = tree.getData();
		if (data != 0) {
			currentPath.add(data);
			currentSum += data * level;
		}

		if (tree.isLeaf()) {
			if (currentSum > maxValue[0]) {
				maxValue[0] = currentSum;
				maxPath.clear();
				maxPath.addAll(currentPath);
			}

			if (data != 0) currentPath.removeLast();
			return;
		}

		for (GeneralTree<Integer> child : tree.getChildren())
			resolver(child, level + 1, currentSum, currentPath, maxPath, maxValue);

		if (data != 0) currentPath.removeLast();
	}

}