package site.ftka.ayed.parciales.ParcialNahuel;

import site.ftka.ayed.prac3.GeneralTree;
import site.ftka.ayed.prac3.Queue;

/// # Parcial
/// Un árbol general se considera "profundmente inferior" a otro árbol general arbol2 cuando,<br>
///     en todos los nodos coincidentes en posición entre ambos árboles,<br>
///
/// # 1. <br>
///         El valor de cada nodo en arbol1 es menor que el mismo nodo (en ubicación) del arbol2<br>
/// # 2. <br>
///         a. Si ambos nodos tienen hijos, la suma de los valores de los hijos del nodo en arbol1<br>
///                 debe ser menor que la suma de los valores de los hijos del nodo correspondiente de arbol2<br>
///         b. Si ambos nodos son hojas, la condición se considera cumplida si cumlpen la condición 1<br>
///
/// # 3. Si uno de los nodos es una hoja y el otro no:<br>
///         a. Si un nodo de arbol1 es hoja y el nodo correspondiente en arbol2 no es hoja, entonces<br>
///                 la condición se considera cumplida si cumple la condición 1<br>
///         b. Si un nodo del arbol2 es hoja y el nodo correspondiente del arbol1 no es hoja, entonces<br>
///                 la condición NO se cumple y la función debe devolver false<br>
public class ParcialNahuel1 {

	public static void main(String[] args) {
		// EJEMPLO 1: TRUE

		GeneralTree<Integer> tree1 = new GeneralTree<>(10);

		GeneralTree<Integer> tree1_1 = new GeneralTree<>(4);
		GeneralTree<Integer> tree1_2 = new GeneralTree<>(3);
		GeneralTree<Integer> tree1_3 = new GeneralTree<>(2);

		GeneralTree<Integer> tree1_1_1 = new GeneralTree<>(1);

		tree1.addChild(tree1_1);
		tree1.addChild(tree1_2);
		tree1.addChild(tree1_3);

		tree1_1.addChild(tree1_1_1);


		GeneralTree<Integer> tree2 = new GeneralTree<>(15);

		GeneralTree<Integer> tree2_1 = new GeneralTree<>(8);
		GeneralTree<Integer> tree2_2 = new GeneralTree<>(5);

		GeneralTree<Integer> tree2_1_1 = new GeneralTree<>(2);
		GeneralTree<Integer> tree2_1_2 = new GeneralTree<>(-2);
		GeneralTree<Integer> tree2_1_3 = new GeneralTree<>(6);

		GeneralTree<Integer> tree2_2_1 = new GeneralTree<>(7);

		tree2.addChild(tree2_1);
		tree2.addChild(tree2_2);

		tree2_1.addChild(tree2_1_1);
		tree2_1.addChild(tree2_1_2);
		tree2_1.addChild(tree2_1_3);

		tree2_2.addChild(tree2_2_1);

		// EJEMPLO 2: TRUE

		GeneralTree<Integer> tree3 = new GeneralTree<>(10);
		GeneralTree<Integer> tree4 = new GeneralTree<>(15);

		// EJEMPLO 3: FALSE

		GeneralTree<Integer> tree5 = new GeneralTree<>(17);
		GeneralTree<Integer> tree6 = new GeneralTree<>(15);

		// EJEMPLO 4: TRUE

		GeneralTree<Integer> tree7 = new GeneralTree<>(10);
		GeneralTree<Integer> tree8 = new GeneralTree<>(15);

		GeneralTree<Integer> tree8_1 = new GeneralTree<>(8);

		tree8.addChild(tree8_1);

		// EJEMPLO 5: FALSE

		GeneralTree<Integer> tree9 = new GeneralTree<>(10);
		GeneralTree<Integer> tree10 = new GeneralTree<>(15);

		GeneralTree<Integer> tree9_1 = new GeneralTree<>(10);

		tree9.addChild(tree9_1);

		////////////////////////////////////////////////////////////////////
		ComparadorDeArbolesGenerales comp = new ComparadorDeArbolesGenerales();

		System.out.println("Resultado ejemplo 1: (Expect TRUE) " + comp.esInferiorProfundo(tree1, tree2));
		System.out.println("Resultado ejemplo 2: (Expect TRUE) " + comp.esInferiorProfundo(tree3, tree4));
		System.out.println("Resultado ejemplo 3: (Expect FALSE) " + comp.esInferiorProfundo(tree5, tree6));
		System.out.println("Resultado ejemplo 4: (Expect TRUE) " + comp.esInferiorProfundo(tree7, tree8));
		System.out.println("Resultado ejemplo 5: (Expect FALSE) " + comp.esInferiorProfundo(tree9, tree10));
	}

	public static class ComparadorDeArbolesGenerales {
		/*
			Recorrido por niveles.
		 */
		public boolean esInferiorProfundo(GeneralTree<Integer> arbol1, GeneralTree<Integer> arbol2) {
			Queue<GeneralTree<Integer>> queue1 = new Queue<>(), queue2 = new Queue<>();
			queue1.enqueue(arbol1);
			queue2.enqueue(arbol2);

			while (!queue1.isEmpty() && !queue2.isEmpty()) {
				GeneralTree<Integer> actualTree1 = queue1.dequeue(),
									 actualTree2 = queue2.dequeue();

				// Regla 1
				if (actualTree1.getData() > actualTree2.getData())
					return false;

				for (int i = 0; i < actualTree1.getChildren().size(); i++) {
					/* No puedo permitir que existan más elementos por nivel en queue1 que en queue2 */
					if (i < actualTree2.getChildren().size()) {
						queue1.enqueue(actualTree1.getChildren().get(i));
						queue2.enqueue(actualTree2.getChildren().get(i));
					}
					/* De esta forma sólo se procesan nodos coincidentes en posición */
				}
				
				// Regla 2a: Si ambos nodos tienen hijos, la suma de los valores de los hijos del nodo en arbol1
				//   debe ser menor que la suma de los valores de los hijos del nodo correspondiente de arbol2
				// Regla 2b: Si ambos nodos son hojas, la condición se considera cumplida si cumlpen la condición 1
				if (!actualTree1.isLeaf() && !actualTree2.isLeaf() && sumaDeHijos(actualTree1) > sumaDeHijos(actualTree2))
					return false;

				// Si uno de los nodos es una hoja y el otro no:

				// Regla 3a: Si un nodo de arbol1 es hoja y el nodo correspondiente en arbol2 no es hoja, entonces
                //   la condición se considera cumplida si cumple la condición 1

				// Regla 3b: Si un nodo del arbol2 es hoja y el nodo correspondiente del arbol1 no es hoja, entonces
				//   la condición NO se cumple y la función debe devolver false
				if (!actualTree1.isLeaf() && actualTree2.isLeaf())
					return false;
			}

			// no pudo fallar
			return true;
		}

		private int sumaDeHijos(GeneralTree<Integer> tree) {
			int sum = 0;
			for (GeneralTree<Integer> child : tree.getChildren())
				sum+= child.getData() != null ? child.getData() : 0;
			return sum;
		}

	}

}