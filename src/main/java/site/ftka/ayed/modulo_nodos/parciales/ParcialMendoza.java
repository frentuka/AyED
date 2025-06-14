package site.ftka.ayed.modulo_nodos.parciales;

import site.ftka.ayed.modulo_nodos.contenido_catedra.ejercicio1.Edge;
import site.ftka.ayed.modulo_nodos.contenido_catedra.ejercicio1.Graph;
import site.ftka.ayed.modulo_nodos.contenido_catedra.ejercicio1.Vertex;
import site.ftka.ayed.modulo_nodos.contenido_catedra.ejercicio1.adjList.AdjListGraph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ParcialMendoza {

	public static List<String> recorrido(Graph<String> grafo, int cantLocalidades, int cantNafta, List<String> evitar) {
		// encontrar Mendoza
		List<String> lista = new ArrayList<>();
		for (Vertex<String> v : grafo.getVertices())
			if (v.getData().equals("Mendoza")) {
				if (recorrido(grafo, v, lista, cantLocalidades, cantNafta, evitar, new boolean[grafo.getSize()]))
					return lista;
				else return new ArrayList<>();
			}
		return lista;
	}

	private static boolean recorrido(Graph<String> grafo, Vertex<String> actual, List<String> lista, int cantLocalidades, int nafta_restante, List<String> evitar, boolean[] visitado) {
		lista.add(actual.getData());
		visitado[actual.getPosition()] = true;

		// caso base: el camino actual cumple!
		// Mendoza SÍ cuenta
		if (lista.size() >= cantLocalidades)
			return true;

		boolean continuar = true;
		Iterator<Edge<String>> it = grafo.getEdges(actual).iterator();
		while (it.hasNext() && continuar) {
			Edge<String> e = it.next();
			Vertex<String> target = e.getTarget();

			if (!evitar.contains(target.getData())
					&& !visitado[target.getPosition()]
					&& ((nafta_restante - e.getWeight()) >= 0)) {

				int nueva_nafta_restante = nafta_restante - e.getWeight();
				if (recorrido(grafo, target, lista, cantLocalidades, nueva_nafta_restante, evitar, visitado)) {
					continuar = false;
					return true;
				}
			}
		}

		// no se encontró! eliminar lo agregado
		if (!lista.isEmpty())
			lista.remove(lista.size() - 1);

		visitado[actual.getPosition()] = false;
		return false;
	}


	public static void main(String args[]) {
		Graph<String> grafo = new AdjListGraph<>();
		Vertex<String> v1 = grafo.createVertex("Mendoza");
		Vertex<String> v2 = grafo.createVertex("Tunuyán");
		Vertex<String> v3 = grafo.createVertex("San Martin");
		Vertex<String> v4 = grafo.createVertex("La Paz");
		Vertex<String> v5 = grafo.createVertex("Santa Rosa");
		Vertex<String> v6 = grafo.createVertex("San Rafael");
		Vertex<String> v7 = grafo.createVertex("Malargue");
		Vertex<String> v8 = grafo.createVertex("General Alvear");

		grafo.connect(v1, v2, 10);
		grafo.connect(v1, v3, 6);
		grafo.connect(v2, v3, 10);
		grafo.connect(v3, v4, 8);
		grafo.connect(v4, v5, 2);
		grafo.connect(v3, v6, 13);
		grafo.connect(v6, v2, 11);
		grafo.connect(v6, v8, 7);
		grafo.connect(v2, v7, 12);
		grafo.connect(v8, v7, 6);

		List<String> localidadesExceptuadas = new ArrayList<>();
		localidadesExceptuadas.add("General Alvear");
		localidadesExceptuadas.add("La Paz");

		System.out.println(recorrido(grafo, 5, 80, localidadesExceptuadas));
	}

}
