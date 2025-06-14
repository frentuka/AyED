package site.ftka.ayed.modulo_ag.prac3.ej3;


import site.ftka.ayed.modulo_ag.prac3.GeneralTree;
import site.ftka.ayed.modulo_ag.prac3.Queue;

/// # _Prac. 3, ej. 4_
///
/// <p>El esquema de comunicación de una empresa está organizado en una estructura jerárquica,
///     en donde cada nodo envía el mensaje a sus descendientes.
///     Cada nodo posee el tiempo que tarda en transmitir el mensaje.</p>
///
///     <p>Se debe devolver el mayor promedio entre todos los valores promedios de los niveles.
///     Para el ejemplo presentado, el promedio del nivel 0 es 14, el del nivel 1 es 16 y el del nivel 2 es 10.
///         Por lo tanto, debe devolver 16.</p>
///
///     <p>a) Indique y justifique qué tipo de recorrido utilizará para resolver el problema.</p>
///
///     <p>b) Implementar en una clase AnalizadorArbol, el método con la siguiente firma:
///         ```public double devolverMaximoPromedio (GeneralTree<AreaEmpresa>arbol)```
///         Donde AreaEmpresa es una clase que representa a un área de la empresa mencionada<br>
///             y que contiene la identificación de la misma representada con un String<br>
///             y una tardanza de transmisión de mensajes interna representada con int.</p>

public class prac3ej3 {

	/*
		a.
			Al ser un ejercicio que pide un resultado que se obtiene procesando niveles individuales,
			la mejor opción es claramente un recorrido por niveles.
	 */

	public static void main(String[] args) {
		GeneralTree<AreaEmpresa> tree = new GeneralTree<>(new AreaEmpresa("M", 14));

		GeneralTree<AreaEmpresa> tree_1 = new GeneralTree<>(new AreaEmpresa("J", 13));
		GeneralTree<AreaEmpresa> tree_2 = new GeneralTree<>(new AreaEmpresa("K", 25));
		GeneralTree<AreaEmpresa> tree_3 = new GeneralTree<>(new AreaEmpresa("L", 10));

		GeneralTree<AreaEmpresa> tree_1_1 = new GeneralTree<>(new AreaEmpresa("A", 4));
		GeneralTree<AreaEmpresa> tree_1_2 = new GeneralTree<>(new AreaEmpresa("B", 7));
		GeneralTree<AreaEmpresa> tree_1_3 = new GeneralTree<>(new AreaEmpresa("C", 5));

		GeneralTree<AreaEmpresa> tree_2_1 = new GeneralTree<>(new AreaEmpresa("D", 6));
		GeneralTree<AreaEmpresa> tree_2_2 = new GeneralTree<>(new AreaEmpresa("E", 10));
		GeneralTree<AreaEmpresa> tree_2_3 = new GeneralTree<>(new AreaEmpresa("F", 18));

		GeneralTree<AreaEmpresa> tree_3_1 = new GeneralTree<>(new AreaEmpresa("G", 9));
		GeneralTree<AreaEmpresa> tree_3_2 = new GeneralTree<>(new AreaEmpresa("H", 12));
		GeneralTree<AreaEmpresa> tree_3_3 = new GeneralTree<>(new AreaEmpresa("I", 19));

		tree.addChild(tree_1);
		tree.addChild(tree_2);
		tree.addChild(tree_3);

		tree_1.addChild(tree_1_1);
		tree_1.addChild(tree_1_2);
		tree_1.addChild(tree_1_3);

		tree_2.addChild(tree_2_1);
		tree_2.addChild(tree_2_2);
		tree_2.addChild(tree_2_3);

		tree_3.addChild(tree_3_1);
		tree_3.addChild(tree_3_2);
		tree_3.addChild(tree_3_3);

		AnalizadorArbol analizador = new AnalizadorArbol();

		System.out.println(tree);
		System.out.println("Mayor promedio: " + analizador.devolverMaximoPromedio(tree));
	}



	public static class AreaEmpresa {
		String id;
		int area;
		public AreaEmpresa(String id, int area) {
			this.id = id;
			this.area = area;
		}

		@Override
		public String toString() {
			return id + " " + area;
		}
	}



	public static class AnalizadorArbol {

		public double devolverMaximoPromedio(GeneralTree<AreaEmpresa> tree) {
			Queue<GeneralTree<AreaEmpresa>> queue = new Queue<>();
			queue.enqueue(tree);

			double maxPromedio = 0;

			int
					actualSum = 0,
					treesOnNextLevel = 0,
					treesOnThisLevel = 1,
					treesRemainingOnThisLevel = 1;

			while (!queue.isEmpty()) {
				GeneralTree<AreaEmpresa> actualTree = queue.dequeue();

				actualSum+= actualTree.getData().area;
				treesRemainingOnThisLevel--;
				treesOnNextLevel += actualTree.getChildren().size();

				// new level or end of tree
				if (treesRemainingOnThisLevel == 0) { // shouldn't ever happen
					if (treesOnThisLevel != 0) {
						double promedio = (double) actualSum / treesOnThisLevel;
						if (promedio > maxPromedio)
							maxPromedio = promedio;
					}

					actualSum = 0;
					treesOnThisLevel = treesOnNextLevel;
					treesRemainingOnThisLevel = treesOnThisLevel;
					treesOnNextLevel = 0;
				}

				for (GeneralTree<AreaEmpresa> child : actualTree.getChildren())
					queue.enqueue(child);


			}

			return maxPromedio;
		}

	}

}