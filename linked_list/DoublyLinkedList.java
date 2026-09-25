package linked_list;

import utils.CustomException;

public class DoublyLinkedList<T> {
    private static class Node<T> {
        T value;
        Node<T> previous;
        Node<T> next;

        public Node(T value) {
            this.value = value;
            this.previous = null;
            this.next = null;
        }

        public Node(T value, Node<T> previous, Node<T> next) {
            this.value = value;
            this.previous = previous;
            this.next = next;
        }
    }

    private int size;
    private Node<T> head;
    private Node<T> tail;

    public DoublyLinkedList() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    public DoublyLinkedList(T value) {
        Node<T> node = new Node<>(value);
        this.head = node;
        this.tail = node;
        this.size = 1;
    }

    public void add(T value) throws CustomException {
        if (value == null) {
            throw new CustomException("ERROR: value is null.");
        }

        Node<T> newNode = new Node<>(value);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
        }

        tail = newNode;
        size++;
    }

    public void addFirst(T value) throws CustomException {
        if (value == null) {
            throw new CustomException("ERROR: value is null.");
        }

        Node<T> newNode = new Node<>(value);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }

        size++;
    }

    public void remove(T value) throws CustomException {
        if (isEmpty()) {
            throw new CustomException("ERROR: List is empty");
        }

        if (head.value.equals(value)) {
            Node<T> node = head;
            head = node.next;
            node.next = null;

            if (head != null) {
                head.previous = null;
            } else {
                tail = null;
            }

        } else {
            Node<T> predecessor = head;
            while (predecessor.next != null && !predecessor.next.value.equals(value)) {
                predecessor = predecessor.next;
            }

            if (predecessor.next == null) {
                throw new CustomException("ERROR: Node not found.");
            }

            Node<T> node = predecessor.next;
            Node<T> sucessor = node.next;
            predecessor.next = sucessor;

            if (sucessor == null) {
                tail = predecessor;
            } else {
                sucessor.previous = predecessor;
            }

            node.previous = null;
            node.next = null;
        }

        size--;
    }

    public T removeFirst() throws CustomException {
        if (isEmpty()) {
            throw new CustomException("ERROR: List is empty");
        }

        Node<T> node = head;
        head = node.next;

        if (head == null) {
            tail = null;
        } else {
            head.previous = null;
            node.next = null;
        }

        size--;

        return node.value;
    }

    public T removeLast() throws CustomException {
        if (isEmpty()) {
            throw new CustomException("ERROR: List is empty");
        }

        Node<T> node = tail;
        tail = node.previous;

        if (tail == null) {
            head = null;
        } else {
            tail.next = null;
            node.previous = null;
        }

        size--;

        return node.value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public T headValue() throws CustomException {
        if (isEmpty()) {
            throw new CustomException("ERROR: List is empty!");
        }

        return head.value;
    }

    public T tailValue() throws CustomException {
        if (isEmpty()) {
            throw new CustomException("ERROR: List is empty!");
        }

        return tail.value;
    }
}
