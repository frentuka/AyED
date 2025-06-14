package site.ftka.ayed.modulo_nodos.parciales;

import site.ftka.ayed.modulo_nodos.contenido_catedra.ejercicio1.Edge;
import site.ftka.ayed.modulo_nodos.contenido_catedra.ejercicio1.Graph;
import site.ftka.ayed.modulo_nodos.contenido_catedra.ejercicio1.Vertex;
import site.ftka.ayed.modulo_nodos.contenido_catedra.ejercicio1.adjList.AdjListGraph;

public class ParcialTemaiken {

	public static class Sitio {
		String nombre;
		int tiempo;
		public Sitio(String nombre, int tiempo) {
			this.nombre = nombre; this.tiempo = tiempo;
		}
	}

	// encontrar inicio e iniciar
	public static int resolver(Graph<Sitio> graph, int tiempo) {
		for (Vertex<Sitio> v : graph.getVertices())
			if (v.getData() != null && v.getData().nombre != null && v.getData().nombre.equals("Entrada"))
				if (v.getData().tiempo <= tiempo) {
					boolean[] visitados = new boolean[graph.getSize()];
					return resolver(graph, v, tiempo, visitados);
				}

		return 0;
	}

	// buscar caminos alternativos, devolver la distancia del más largo
	private static int resolver(Graph<Sitio> graph, Vertex<Sitio> vert_actual, int tiempo_disponible, boolean[] visitados) {
		visitados[vert_actual.getPosition()] = true;

		int recorrido = 0;

		if (vert_actual.getData().tiempo <= tiempo_disponible) {
			recorrido++;
			tiempo_disponible-= vert_actual.getData().tiempo;
		} else return 0;

		int recorrido_mas_largo = 0;
		for (Edge<Sitio> edge : graph.getEdges(vert_actual)) {
			if (edge.getWeight() <= tiempo_disponible && !visitados[edge.getTarget().getPosition()]) {
				int nuevo_tiempo = tiempo_disponible - edge.getWeight();
				Vertex<Sitio> target = edge.getTarget();

				int recorrido_del_vertice = resolver(
						graph,
						target,
						nuevo_tiempo,
						visitados
				);

				recorrido_mas_largo = Math.max(recorrido_mas_largo, recorrido_del_vertice);
			}
		}

		visitados[vert_actual.getPosition()] = false;
		return recorrido + recorrido_mas_largo;
	}

	public static void main(String[] args) {
		Graph<Sitio> grafo = new AdjListGraph<>();
		Vertex<Sitio> Entrada = grafo.createVertex(new Sitio("Entrada", 15));
		Vertex<Sitio> Cebras = grafo.createVertex(new Sitio("Cebras", 10));
		Vertex<Sitio> Tigres = grafo.createVertex(new Sitio("Tigres", 10));
		Vertex<Sitio> Flamencos = grafo.createVertex(new Sitio("Flamencos", 10));
		Vertex<Sitio> Murcielagos = grafo.createVertex(new Sitio("Murciélagos", 20));
		Vertex<Sitio> Wallabies = grafo.createVertex(new Sitio("Wallabies", 30));
		Vertex<Sitio> Tortugas = grafo.createVertex(new Sitio("Tortugas", 10));
		Vertex<Sitio> Pumas = grafo.createVertex(new Sitio("Pumas", 10));

		grafo.connect(Entrada, Cebras, 10);
		grafo.connect(Cebras, Entrada, 10);
		grafo.connect(Entrada, Tigres, 10);
		grafo.connect(Tigres, Entrada, 10);
		grafo.connect(Entrada, Murcielagos, 20);
		grafo.connect(Murcielagos, Entrada, 20);
		grafo.connect(Entrada, Flamencos, 25);
		grafo.connect(Flamencos, Entrada, 25);

		grafo.connect(Tigres, Cebras, 8);
		grafo.connect(Cebras, Tigres, 8);
		grafo.connect(Cebras, Tortugas, 10);
		grafo.connect(Tortugas, Cebras, 10);
		grafo.connect(Flamencos, Murcielagos, 25);
		grafo.connect(Murcielagos, Flamencos, 25);
		grafo.connect(Murcielagos, Wallabies, 10);
		grafo.connect(Wallabies, Murcielagos, 10);
		grafo.connect(Wallabies, Tortugas, 10);
		grafo.connect(Tortugas, Wallabies, 10);
		grafo.connect(Tortugas, Pumas, 15);
		grafo.connect(Pumas, Tortugas, 15);

		System.out.println(resolver(grafo, 100));
		System.out.println(resolver(grafo, 30));
	}

}