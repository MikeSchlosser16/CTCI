import java.security.spec.ECField;
import java.util.ArrayList;

/**
 * Created by MikeS on 5/10/18.
 */

//Queue is FIFO
public class Queue<T> {
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
}
