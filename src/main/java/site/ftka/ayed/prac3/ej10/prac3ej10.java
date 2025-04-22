package site.ftka.ayed.prac3.ej10;

import site.ftka.ayed.prac3.GeneralTree;

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

		System.out.println(resolver(tree));
	}

	public static List<Integer> resolver(GeneralTree<Integer> arbol) {
		return resolver(arbol, new ArrayList<>());
	}

	private static List<Integer> resolver(GeneralTree<Integer> arbol, List<Integer> caminoActual) {
		if (arbol.isLeaf())
			return List.of(arbol.getData());

		List<Integer> best_found_path = List.of();
		int best_found_path_value = Integer.MIN_VALUE;

		for (GeneralTree<Integer> child : arbol.getChildren()) {
			List<Integer> child_best_path = resolver(child, caminoActual);
			int path_value = calcularCamino(child_best_path);

			if (path_value > best_found_path_value) {
				best_found_path_value = path_value;
				best_found_path = child_best_path;
			}
		}



		return caminoActual;
	}

	private static int calcularCamino(List<Integer> camino) {
		int res = 0;
		for (int i = 0; i < camino.size(); i++) {
			res+= i * camino.get(i);
		}
		return res;
	}

}