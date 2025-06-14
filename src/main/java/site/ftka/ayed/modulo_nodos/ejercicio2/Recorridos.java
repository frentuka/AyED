package site.ftka.ayed.modulo_nodos.ejercicio2;

import site.ftka.ayed.modulo_ag.prac3.Queue;
import site.ftka.ayed.modulo_nodos.contenido_catedra.ejercicio1.Edge;
import site.ftka.ayed.modulo_nodos.contenido_catedra.ejercicio1.Graph;
import site.ftka.ayed.modulo_nodos.contenido_catedra.ejercicio1.Vertex;

import java.util.ArrayList;
import java.util.List;

public class Recorridos<T> {

	// el método principal solo selecciona un vértice princiapl
	public List<T> dfs(Graph<T> graph) {
		return dfs(graph, graph.getVertex(0), new boolean[graph.getSize()]);
	}

	private List<T> dfs(Graph<T> graph, Vertex<T> vertice, boolean[] visitado) {
		if (graph.isEmpty())
			return new ArrayList<>();

		List<T> list = new ArrayList<>();

		visitado[vertice.getPosition()] = true;
		list.add(vertice.getData());

		for (Edge<T> childVertex : graph.getEdges(vertice))
			if (!visitado[childVertex.getTarget().getPosition()])
				list.addAll(dfs(graph, childVertex.getTarget(), visitado));

		return list;
	}

	public List<T> bfs(Graph<T> graph) {
		if (graph.isEmpty())
			return new ArrayList<>();

		List<T> lista = new ArrayList<>();

		boolean[] visitado = new boolean[graph.getSize()];
		Queue<Vertex<T>> cola = new Queue<>();
		cola.enqueue(graph.getVertex(0));
		visitado[0] = true;

		while (!cola.isEmpty()) {
			Vertex<T> actual = cola.dequeue();

			lista.add(actual.getData());

			for (Edge<T> e : graph.getEdges(actual))
				if (!visitado[e.getTarget().getPosition()]) {
					visitado[e.getTarget().getPosition()] = true;
					cola.enqueue(e.getTarget());
				}
		}

		return lista;
	}
}