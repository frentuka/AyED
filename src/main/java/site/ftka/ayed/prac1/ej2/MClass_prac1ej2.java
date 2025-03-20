package site.ftka.ayed.prac1.ej2;

import java.util.Arrays;
import java.util.Scanner;

public class MClass_prac1ej2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		while (n != -1) {
			System.out.println(Arrays.toString(arregloN(n)));
			n = scanner.nextInt();
		}
	}

	private static int[] arregloN(int n) {
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = n*(i+1);
		}

		return arr;
	}

}
