package site.ftka.ayed.prac1.ej5;

/*
Creación de instancias mediante el uso del operador new

a. Cree una clase llamada Estudiante con los atributos especificados abajo
	y sus correspondientes métodos getters y setters
	(haga uso de las facilidades que brinda eclipse)
	● nombre
	● apellido
	● comision
	● email
	● direccion

b. Cree una clase llamada Profesor con los atributos especificados abajo
	y sus correspondientes métodos getters y setters
	(haga uso de las facilidades que brinda eclipse)
	● nombre
	● apellido
	● email
	● catedra
	● facultad

c. Agregue un método de instancia llamado tusDatos() en la clase Estudiante
	y en la clase Profesor, que retorne un String con los datos
	de los atributos de las mismas.
	Para acceder a los valores de los atributos
	utilice los getters previamente definidos.

d. Escriba una clase llamada Test con el método main,
	el cual cree un arreglo con 2 objetos Estudiante,
	otro arreglo con 3 objetos Profesor, y luego recorra ambos arreglos
	imprimiendo los valores obtenidos mediante el método tusDatos().
	Recuerde asignar los valores de los atributos
	de los objetos Estudiante y Profesor invocando los respectivos métodos setters.

e. Agregue dos breakpoints, uno en la línea donde itera sobre los estudiantes
	y otro en la línea donde itera sobre los profesores

f. Ejecute la clase Test en modo debug y avance paso a paso
	visualizando si el estudiante o el profesor recuperado es lo esperado.
 */

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public class prac1_ej5 {

	public static void main(String[] args) {

	}

	public prac1ej5_Tupla ejerA(int[] array) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		double avg = 0.0;

		OptionalInt optMax = Arrays.stream(array).max();
		OptionalInt optMin = Arrays.stream(array).min();
		OptionalDouble optAvg = Arrays.stream(array).average();

		if (optMax.isPresent())
			max = optMax.getAsInt();

		if (optMin.isPresent())
			min = optMin.getAsInt();

		if (optAvg.isPresent())
			avg = optAvg.getAsDouble();

		return new prac1ej5_Tupla(max, min, avg);
	}

	public void ejerB(prac1ej5_Tupla tupla, int[] array) {
		OptionalInt optMax = Arrays.stream(array).max();
		OptionalInt optMin = Arrays.stream(array).min();
		OptionalDouble optAvg = Arrays.stream(array).average();

		if (optMax.isPresent())
			tupla.setMax(optMax.getAsInt());

		if (optMin.isPresent())
			tupla.setMin(optMin.getAsInt());

		if (optAvg.isPresent())
			tupla.setAvg(optAvg.getAsDouble());
	}

	prac1ej5_Tupla ejerC;
	public void ejerC(int[] array) {
		OptionalInt optMax = Arrays.stream(array).max();
		OptionalInt optMin = Arrays.stream(array).min();
		OptionalDouble optAvg = Arrays.stream(array).average();

		ejerC = new prac1ej5_Tupla(0, 0, 0.0);

		if (optMax.isPresent())
			ejerC.setMax(optMax.getAsInt());

		if (optMin.isPresent())
			ejerC.setMin(optMin.getAsInt());

		if (optAvg.isPresent())
			ejerC.setAvg(optAvg.getAsDouble());
	}

}
