package site.ftka.ayed;

/*
5. Dado un arreglo de valores tipo entero se desea calcular:
	el valor máximo, mínimo, y promedio en un único método.
	Escriba tres métodos de clase, donde respectivamente:

		a. Devuelva lo pedido por el mecanismo de retorno de un método en Java ("return").

		b. Devuelva lo pedido interactuando con algún parámetro
			(el parámetro no puede ser de tipo arreglo).

		c. Devuelva lo pedido sin usar parámetros ni la sentencia "return".
 */


import site.ftka.ayed.prac1.ej5.prac1ej5_Tupla;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public class MClass {

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