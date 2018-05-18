import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.NoSuchElementException;

// Stack is LIFO
// Push, pop, peek, getSize, isEmpty all take constant time O(1)
public class Stack<T> {

    public static void main(String[] args){
        System.out.println("hi");
    }
    private class Node{
        T value;
        Node next;
    }

    Integer size;
    Node first; // First is the top of the stack -- ie the most recent value

    Stack(){
        size = 0;
        first = null;
    }

    public Boolean isEmpty(){
        return first == null;
    }

    public Integer getSize(){
        return size;
    }

    // First always keeps track of the next item to pop off the stack, the top of the Stack
    public void push(T item){
      Node oldFirst = first;
      first = new Node();
      first.next = oldFirst;
      first.value = item;
      size++;
    }

    public T pop(){
        if(isEmpty()){
            throw new NoSuchElementException("Stack is empty.");
        }
        T item = first.value;
        first = first.next;
        size--;
        return item;
    }

    public T peek(){
        if(isEmpty()){
            throw new NoSuchElementException("Stack is empty.");
        }
        return first.value;
    }

    public String toString(){
        Node node = first;
        String val = "[(MOST RECENT)";
        while(node != null){
            val += node.value + " ";
            node = node.next;
        }
        return val + "(OLDEST)]";
    }

}




/*public class Stack<T> {

    private ArrayList<T> stackArrayList;
    private int size;

    public Stack(){
        stackArrayList = new ArrayList<T>();
        size = 0;
    }

    // O(1) -- think, we only can access the top item
    public void push(T element){
        stackArrayList.add(element);
        size += 1;
    }

    // O(1) -- think, we only can access the top item
    public T pop(){
        if(size > 0) {
            T top = stackArrayList.get(size - 1);
            size -= 1;
            return top;
        } else {
            throw new EmptyStackException();
        }
    }

    public boolean isEmpty(){
        return (size == 0);
    }

    // O(1) -- think, we only can access the top item
    public T peek(){
        if(size != 0){
            return stackArrayList.get(size - 1);
        } else {
            throw new EmptyStackException();
        }
    }


    public ArrayList<T> getStackArrayList() {
        return stackArrayList;
    }

    public void setStackArrayList(ArrayList<T> stackArrayList) {
        this.stackArrayList = stackArrayList;
    }

    public int getSize() {
        return size;
    }

    // Of course we can just use stackArrayList.toString()
    @Override
    public String toString(){
        String stackRepresentation = "[";
        for(int i = 0; i < size; i++){
            if(i <= size - 2){
                stackRepresentation += stackArrayList.get(i).toString() + ", ";
            } else {
                stackRepresentation += stackArrayList.get(i) + "]";
            }
        }
        return stackRepresentation;
    }
}*/