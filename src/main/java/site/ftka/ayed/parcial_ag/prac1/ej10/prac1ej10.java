package site.ftka.ayed.parcial_ag.prac1.ej10;


    /*
        10. Considere el siguiente problema: Se quiere modelar la cola de atención en un banco.
                A medida que la gente llega al banco toma un ticket para ser atendido.
                Sin embargo, de acuerdo a la LEY 14564 de la Provincia de Buenos Aires,
                se establece la obligatoriedad de otorgar prioridad de atención a mujeres embarazadas,
                a personas con necesidades especiales o movilidad reducida y personas mayores de setenta (70) años.
                De acuerdo a las estructuras de datos vistas en esta práctica,
                ¿qué estructura de datos sugeriría para el modelado de la cola del banco?
     */

public class prac1ej10 {

    public static void main(String[] args) {
        /*
            En el caso hipotético en el que no existiese dicha ley,
            el modelo adecuado sería una simple Queue, donde el último en llegar
            es el último en ser atendido.

            Si fuese obligación utilizar una única estructura de las que ya vimos y no poder crear otra,
            la DoubleEndedQueue sería la forma correcta de atravesar el problema
            ya que permite incluir a las personas alcanzadas por la ley 14.564 al principio.

            Pero este tipo de estructura añade una nueva injusticia: si alguna persona alcanzada por la ley
            se encuentra en cola, entonces los últimos alcanzados por la ley en llegar
            serán los primeros en atenderse, lo cual no tiene mucho sentido.

            Para esta ocasión, utilizaría una estructura que contenga 2 Queue:
            la primera de personas no alcanzadas por la ley y la segunda que sólo incluye personas
            alcanzadas por la ley. Al hacer un dequeue(), éste se ejecutaría sobre la segunda Queue
            a no ser que esta esté vacía. Al hacer un enqueue() se deberá especificar a qué Queue "encolar".

            Este sistema se conoce como Priority Queues / Colas de prioridad.
         */
    }

}