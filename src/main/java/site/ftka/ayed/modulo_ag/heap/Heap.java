package site.ftka.ayed.modulo_ag.heap;


/// # Heap
///
/// ### Número de nodos
/// <p>
/// El número de nodos n de un árbol binario completo de altura h satisface:
///      2^h ≤ n ≤ 2^(h+1)-1
/// </p>
///
/// ##### ¿Por qué?
/// <p>
/// Si el árbol es lleno, n = 2^(h+1)-1
/// Si no, el árbol es lleno en la altura h-1 y tiene, por lo menos,
/// un nodo en el nivel h: n = 2^(h-1+1)-1+1 = 2^h
/// </p>
/// <br>
///
/// ##### La altura (h) del árbol es del órden de log(n)
/// <br>
///
/// ### Propiedad estructural
/// <p>
/// Dado que un árbol binario completo es una estructura de datos regular,
/// puede almacenarse en un arreglo tal que:
/// </p>
///
/// * ##### La raíz está almacenada en la posición 1
///
/// * ##### Para un elemento que está en la posición i:
/// <pre>
/// <b><i>* El hijo izquierdo está en la posición 2*i</i></b>
/// <b><i>* El hijo derecho está en la posición 2*i + 1</i></b>
/// <b><i>* El padre está en la posición ⎣ i/2 ⎦</i></b>
/// </pre>
///
/// ### Propiedad de orden
///
/// ##### MinHeap
/// <pre>
/// <b><i>* El elemento mínimo está almacenado en la raíz</i></b>
/// <b><i>* El dato almacenado en cada nodo es menor o igual al de sus hijos</i></b>
/// </pre>
///
/// ##### MaxHeap
/// <pre>
/// <b><i>* Ídem a MinHeap, pero a la inversa</i></b>
/// </pre>
///
public class Heap<T extends Comparable<T>> {

	private T[] heap;
	private int size = 0;

	public Heap(T[] heap) { this.heap = heap; this.size = heap.length; heapify(); }

	@SuppressWarnings("unchecked")
	public Heap(int capacity) {
	    this.heap = (T[]) new Comparable[capacity];
		this.size = capacity;
	}

	public void heapify() { }

	/**
	 * Adds an element to the heap and maintains the min-heap property.
	 * @param value The element to add
	 */
	public void add(T value) {
		ensureCapacity();
		heap[size] = value;
		siftUp(size);
		size++;
	}

	/**
	 * Ensures the heap array has enough capacity, doubling it if not.
	 */
	private void ensureCapacity() {
		if (size == heap.length) {
			@SuppressWarnings("unchecked")
			T[] newHeap = (T[]) new Comparable[heap.length * 2];
			System.arraycopy(heap, 0, newHeap, 0, size);
			heap = newHeap;
		}
	}

	/**
	 * Deletes and returns the minimum element from the heap.
	 * @return The minimum element
	 * @throws IllegalStateException if the heap is empty
	 */
	public T deleteMin() {
		if (size == 0) throw new IllegalStateException("Heap is empty");
		T min = heap[0];
		heap[0] = heap[--size];
		heap[size] = null;
		if (size > 0) siftDown(0);
		return min;
	}

	/**
	 * Returns the minimum element without removing it.
	 * @return The minimum element
	 * @throws IllegalStateException if the heap is empty
	 */
	public T peekMin() {
		if (size == 0) throw new IllegalStateException("Heap is empty");
		return heap[0];
	}

	/**
	 * Moves an element up the heap to maintain min-heap property.
	 * @param index The index of the element to sift up
	 */
	private void siftUp(int index) {
		while (index > 0) {
			int p = parent(index);
			if (heap[index].compareTo(heap[p]) >= 0) break;

			T temp = heap[index];
			heap[index] = heap[p];
			heap[p] = temp;
			index = p;
		}
	}

	/**
	 * Moves an element down the heap to maintain min-heap property.
	 * @param index The index of the element to sift down
	 */
	private void siftDown(int index) {
		while (true) {
			int smallest = index;
			int left = leftChild(index);
			int right = rightChild(index);

			if (left < size && heap[left].compareTo(heap[smallest]) < 0) {
				smallest = left;
			}
			if (right < size && heap[right].compareTo(heap[smallest]) < 0) {
				smallest = right;
			}

			if (smallest == index) break;

			T temp = heap[index];
			heap[index] = heap[smallest];
			heap[smallest] = temp;
			index = smallest;
		}
	}

	/**
	 * Returns the current size of the heap.
	 * @return The number of elements
	 */
	public int size() {
		return size;
	}

	/**
	 * Checks if the heap is empty.
	 * @return true if empty, false otherwise
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Returns the index of the left child of the element at given index.
	 * @param index The parent index
	 * @return The left child index
	 */
	private int leftChild(int index) {
		return 2 * index + 1;
	}

	/**
	 * Returns the index of the right child of the element at given index.
	 * @param index The parent index
	 * @return The right child index
	 */
	private int rightChild(int index) {
		return 2 * index + 2;
	}

	/**
	 * Returns the index of the parent of the element at given index.
	 * @param index The child index
	 * @return The parent index
	 */
	private int parent(int index) {
		return (index - 1) / 2;
	}

	private boolean isIndexValid(int index) {
		return index >= 0 && index < size;
	}

}