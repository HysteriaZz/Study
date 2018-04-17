package chapter17.part7;

import java.util.LinkedList;

/**
 * Created by KaiLin.Guo on 2018-04-16.
 * LinkedList实现双向队列
 */
public class Deque<T> {
    private LinkedList<T> deque = new LinkedList<>();
    public void addFirst(T e) {
        deque.addFirst(e);
    }
    public void addLast(T e) {
        deque.addLast(e);
    }
    public T getFirst() {
        return deque.getFirst();
    }
    public T getLast() {
        return deque.getLast();
    }
    public T removeFirst() {
        return deque.removeFirst();
    }
    public T removeLast() {
        return deque.removeLast();
    }
    public int size() {
        return deque.size();
    }
    public boolean isEmpty() {
        return deque.isEmpty();
    }

    @Override
    public String toString() {
        return deque.toString();
    }
}
