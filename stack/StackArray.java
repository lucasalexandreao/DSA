package stack;

import utils.CustomException;

public class StackArray<T> {

  private final int capacity;
  private final Object[] elements;
  private int top;

  public StackArray(int capacity) {
    this.capacity = capacity;
    top = -1;
    elements = new Object[capacity];
  }
  
  public boolean isFull() {
    return top == capacity - 1;
  }  

  public boolean isEmpty() {
    return top == -1;
  }

  public int size() {
    return top + 1;
  }

  public void push(T element) throws CustomException {
    if (isFull()) throw new CustomException("ERROR: Stack is full!");

    elements[++top] = element;
  }

  @SuppressWarnings("unchecked")
  public T pop() throws CustomException {
    if (isEmpty()) throw new CustomException("ERROR: Stack is empty!");

    T element = (T) elements[top];
    elements[top--] = null;

    return element;
  }
  
  @SuppressWarnings("unchecked")
  public T peek() throws CustomException {
    if (isEmpty()) throw new CustomException("ERROR: Stack is empty!");

    return (T) elements[top];
  }

}