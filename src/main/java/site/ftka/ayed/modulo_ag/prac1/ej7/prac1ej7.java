package site.ftka.ayed.modulo_ag.prac1.ej7;


/*
7. Uso de las estructuras de listas provistas por la API de Java.
	Para resolver este punto cree el paquete tp1.ejercicio7

		a. Escriba una clase llamada TestArrayList cuyo método main
		recibe una secuencia de números, los agrega a una lista de tipo ArrayList
		y luego de haber agregado todos los números a la lista
		imprime el contenido de la misma iterando sobre cada elemento.

		b. Si en lugar de usar un ArrayList en el inciso anterior
		hubiera usado un LinkedList ¿Qué diferencia encuentra
		respecto de la implementación? Justifique

		c. ¿Existen otras alternativas para recorrer los elementos
		de la lista del punto 7a.?

		d. Escriba un método que realice las siguientes acciones:
			■ cree una lista que contenga 3 estudiantes
			■ genere una nueva lista que sea una copia de la lista del inciso i
			■ imprima el contenido de la lista original y el contenido de la nueva lista
			■ modifique algún dato de los estudiantes
			■ vuelva a imprimir el contenido de la lista original
				y el contenido de la nueva lista.
			¿Qué conclusiones obtiene a partir de lo realizado?
			■ ¿Cuántas formas de copiar una lista existen?
				¿Qué diferencias existen entre ellas?

		e. A la lista del punto 7d, agregue un nuevo estudiante.
			Antes de agregar, verifique que el estudiante no estaba incluido en la lista.

		f. Escriba un método que devuelva verdadero o falso
			si la secuencia almacenada en la lista es o no capicúa:
			public boolean esCapicua(ArrayList<Integer> lista)

		Ejemplo: 3Algoritmos y Estructuras de Datos
		● El método devuelve verdadero si la secuencia ingresada es: 2 5 2
		● El método devuelve falso si la secuencia ingresada es: 4 5 6 3 4
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class prac1ej7 {

	public static void main(String[] args) {
		// a.
//		String[] array = {"123", "456", "7890"};
//		prac1ej7_TestArrayList.main(array);
//		prac1ej7_TestArrayList.mainParalelo(array);
//
//		crearListaEstudiantes();

		// h.
//		ArrayList<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
//		System.out.println(list);
//		invertirArrayList(list);
//		System.out.println(list);

		// i.
//		LinkedList<Integer> lista = new LinkedList<>(List.of(1, 2, 3, 4, 5));
//		System.out.println(sumarLinkedList_sinPerdida(lista));
//		System.out.println(sumarLinkedList(lista));

		// j.
//		ArrayList<Integer> list1 = new ArrayList<>(List.of(1, 3, 5));
//		ArrayList<Integer> list2 = new ArrayList<>(List.of(2, 3, 4, 5, 6));
//		ArrayList<Integer> ordenado = combinarOrdenado(list1, list2);
//		System.out.println(ordenado);
	}

	/*
	d. Escriba un método que realice las siguientes acciones:
		■ cree una lista que contenga 3 estudiantes
		■ genere una nueva lista que sea una copia de la lista del inciso i
		■ imprima el contenido de la lista original y el contenido de la nueva lista
		■ modifique algún dato de los estudiantes
		■ vuelva a imprimir el contenido de la lista original y el contenido de la nueva lista.
			¿Qué conclusiones obtiene a partir de lo realizado?
		■ ¿Cuántas formas de copiar una lista existen?
			¿Qué diferencias existen entre ellas?
	 */

	/*
		Formas de copiar una lista:
			Constructor: new ArrayList<>(originalList)
			addAll(): newList.addAll(originalList)
			List.of() + toList(): List.copyOf(originalList)
			clone(): ((ArrayList)originalList).clone()
			Stream: originalList.stream().collect(Collectors.toList())
	 */

	private static void crearListaEstudiantes() {
		List<String> listaEstudiantes = new ArrayList<>(List.of("Frentuka", "Valentino", "Yoni"));
		List<String> listaEstudiantes2 = new ArrayList<>(listaEstudiantes);

		System.out.println(Arrays.toString(listaEstudiantes.toArray()));
		System.out.println(Arrays.toString(listaEstudiantes2.toArray()));

		listaEstudiantes2.set(0, "Frentuka2");
		listaEstudiantes2.set(1, "Valentino2");
		listaEstudiantes2.set(2, "Yoni2");

		System.out.println(Arrays.toString(listaEstudiantes.toArray()));
		System.out.println(Arrays.toString(listaEstudiantes2.toArray()));

		// e. A la lista del punto 7d, agregue un nuevo estudiante.
		// Antes de agregar, verifique que el estudiante no estaba incluido en la lista.
		String nuevoEstudiante = "Nahuel";
		if (!listaEstudiantes.contains(nuevoEstudiante))
			listaEstudiantes.add(nuevoEstudiante);


	}

	// f. Escriba un método que devuelva verdadero o falso
	// si la secuencia almacenada en la lista es o no capicúa:
	public boolean esCapicua(ArrayList<Integer> lista) {
		for (int i = 0; i < lista.size() / 2; i++) {
			if (!lista.get(i).equals(lista.get(lista.size() - 1 - i))) {
				return false;
			}
		}

		return true;
	}

	// g. Considere que se aplica la siguiente función de forma recursiva.
	// A partir de un número n positivo se obtiene una sucesión que termina en 1:
	public int gDeN(int n) {
		if (n != 1) {
			if (n % 2 == 0)
				return gDeN(n / 2);
			else
				return gDeN(3*n+1);
		}
		return n;
	}

	// Escriba un programa recursivo que, a partir de un número n,
	// devuelva una lista con cada miembro de la sucesión.
	public List<Integer> calcularSucesion(int n) {
		List<Integer> sucesion = new ArrayList<>();

		if (n != 1) {
			if (n % 2 == 0) n = n / 2;
			else n = 3 * n + 1;
			sucesion.add(n);
			sucesion.addAll(calcularSucesion(n));
		}

		return sucesion;
	}

	// h. Implemente un método recursivo que invierta el orden de los elementos en un ArrayList.
	public static void invertirArrayList(ArrayList<Integer> arrayList) {
		if (!arrayList.isEmpty()) {
			int elem = arrayList.removeFirst();
			invertirArrayList(arrayList);
			arrayList.add(elem);
		}
	}

	// i. Implemente un método recursivo que calcule la suma de los elementos en un LinkedList.
	public static int sumarLinkedList(LinkedList<Integer> lista) {
		if (!lista.isEmpty())
			return lista.removeFirst() + sumarLinkedList(lista);
		else return 0;
	}

	public static int sumarLinkedList_sinPerdida(LinkedList<Integer> lista) {
		int suma = 0;
		if (!lista.isEmpty()) {
			int act = lista.removeFirst();
			suma = act + sumarLinkedList(lista);
			lista.addFirst(act);
		}
		return suma;
	}

	// j. Implemente el método “combinarOrdenado” que reciba 2 listas de números ordenados
	// y devuelva una nueva lista también ordenada conteniendo los elementos de las 2 listas.
	private static ArrayList<Integer> combinarOrdenado(ArrayList<Integer> lista1, ArrayList<Integer> lista2) {
		ArrayList<Integer> res = new ArrayList<>();
		ArrayList<Integer> clone1 = new ArrayList<>(lista1);
		ArrayList<Integer> clone2 = new ArrayList<>(lista2);

		while (!clone1.isEmpty() && !clone2.isEmpty()) {
			if (clone1.getFirst() < clone2.getFirst()) {
				res.add(clone1.getFirst());
				clone1.removeFirst();
			} else {
				res.add(clone2.getFirst());
				clone2.removeFirst();
			}
		}

		res.addAll(clone1);
		res.addAll(clone2);

		return res;
	}

}
