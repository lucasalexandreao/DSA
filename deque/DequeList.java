package deque;

import linked_list.DoublyLinkedList;
import utils.CustomException;

public class DequeList<T> {
    private final DoublyLinkedList<T> elements;
    
    public DequeList() {
        elements = new DoublyLinkedList<>();
    }

    public void addFirst(T value) throws CustomException {
        if (value == null) {
            throw new CustomException("ERROR: value is null.");
        }

        elements.addFirst(value);
    }

    public void addLast(T value) throws CustomException {
        if (value == null) {
            throw new CustomException("ERROR: value is null.");
        }

        elements.add(value);
    }

    public T removeFirst() throws CustomException {
        if (isEmpty()) {
            throw new CustomException("ERROR: Deque is empty.");
        }

        return elements.removeFirst();
    }

    public T removeLast() throws CustomException {
        if (isEmpty()) {
            throw new CustomException("ERROR: Deque is empty.");
        }

        return elements.removeLast();
    }

    public T peekFirst() throws CustomException {
        if (isEmpty()) {
            throw new CustomException("ERROR: Deque is empty.");
        }

        return elements.headValue();
    }

    public T peekLast() throws CustomException {
        if (isEmpty()) {
            throw new CustomException("ERROR: Deque is empty.");
        }

        return elements.tailValue();
    }

    public int getSize() {
        return elements.getSize();
    }
    
    public boolean isEmpty() {
        return elements.isEmpty();
    }

}
