package queue;

import linked_list.SinglyLinkedList;
import utils.CustomException;

public class QueueList<T> {
    private final SinglyLinkedList<T> elements;

    public QueueList() {
        elements = new SinglyLinkedList<>();
    }

    public void enqueue(T value) throws CustomException {
        if (value == null) {
            throw new CustomException("ERROR: value is null.");
        }

        elements.add(value);
    }

    public T dequeue() throws CustomException {
        if (isEmpty()) {
            throw new CustomException("ERROR: Queue is empty!");
        }

        return elements.removeFirst();
    }

    public T peek() throws CustomException {
        if (isEmpty()) {
            throw new CustomException("ERROR: Queue is empty!");
        }

        return elements.headValue();
    }

    public int size() {
        return elements.getSize();
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }
}
