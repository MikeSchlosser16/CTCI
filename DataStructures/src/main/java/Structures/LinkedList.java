package Structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by MikeS on 5/21/18.
 */
public class LinkedList<T> {

    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    Node head = null;
    int size;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public T get(int index){
        if(head == null) throw new IllegalAccessError("LinkedList is empty.");
        Node<T> temp = head;
        for(int i = 0; i < index; i++){
            temp = head.next;
        }
        return temp.data;
    }

    public void addFirst(T item){
        head = new Node<>(item, head);
        size++;
    }

    public void addLast(T item){
        if(head == null){
            addFirst(item);
        } else {
            Node<T> temp = head;
            // Start with the head and access each node until we reach null, the last node
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = new Node<T>(item, null);
            size++;
        }
    }

    public void insertAfter(T key, T item){
        Node temp = head;
        while(temp.next != null && !temp.data.equals(key)){
            temp = temp.next;
        }
        temp.next = new Node<T>(item, null);
        size++;
    }

    public void insertBefore(T key, T item){
        if(head == null){
            throw new IllegalArgumentException("Linked list empty. Cant insert before");
        }
        if(head.data.equals(key)){
            //head = new Node<T>(item, head);
            addFirst(item);
        }
        Node current = head;
        Node previous = null;
        while(current.next != null && !current.data.equals(key)){
            previous = current;
            current = current.next;
        }
        if(current != null){
            previous.next = new Node<T>(item, current);
        }
        size++;
    }

    public void remove(T item){
        if(head == null){
            throw new IllegalArgumentException("Can not delete from empty linked list.");
        }
        if(head.data.equals(item)){
            head = head.next;
            return;
        }
        Node current = head;
        Node previous = null;
        while(current != null && !current.data.equals(item)){
            previous = current;
            current = current.next;
        }
        if(current == null){
            throw new IllegalArgumentException("Cannot delete null");
        }
        previous.next = current.next;
        size--;
    }

    public LinkedList<T> reverse(){
        LinkedList<T> list = new LinkedList<T>();
        Node<T> temp = head;
        while(temp != null){
            addFirst(temp.data); // Always just add first, has effect of reversing list
            temp = temp.next;
        }
        return list;
    }

    // One way to copy non shallow - iterate, add each element to start of new Linked List, then reverse
    public Object copy(){
        LinkedList<T> twin = new LinkedList<T>();
        Node<T> temp = head;
        while(temp != null){
            twin.addFirst(temp.data);
            temp = temp.next;
        }
        return twin.reverse();
    }

    // A better way involves using a tail reference for the new list, adding each node after the last node
    public LinkedList<T> copy2(){
        if(head == null){
            return null;
        }
        LinkedList<T> twin = new LinkedList<T>();
        Node temp = head;
        twin.head = new Node(head.data,null);
        Node tempTwin = twin.head;

        while(temp.next != null){
            temp = temp.next;
            tempTwin.next = new Node(temp.data, temp.next);
            tempTwin = tempTwin.next;
        }
        return twin;
    }

    /*The whole idea of the iterator is to provide an access to a private aggregated data and at the same moment hiding the underlying representation
      An iterator is Java is an object, and therefore it's implementation requires creating a class that implements the Iterator interface*/
    private class LinkedListIterator implements Iterator<T>{
        private Node<T> nextNode;

        public LinkedListIterator(){
            nextNode = head;
        }
        public boolean hasNext(){
            if(nextNode.next.equals(null)){
                return false;
            } else {
                return true;
            }
        }
        public T next(){
            if(!hasNext()){
                throw new NoSuchElementException("No element for next.");
            }
            T value = nextNode.data;
            nextNode = nextNode.next;
            return value;
        }
    }





}
