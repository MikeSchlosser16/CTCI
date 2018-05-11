import java.util.ArrayList;
import java.util.EmptyStackException;

// Stack is LIFO -- this could be implemented with many other structures, such as primitive array, Node, LinkedList etc.
public class Stack<T> {

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
}