package site.ftka.ayed.parcial_ag.prac3;

import java.util.LinkedList;
import java.util.List;

    /*
        a. Implemente en JAVA la clase Queue de acuerdo con la especificación dada en el
            diagrama de clases. Defina esta clase dentro del paquete tp1.ejercicio8.
        ● Queue() Constructor de la clase
        ● enqueue(dato: T): Inserta el elemento al final de la cola
        ● dequeue():T Elimina el elemento del frente de la cola y lo retorna.
            Si la cola está vacía se produce un error.
        ● head(): T Retorna el elemento del frente de la cola. Si la cola está vacía se produce un error.
        ● isEmpty(): boolean Retorna verdadero si la cola no tiene elementos y falso en caso contrario
        ● size():int Retorna la cantidad de elementos de la cola.
        ● toString(): String Retorna los elementos de la cola en un String
     */

public class Queue<T> {

    private final List<T> data;
    private int size = 0;

    // ● Queue() Constructor de la clase
    public Queue() {
        this.data = new LinkedList<T>();
    }

    // no solicitado pero me parece fundamental
    public Queue(List<T> data) {
        this.data = new LinkedList<T>(data);
        size = data.size();
    }

    /** ● enqueue(dato: T): Inserta el elemento al final de la cola */
    public void enqueue(T dato) {
        data.addLast(dato);
        size++;
    }

    /** ● dequeue(): T Elimina el elemento del frente de la cola y lo retorna. */
    public T dequeue() {
        size--;
        return data.removeFirst();
    }

    /** ● head(): T Retorna el elemento del frente de la cola. Si la cola está vacía se produce un error. */
    public T head() {
        return data.getFirst();
    }

    /** ● isEmpty(): boolean Retorna verdadero si la cola no tiene elementos y falso en caso contrario */
    public boolean isEmpty() {
        return size == 0;
    }

    /** ● size():int Retorna la cantidad de elementos de la cola. */
    public int size() {
        return size;
    }

    /** ● toString(): String Retorna los elementos de la cola en un String */
    @Override
    public String toString() {
        return data.toString();
    }
}