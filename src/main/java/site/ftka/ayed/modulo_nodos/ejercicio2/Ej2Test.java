package site.ftka.ayed.modulo_nodos.ejercicio2;

import site.ftka.ayed.modulo_nodos.contenido_catedra.ejercicio1.Graph;
import site.ftka.ayed.modulo_nodos.contenido_catedra.ejercicio1.Vertex;
import site.ftka.ayed.modulo_nodos.contenido_catedra.ejercicio1.adjList.AdjListGraph;

public class Ej2Test {

	public static void main(String[] args) {
		Graph<Integer> graph = new AdjListGraph<>();

		Vertex<Integer> v0 = graph.createVertex(0);

		Vertex<Integer> v10 = graph.createVertex(10);
		Vertex<Integer> v11 = graph.createVertex(11);
		Vertex<Integer> v12 = graph.createVertex(12);

		Vertex<Integer> v20 = graph.createVertex(20);
		Vertex<Integer> v21 = graph.createVertex(21);
		Vertex<Integer> v22 = graph.createVertex(22);

		Vertex<Integer> v100 = graph.createVertex(100);

		graph.connect(v0, v10);
		graph.connect(v0, v11);
		graph.connect(v0, v12);

		graph.connect(v10, v20);
		graph.connect(v11, v21);
		graph.connect(v12, v22);

		graph.connect(v20, v100);
		graph.connect(v21, v100);
		graph.connect(v22, v100);

		Recorridos<Integer> r = new Recorridos<>();
		System.out.println(r.bfs(graph));
		System.out.println(r.dfs(graph));
	}

}
