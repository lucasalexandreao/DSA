package linked_list;

import utils.CustomException;

public class SinglyLinkedList {

  private static class Node {
    int key;
    Node next;

    public Node(int key) {
      this.key = key;
      this.next = null;
    }

    public Node(int key, Node next) {
      this.key = key;
      this.next = next;
    }
  }

  private int size;
  private Node head;
  private Node tail;

  public SinglyLinkedList(){
    this.size = 0;
    this.head = null;
    this.tail = null;
  }

  public SinglyLinkedList(int key) {
    Node node = new Node(key);
    this.head = node;
    this.tail = node;
    this.size = 1;
  }

  public void add(int key) {
    Node newNode = new Node(key);

    if (isEmpty()) {
      head = newNode;
    } else {
      tail.next = newNode;
    }

    tail = newNode;
    size++;
  }

  public void remove(int key) throws CustomException {
    if (isEmpty()) throw new CustomException("ERROR: List is empty!");
    
    if (head.key == key) {
      Node node = head;
      head = node.next;
      node.next = null;
      if (head == null) tail = null;
    } else {
      Node predecessor = head;
      while(predecessor.next != null && predecessor.next.key != key) {
        predecessor = predecessor.next;
      }
  
      if (predecessor.next == null) throw new CustomException(("ERROR: Node not found."));
  
      Node node = predecessor.next;
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
