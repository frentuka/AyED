package site.ftka.ayed.prac1.ej7;

/*
	a. Escriba una clase llamada TestArrayList cuyo método main
		recibe una secuencia de números, los agrega a una lista de tipo ArrayList
		y luego de haber agregado todos los números a la lista
		imprime el contenido de la misma iterando sobre cada elemento.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.IntStream;

public class prac1ej7_TestArrayList {

	public static void main(String[] args) {
		int[] args_int = Arrays.stream(args).mapToInt(Integer::parseInt).toArray();

		ArrayList<Integer> int_list = Arrays.stream(args_int).flatMap(IntStream::of)
				.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

		int_list.forEach(System.out::println);
	}

/*
	b. Si en lugar de usar un ArrayList en el inciso anterior
		hubiera usado un LinkedList ¿Qué diferencia encuentra
		respecto de la implementación? Justifique
 */

	public static void mainParalelo(String[] args) {
		int[] args_int = Arrays.stream(args).mapToInt(Integer::parseInt).toArray();

		LinkedList<Integer> int_list = new LinkedList<>();
		for (int arg: args_int) {
			int_list.add(arg);
		}

		int_list.forEach(System.out::println);
	}

/*
	c. ¿Existen otras alternativas para recorrer los elementos
		de la lista del punto 7a.?
 */
	// For indexado, For no indexado, While indexado, método .forEach
	// Stream API, Iterator, ListIterator, Spliterator...
}