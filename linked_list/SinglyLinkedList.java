package linked_list;

import utils.CustomException;

public class SinglyLinkedList<T> {

  private static class Node<T> {
    T value;
    Node<T> next;

    public Node(T value) {
      this.value = value;
      this.next = null;
    }

    public Node(T value, Node<T> next) {
      this.value = value;
      this.next = next;
    }
  }

  private int size;
  private Node<T> head;
  private Node<T> tail;

  public SinglyLinkedList(){
    this.size = 0;
    this.head = null;
    this.tail = null;
  }

  public SinglyLinkedList(T value) {
    Node<T> node = new Node<>(value);
    this.head = node;
    this.tail = node;
    this.size = 1;
  }

  public void add(T value) throws CustomException {
    if (value == null) throw new CustomException("ERROR: value is null.");
    
    Node<T> newNode = new Node<>(value);

    if (isEmpty()) {
      head = newNode;
    } else {
      tail.next = newNode;
    }

    tail = newNode;
    size++;
  }

  public void remove(T value) throws CustomException {
    if (isEmpty()) throw new CustomException("ERROR: List is empty!");
    
    if (head.value.equals(value)) {
      Node<T> node = head;
      head = node.next;
      node.next = null;
      if (head == null) tail = null;
    } else {
      Node<T> predecessor = head;
      while(predecessor.next != null && !predecessor.next.value.equals(value)) {
        predecessor = predecessor.next;
      }
  
      if (predecessor.next == null) throw new CustomException(("ERROR: Node not found."));
  
      Node<T> node = predecessor.next;
      predecessor.next = node.next;
      if (predecessor.next == null) tail = predecessor;
      node.next = null;
    }

    size--;
  }

  public boolean isEmpty() {
    return size == 0;
  }

}
