package site.ftka.ayed.parcial_ag.prac1.ej6;

import java.util.ArrayList;

public class prac1_ej6 {

    public static void main(String[] args) {
        ejerA();
    }

    private static final int MAX_VAL = Integer.MAX_VALUE/64;

    // a. ¿En qué casos ArrayList ofrece un mejor rendimiento que LinkedList?
    // - Acceso secuencial: Gana ArrayList O(1) vs O(n)
    // - Acceso aleatorio: Gana ArrayList O(1) vs O(n)
    // - Eliminación aleatoria: Gana ArrayList O(n) vs O(n)

    // b. ¿Cuándo LinkedList puede ser más eficiente que ArrayList?
    // - Eliminación secuencial: Gana LinkedList (ArrayList es casi idénticamente veloz si se elimina el último elemento)
    // ArrayList tiene un tiempo de O(n) para eliminar un elemento al principio pero O(1) para eliminar el último elemento
    // - Agregado secuencial: Gana LinkedList

    // c. ¿Qué diferencia encuentra en el uso de la memoria en ArrayList y LinkedList?
    // LinkedList: 5980 ms, 33554431 elementos, 1349 MB
    // LinkedList posee 3 campos por cada elemento: Anterior, Elemento y Actual

    // ArrayList: 849 ms, 33554431 elementos, 924 MB
    // ArrayList posee 2 campos por cada elemento:

    // d. ¿En qué casos sería preferible usar un ArrayList o un LinkedList?
    // Cuando se necesita un acceso rápido a los elementos, se prefiere ArrayList.
    // Cuando se necesita una lista que cambie de tamaño dinámicamente y se realicen muchas inserciones o eliminaciones, se prefiere LinkedList.
    private static void ejerA() {
        // Agregado secuencial
        System.out.println("Creando una lista de elementos secuencialmente");

        // ArrayList:
        Long startTime = System.currentTimeMillis();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < MAX_VAL; i++) {
            arrayList.add(i);
        }
        System.out.println("ArrayList: " + (System.currentTimeMillis() - startTime) + " ms, " + MAX_VAL + " elementos");
//
//        // LinkedList:
//        Long startTime = System.currentTimeMillis();
//        LinkedList<Integer> linkedList = new LinkedList<>();
//        for (int i = 0; i < MAX_VAL; i++) {
//            linkedList.addLast(i);
//        }
//        System.out.println("LinkedList: " + (System.currentTimeMillis() - startTime) + " ms, " + MAX_VAL + " elementos");


//        // Test: Eliminación secuencial
//        System.out.println("Eliminando elementos de forma secuencial");
//        // ArrayList:
//        startTime = System.currentTimeMillis();
//        while (!arrayList.isEmpty()) {
//            arrayList.removeLast(); // result is ignored
//        }
//        System.out.println("ArrayList: " + (System.currentTimeMillis() - startTime) + " ms");
//
//        // LinkedList:
//        startTime = System.currentTimeMillis();
//        while (!linkedList.isEmpty()) {
//            linkedList.removeLast(); // result is ignored
//        }
//
//        System.out.println("LinkedList: " + (System.currentTimeMillis() - startTime) + " ms");

//        // Test: Acceso secuencial
//        System.out.println("Accediendo a los elementos de forma secuencial");
//        // ArrayList:
//        startTime = System.currentTimeMillis();
//        for (int i = 0; i < MAX_VAL; i++) {
//            arrayList.get(i); // result is ignored
//        }
//        System.out.println("ArrayList: " + (System.currentTimeMillis() - startTime) + " ms");
//
//        // LinkedList:
//        startTime = System.currentTimeMillis();
//        for (int i = 0; i < MAX_VAL; i++) {
//            linkedList.get(i); // result is ignored
//        }
//        System.out.println("LinkedList: " + (System.currentTimeMillis() - startTime) + " ms");
//
//
//        // Test: Accesos aleatorios
//        System.out.println("Accediendo a los elementos de forma aleatoria");
//        // ArrayList:
//        startTime = System.currentTimeMillis();
//        for (int i = 0; i < MAX_VAL; i++) {
//            arrayList.get(randomInt()); // result is ignored
//        }
//        System.out.println("ArrayList: " + (System.currentTimeMillis() - startTime) + " ms");
//
//        // LinkedList:
//        startTime = System.currentTimeMillis();
//        for (int i = 0; i < MAX_VAL; i++) {
//            linkedList.get(randomInt()); // result is ignored
//        }
//        System.out.println("LinkedList: " + (System.currentTimeMillis() - startTime) + " ms");
//
//        // Test: Eliminación aleatoria
//        System.out.println("Eliminando elementos de forma aleatoria");
//        // ArrayList:
//        startTime = System.currentTimeMillis();
//        for (int i = 0; i < MAX_VAL; i++) {
//            arrayList.remove(randomBetween(0, arrayList.size()-1)); // result is ignored
//        }
//        System.out.println("ArrayList: " + (System.currentTimeMillis() - startTime) + " ms");
//
//        // LinkedList:
//        startTime = System.currentTimeMillis();
//        for (int i = 0; i < MAX_VAL; i++) {
//            linkedList.remove(randomBetween(0, linkedList.size()-1)); // result is ignored
//        }
//        System.out.println("LinkedList: " + (System.currentTimeMillis() - startTime) + " ms");

        while(true){}
    }

    // from Integer.MIN_VALUE to Integer.MAX_VALUE
    public static int randomInt() {
        return (int) (Math.random() * (MAX_VAL));
    }

    public static int randomBetween(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

}