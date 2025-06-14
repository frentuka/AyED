package site.ftka.ayed.modulo_nodos.parciales;

import site.ftka.ayed.modulo_nodos.contenido_catedra.ejercicio1.Edge;
import site.ftka.ayed.modulo_nodos.contenido_catedra.ejercicio1.Graph;
import site.ftka.ayed.modulo_nodos.contenido_catedra.ejercicio1.Vertex;
import site.ftka.ayed.modulo_nodos.contenido_catedra.ejercicio1.adjList.AdjListGraph;

import java.util.ArrayList;
import java.util.List;

public class ParcialMundialSub20 {

	private static class Camino {
		ArrayList<String> camino;
		int distancia;
		public Camino(ArrayList<String> camino, int distancia) { this.camino = camino; this.distancia = distancia; }
		public Camino() { this.camino = new ArrayList<>(); this.distancia = 0; }

		@Override
		public String toString() {
			return camino.toString() + " = " + distancia + " cuadras.";
		}
	}

	public static List<Camino> resolver(Graph<String> grafo, String origen, String destino, List<String> evitar) {
		int posOrigen = pos(grafo, origen);
		int posDestino = pos(grafo, destino);
		if (posOrigen == -1 || posDestino == -1)
			return new ArrayList<>(); // no se puede llegar (no existe destino u origen)

		// no me interesa si alguno que haya que evitar no existe; simplemente no se evita.
		List<Camino> caminos = new ArrayList<>();
		resolver(grafo, grafo.getVertex(posOrigen), caminos, new Camino(), destino, evitar, new boolean[grafo.getSize()]);
		return caminos;
	}

	private static void resolver(Graph<String> grafo, Vertex<String> vert_actual, List<Camino> lista_caminos, Camino camino_actual, String destino, List<String> evitar, boolean[] visitado) {
		camino_actual.camino.add(vert_actual.getData());
		visitado[vert_actual.getPosition()] = true;

		// caso base: origen es destino (llegué)
		if (vert_actual.getData().equals(destino)) {
			lista_caminos.add(camino_actual);
			return;
		}

		// aún no llegué
		for (Edge<String> edge : grafo.getEdges(vert_actual)) {
			if (!evitar.contains(edge.getTarget().getData())) {
				Vertex<String> target = edge.getTarget();

				Camino camino = new Camino(new ArrayList<>(camino_actual.camino), camino_actual.distancia);
				camino.distancia+= edge.getWeight();
				resolver(
						grafo,
						target,
						lista_caminos,
						camino,
						destino,
						evitar,
						visitado
				);
			}
		}

		visitado[vert_actual.getPosition()] = false;
	}


	private static int pos(Graph<String> grafo, String vertex) {
		for (Vertex<String> v : grafo.getVertices())
			if (v.getData().equals(vertex))
				return v.getPosition();
		return -1;
	}


	public static void main(String[] args) {
		Graph<String> grafo = new AdjListGraph<>();

		Vertex<String> dam = grafo.createVertex("Estado Diego Armando Maradona");
		Vertex<String> macla = grafo.createVertex("MACLA");
		Vertex<String> catedral = grafo.createVertex("Catedral La Plata");
		Vertex<String> rectorado = grafo.createVertex("Rectorado UNLP");
		Vertex<String> museo = grafo.createVertex("Museo UNLP");
		Vertex<String> palacio = grafo.createVertex("Palacio Campodónico");
		Vertex<String> coliseo = grafo.createVertex("Coliseo Podestá");
		Vertex<String> legislatura = grafo.createVertex("Legislatura");

		grafo.connect(dam, catedral, 40);
		grafo.connect(dam, macla, 35);
		grafo.connect(dam, coliseo, 20);
		grafo.connect(dam, legislatura, 25);

		grafo.connect(legislatura, coliseo, 25);
		grafo.connect(coliseo, palacio, 10);
		grafo.connect(palacio, rectorado, 30);
		grafo.connect(rectorado, museo, 15);

		grafo.connect(macla, catedral, 8);
		grafo.connect(catedral, rectorado, 5);
		grafo.connect(rectorado, palacio, 30);

		List<String> evitar = List.of("Legislatura", "MACLA");
		System.out.println(resolver(grafo, "Estado Diego Armando Maradona", "Palacio Campodónico", evitar));
	}

}