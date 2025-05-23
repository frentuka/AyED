package site.ftka.ayed.parcial_ag.ParcialNahuel;

import site.ftka.ayed.parcial_ag.prac3.GeneralTree;

public class ParcialNahuel2 {

	public static void main(String[] args) {
		GeneralTree<String> tree = new GeneralTree<>("Entrada");

		GeneralTree<String> tree_1 = new GeneralTree<>("Camino A");
		GeneralTree<String> tree_2 = new GeneralTree<>("Bloqueo");
		GeneralTree<String> tree_3 = new GeneralTree<>("Pasaje A");

		GeneralTree<String> tree_1_1 = new GeneralTree<>("Caminata");
		GeneralTree<String> tree_1_2 = new GeneralTree<>("Callejon");

		GeneralTree<String> tree_1_1_1 = new GeneralTree<>("Entrepiso");
		GeneralTree<String> tree_1_1_1_1 = new GeneralTree<>("Tesoro");

		GeneralTree<String> tree_2_1 = new GeneralTree<>("Tesoro");

		GeneralTree<String> tree_3_1 = new GeneralTree<>("Camino B");

		GeneralTree<String> tree_3_1_1 = new GeneralTree<>("Camino C");
		GeneralTree<String> tree_3_1_2 = new GeneralTree<>("Tesoro_REAL");

		tree.addChild(tree_1);
		tree.addChild(tree_2);
		tree.addChild(tree_3);

		tree_1.addChild(tree_1_1);
		tree_1.addChild(tree_1_2);

		tree_1_1.addChild(tree_1_1_1);

		tree_1_1_1.addChild(tree_1_1_1_1);

		tree_2.addChild(tree_2_1);

		tree_3.addChild(tree_3_1);
		tree_3_1.addChild(tree_3_1_1);
		tree_3_1.addChild(tree_3_1_2);

		System.out.println(tesoroAccesibleMasCercano(tree));
	}

	/**
	 * si encuentro "tesoro" hay que devolver el camino
	 * puede haber más de un camino, hay que devolver el más cercano
	*/
	public static GeneralTree<String> tesoroAccesibleMasCercano(GeneralTree<String> camaras) {
		return tesoroAccesibleMasCercano(camaras, new int[1]);
	}

	private static GeneralTree<String> tesoroAccesibleMasCercano(GeneralTree<String> camaras, int[] longitud_camino) {
		longitud_camino[0]++;

		// caso base: soy null/bloqueo/tesoro
		if (camaras == null)
			return null;
		if (camaras.getData() != null) {
			if (camaras.getData().startsWith("Tesoro"))
				return camaras;
			if (camaras.getData().equals("Bloqueo"))
				return null;
		}

		int minCamino = Integer.MAX_VALUE - 1;
		GeneralTree<String> minTesoro = null;
		for (GeneralTree<String> child : camaras.getChildren()) {
			int[] camino_child = new int[1]; // funciona como un objeto y me permite recuperar el dato
			camino_child[0] = longitud_camino[0];
			GeneralTree<String> temp = tesoroAccesibleMasCercano(child, camino_child);

			if (camino_child[0] < minCamino)
				minTesoro = temp;
		}

		return minTesoro;
	}

}