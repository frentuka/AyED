package site.ftka.ayed.parcial_ag.prac2.ej4;

/*

    Los nodos que conforman una red binaria llena tiene la particularidad
        de que todos ellos conocen su retardo de reenvío.
        El retardo de reenvío se define como el período comprendido entre que un nodo recibe un mensaje
        y lo reenvía a sus dos hijos.
        Su tarea es calcular el mayor retardo posible en el camino que realiza un mensaje
        desde la raíz hasta llegar a las hojas en una red binaria llena.
        En el ejemplo, debería retornar 10+3+9+12=34 (Si hay más de un máximo retorne el último valor hallado).
        Nota: asuma que cada nodo tiene el dato de retardo de reenvío expresado en cantidad de segundos.

        a) Indique qué estrategia (recorrido en profundidad o por niveles) utilizará para resolver el problema.

        b)Cree una clase Java llamada RedBinariaLlena donde implementará lo solicitado
            en el método retardoReenvio():int

*/

public class prac2ej4 {

    public static void main(String[] args) {

    }

    /*
        a.
            De hacer un recorrido por niveles me encuentro con que un recorrido de un nivel
                puede parecer el más conveniente para encontrar el mayor retardo posible
                pero que la inferencia de los siguientes niveles cambien completamente cuál es el recorrido
                más conveniente a hacer.
            Entonces usaré recorrido en profundidad que me garantiza conocer el tiempo total de cada camino.
     */

}