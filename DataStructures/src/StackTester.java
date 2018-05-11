public class StackTester {
    public static void main(String[] args){
        Stack<Integer> testStackInt = new Stack();
        testStackInt.push(3);
        testStackInt.push(9);
        testStackInt.push(-3);
        System.out.println("Initial stack: " + testStackInt.toString());
        System.out.println("Peeking at stack: " + testStackInt.peek());
        System.out.println("Popping off stack: " + testStackInt.pop());
        System.out.println("New length of stack: " + testStackInt.getSize());
        System.out.println("Stack now: " + testStackInt.toString());

        Stack<String> testStackString = new Stack();
        System.out.println("Initial size: " + testStackString.getSize());
        testStackString.push("Laptop");
        testStackString.push("Watch");
        System.out.println("New size: " + testStackString.getSize());
        System.out.println("Popping off stack: " + testStackString.pop());
        System.out.println("Popping off stack: " + testStackString.pop());
        System.out.println("Stack is empty: " + testStackString.isEmpty());
       // System.out.println("Popping off stack: " + testStackString.dequeue()); // Throws EmptyStackException


    }
}