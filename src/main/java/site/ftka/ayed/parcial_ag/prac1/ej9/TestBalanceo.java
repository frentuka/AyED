package site.ftka.ayed.parcial_ag.prac1.ej9;

public class TestBalanceo {

    public static boolean isBalanceado(String input) {
        Stack<Character> stack = new Stack<Character>();

        for (char c: input.toCharArray()) {
            // si es un carácter de apertura
            if ("[{(".contains("" + c)) {
                stack.push(c);
            } else // si es un carácter de cierre
                if ("]})".contains("" + c)) {
                    char apertura = stack.pop();
                    if (!corroborarAperturaCierre(apertura, c))
                        return false;
            }
        }

        return stack.isEmpty();
    }

    private static boolean corroborarAperturaCierre(char apertura, char cierre) {
        if ('[' == apertura && ']' == cierre)
            return true;
        if ('{' == apertura && '}' == cierre)
            return true;
        return '(' == apertura && ')' == cierre;
    }

}
