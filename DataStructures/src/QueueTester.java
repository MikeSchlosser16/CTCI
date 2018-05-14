/**
 * Created by MikeS on 5/10/18.
 */
public class QueueTester {
    public static void main(String[] args){
        Queue<Integer> queueInt = new Queue<>();
        queueInt.enqueue(3);
        queueInt.enqueue(11);
        queueInt.enqueue(16);
        System.out.println("Size: " + queueInt.getSize());
        System.out.println("Initial Queue: " + queueInt.toString());
        System.out.println("Dequeue: " + queueInt.dequeue()); // 3 -- FIFO
        System.out.println("New Queue Size: " + queueInt.getSize());
        System.out.println("New Queue: " + queueInt.toString());
        System.out.println("Dequeue: " + queueInt.dequeue()); // 11 -- FIFO
        System.out.println("Peek: " + queueInt.peek()); // 16
        queueInt.dequeue();
        System.out.println(queueInt.isEmpty());
    }
}
