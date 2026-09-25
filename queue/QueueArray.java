package queue;

import utils.CustomException;

public class QueueArray<T> {
    private final int capacity;
    private final Object[] elements;
    private int first;
    private int size; 

    public QueueArray(int capacity) {
        this.capacity = capacity;
        elements = new Object[capacity];
        first = 0;
        size = 0;
    }

    public void enqueue(T value) throws CustomException {
        if (isFull()) {
            throw new CustomException("ERROR: Queue is full!");
        }

        elements[(first + size) % capacity] = value;
        size++;
    }

    @SuppressWarnings("unchecked")
    public T dequeue() throws CustomException {
        if (isEmpty()) {
            throw new CustomException("ERROR: Queue is empty!");
        }

        T value = (T) elements[first];
        elements[first] = null;

        first = (first + 1) % capacity;
        size--;

        return value;
    }

    @SuppressWarnings("unchecked")
    public T peek() throws CustomException {
        if (isEmpty()) {
            throw new CustomException("ERROR: Queue is empty!");
        }

        return (T) elements[first];
    }

    public int getSize() {
        return size;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
