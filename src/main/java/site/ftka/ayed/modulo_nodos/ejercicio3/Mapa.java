package site.ftka.ayed.modulo_nodos.ejercicio3;

import site.ftka.ayed.modulo_ag.prac3.Queue;
import site.ftka.ayed.modulo_nodos.contenido_catedra.ejercicio1.Graph;
import site.ftka.ayed.modulo_nodos.contenido_catedra.ejercicio1.Vertex;

import java.util.ArrayList;
import java.util.List;

public class Mapa {

	private Graph<String> mapaCiudades;

	public Mapa(Graph<String> mapaCiudades) {
		this.mapaCiudades = mapaCiudades;
	}

	// Retorna la lista de ciudades que se deben atravesar para ir de ciudad1 a ciudad2
	// en caso de que se pueda llegar, si no retorna la lista vacía.
	// (Sin tener en cuenta el combustible).
	public List<String> devolverCamino(String c1, String c2) {
		List<String> camino = new ArrayList<>();

		boolean[] visitados = new boolean[mapaCiudades.getSize()];


		Queue<Vertex<String>> queue = new Queue<>();

		return camino;
	}

	// Retorna la lista de ciudades que forman un camino desde ciudad1 a ciudad2,
	// sin pasar por las ciudadesque están contenidas en la lista ciudades pasada por parámetro,
	// si no existe camino retorna la listavacía.
	// (Sin tener en cuenta el combustible).
	public List<String> devolverCaminoExceptuando(String c1, String c2, List<String> excepciones) {
		List<String> camino = new ArrayList<>();

		return camino;
	}

	// Retorna la lista de ciudades que forman el camino más corto para llegar de ciudad1 a ciudad2,
	// si no existe camino retorna la lista vacía.
	// (Las rutas poseen la distancia).
	public List<String> caminoMasCorto(String c1, String c2) {
		List<String> camino = new ArrayList<>();

		return camino;
	}

	// Retorna la lista de ciudades que forman un camino para llegar de ciudad1 a ciudad2.
	// El auto no debe quedarse sin combustible y no puede cargar.
	// Si no existe camino retorna la lista vacía.
	public List<String> caminoSinCargarCombustible(String c1, String c2, int tanqueAuto) {
		List<String> camino = new ArrayList<>();

		return camino;
	}

	// Retorna la lista de ciudades que forman un camino para llegar de ciudad1 a ciudad2
	// teniendo en cuenta que el auto debe cargar la menor cantidad de veces.
	// El auto no se debe quedar sin combustible en medio de una ruta,
	// además puede completar su tanque al llegar a cualquier ciudad.
	// Si no existe camino retorna la lista vacía.
	public List<String> caminoConMenorCargaDeCombustible(String c1, String c2, int tanqueAuto) {
		List<String> camino = new ArrayList<>();

		return camino;
	}

}
