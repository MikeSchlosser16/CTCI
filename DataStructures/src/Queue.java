import java.util.NoSuchElementException;

/**
 * Created by MikeS on 5/10/18.
 */

// Queue is FIFO
// The enqueue, dequeue, peek, getSize and isEmpty() all take constant time in the worst case
public class Queue<T> {

    private class Node{
        T value;
        Node next;
    }

    Integer size;
    Node first;
    Node last;

    Queue(){
        size = 0;
        first = null;
        last = null;
    }

    public Boolean isEmpty(){
        return first == null;
    }

    public Integer getSize(){
        return size;
    }

    //Enqueue puts item at the end of the queue
    public void enqueue(T item){
        Node oldLast = last;
        last = new Node();
        last.value = item;
        last.next = null;
        if(isEmpty()){
            first = last;
        } else {
            oldLast.next = last;
        }
        size++;
    }

    // Get first item
    public T dequeue(){
        if(isEmpty()){
            throw new NoSuchElementException("Queue is empty.");
        }
        T item = first.value;
        first = first.next;
        size--;
        if(isEmpty()){
            last = null; // to avoid loitering
        }
        return item;
    }

    public T peek(){
        if(isEmpty()){
            throw new NoSuchElementException("Queue is empty.");
        }
        return first.value;
    }

    public String toString(){
       Node node = first;
       String val = "[";
       while (node.next != null){
           val += node.value + ",";
           node = node.next;
       }
       return val + node.value + "]";
    }
}

/*public class Queue<T> {
    private ArrayList<T> queueArrayList;
    private int size;

    Queue(){
        queueArrayList = new ArrayList<T>();
        size = 0;
    }


    public void enqueue(T element){
        queueArrayList.add(element);
        size++;
    }

    public T dequeue(){
        if(size > 0) {
            size--;
            T value = queueArrayList.get(0);
            queueArrayList.remove(0); // Automatically shifts to the left
            return value;
        } else {
            throw new IllegalAccessError();
        }
    }

    public T peek(){
        if(size > 0){
            return queueArrayList.get(0);
        } else {
            throw new IllegalAccessError();
        }
    }

    public boolean isEmpty(){
        return (size == 0);
    }

    public int getSize(){
        return size;
    }

    @Override
    public String toString(){
        String queueRepresentation = "[";
        for(int i = 0; i < size; i++){
            if(i <= size - 2){
                queueRepresentation += queueArrayList.get(i).toString() + ", ";
            } else {
                queueRepresentation += queueArrayList.get(i) + "]";
            }
        }
        return queueRepresentation;
    }
}*/
