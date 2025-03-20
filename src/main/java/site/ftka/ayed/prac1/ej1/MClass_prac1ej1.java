package site.ftka.ayed.prac1.ej1;

public class MClass_prac1ej1 {

	public static void main(String[] args) {
		int a = 5, b = 7;
		numerosFor(a, b);
		numerosWhile(a, b);
		numerosRec(a, b);
	}

	// no quiero usar static pero me obligan
	public static void numerosFor(int a, int b) {
		for (int i = a; i <= b; i++) {
			System.out.println(a);
		}
	}

	public static void numerosWhile(int a, int b) {
		while (a <= b) {
			System.out.println(a);
			a++;
		}
	}

	public static void numerosRec(int a, int b) {
		System.out.println(a);
		if (a <= b)
			numerosRec(a+1, b);
	}

}