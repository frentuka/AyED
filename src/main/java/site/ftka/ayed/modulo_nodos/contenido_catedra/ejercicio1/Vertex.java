package site.ftka.ayed.modulo_nodos.contenido_catedra.ejercicio1;

public interface Vertex<T> {
	
	/**
	 * Retorna el dato del vértice.
	 * 
	 * @return T
	 */
	public T getData();

	/**
	 * Reemplaza el dato del vértice.
	 * 
	 * @param dato
	 */
	public void setData(T data);

	/**
	 * Retorna la posición del vértice en el grafo.
	 * 
	 * @return int
	 */
	public int getPosition();
}
