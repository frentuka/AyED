package site.ftka.ayed.modulo_ag.prac1.ej8;

    /*
        c. Implemente en JAVA la clase DoubleEndedQueue de acuerdo con la especificación dada
            en el diagrama de clases. Defina esta clase dentro del paquete tp1.ejercicio8.
        ● enqueueFirst():void Permite encolar al inicio.
     */

public class DoubleEndedQueue<T> extends Queue<T> {

    // ● enqueueFirst():void Permite encolar al inicio.
    public void enqueueFirst(T dato) {
        this.enqueue(dato);
        for (int i = 1; i < this.size(); i++)
            this.enqueue(this.dequeue()); // rotar toda la estructura size-1 posiciones
    }

}
