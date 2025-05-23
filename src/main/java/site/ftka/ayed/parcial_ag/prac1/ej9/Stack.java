package site.ftka.ayed.parcial_ag.prac1.ej9;

import java.util.LinkedList;
import java.util.List;

class Stack<T> {

    private List<T> data;

    public Stack() {
        this.data = new LinkedList<T>();
    }

    public Stack(List<T> data) {
        this.data = new LinkedList<T>(data);
    }

    public int size() {
        return data.size();
    }

    public void push(T data) {
        this.data.addFirst(data);
    }

    public T pop() {
        return this.data.removeFirst();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

}