package site.ftka.ayed.prac1.ej9;


    /*
        Considere un string de caracteres S, el cual comprende únicamente los caracteres: (,),[,],{,}.
        Decimos que S está balanceado si tiene alguna de las siguientes formas:
        S = "" S es el string de longitud cero.
        S = "(T)"
        S = "[T]"
        S = "{T}"
        S = "TU"
        Donde ambos T y U son strings balanceados. Por ejemplo, "{( ) [ ( ) ] }" está balanceado, pero "( [ ) ]" no lo está.

        a. Indique qué estructura de datos utilizará para resolver este problema y cómo la utilizará.

        b. Implemente una clase llamada tp1.ejercicio9.TestBalanceo, cuyo objetivo es
            determinar si un String dado está balanceado.
            El String a verificar es un parámetro de entrada (no es un dato predefinido).
     */

public class prac1ej9 {

    public static void main(String[] args) {
        // Usaré la estructura Stack.

        String test1_true = "()()()()[][][][abc] (asdas[d{a}s]d)";
        String test2_true = "((())())";
        String test3_false = "[ { ] }";

        System.out.println(TestBalanceo.isBalanceado(test1_true));
        System.out.println(TestBalanceo.isBalanceado(test2_true));
        System.out.println(TestBalanceo.isBalanceado(test3_false));

    }

}
