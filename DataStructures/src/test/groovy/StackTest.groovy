
/**
 * Created by MikeS on 5/15/18.
 */
class StackTest extends spock.lang.Specification {
    def "Test isEmpty empty stack"() {
        given:
        Structures.Stack<Integer> stack = new Structures.Stack();
        expect:
        stack.isEmpty()
    }

    def "Test isEmpty nonempty stack"() {
        given:
        Structures.Stack<Integer> stack = new Structures.Stack();
        when:
        stack.push(3)
        then:
        !stack.isEmpty()
    }

    def "Test getSize for size > 0"(){
        given:
        Structures.Stack<String> stack = new Structures.Stack();
        when:
        stack.push("Foo")
        stack.push("Bar")
        then:
        stack.getSize() == 2
    }

    def "Test getSize for size == 0"(){
        given:
        Structures.Stack<String> stack = new Structures.Stack();
        expect:
        stack.getSize() == 0
    }

    def "Test push"(){
        given:
        Structures.Stack<Long> stack = new Structures.Stack();
        when:
        stack.push(3l)
        stack.push(16l)
        then:
        stack.peek() == 16l
        stack.getSize() == 2
        !stack.isEmpty()
    }


    def "Test pop"(){
        given:
        Structures.Stack<Integer> stack = new Structures.Stack();
        when:
        stack.push(10);
        stack.push(20);
        def val1 = stack.pop()
        then:
        val1 == 20
        stack.peek() == 10
        stack.size == 1
        !stack.isEmpty()
    }

    def "Test peek valid queue"(){
        given:
        Structures.Stack<Character> stack = new Structures.Stack();
        when:
        stack.push('b');
        then:
        stack.peek().equals('b')
    }

    def "Test peek empty queue"(){
        given:
        Structures.Stack<Integer> stack = new Structures.Stack();
        when:
        stack.peek()
        then:
        thrown NoSuchElementException
    }

}
