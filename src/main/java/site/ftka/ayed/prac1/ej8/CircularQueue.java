package site.ftka.ayed.prac1.ej8;


    /*
        b. Implemente en JAVA las clase CircularQueue de acuerdo con la especificación dada en el diagrama de clases.
            Defina esta clase dentro del paquete tp1.ejercicio8.
        ● shift(): T Permite rotar los elementos, haciéndolo circular. Retorna el elemento encolado.
     */

class CircularQueue<T> extends Queue<T> {

    // ● shift(): T Permite rotar los elementos, haciéndolo circular. Retorna el elemento encolado.
    public T shift() {
        T elem = this.dequeue();
        this.enqueue(elem);
        return elem;
    }

}
