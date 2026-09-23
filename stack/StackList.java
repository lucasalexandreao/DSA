package stack;

import linked_list.SinglyLinkedList;
import utils.CustomException;

public class StackList<T> {
    private final SinglyLinkedList<T> elements;

    public StackList() {
        elements = new SinglyLinkedList<>();
    }

    public void push(T value) throws CustomException {
        elements.addFirst(value);
    }

    public T pop() throws CustomException {
        if (isEmpty()) {
            throw new CustomException("ERROR: Stack is empty!");
        }

        return elements.removeFirst();
    }

    public T peek() throws CustomException {
        if (isEmpty()) {
            throw new CustomException("ERROR: Stack is empty!");
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
