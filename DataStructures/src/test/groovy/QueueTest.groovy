/**
 * Created by MikeS on 5/15/18.
 */


class QueueTest extends spock.lang.Specification {
    def "Test isEmpty empty Structures.Stack"() {
        given:
        Structures.Queue<Integer> queue = new Structures.Queue();
        expect:
        queue.isEmpty()
    }

    def "Test isEmpty nonempty Structures.Stack"() {
        given:
        Structures.Queue<Integer> queue = new Structures.Queue();
        when:
        queue.enqueue(3)
        then:
        !queue.isEmpty()
    }

    def "Test getSize for size > 0"(){
        given:
        Structures.Queue<String> queue = new Structures.Queue();
        when:
        queue.enqueue("Foo")
        queue.enqueue("Bar")
        then:
        queue.getSize() == 2
    }

    def "Test getSize for size == 0"(){
        given:
        Structures.Queue<String> queue = new Structures.Queue();
        expect:
        queue.getSize() == 0
    }

    def "Test enqueue"(){
        given:
        Structures.Queue<Long> queue = new Structures.Queue();
        when:
        queue.enqueue(3l);
        queue.enqueue(16l);
        then:
        queue.peek() == 3l;
        queue.size == 2;
        !queue.isEmpty();
    }


    def "Test dequeue"(){
        given:
        Structures.Queue<Integer> queue = new Structures.Queue();
        when:
        queue.enqueue(10);
        queue.enqueue(20);
        def val1 = queue.dequeue()
        then:
        val1 == 10;
        queue.peek() == 20;
        queue.size == 1;
        !queue.isEmpty();
    }

    def "Test peek valid queue"(){
        given:
        Structures.Queue<Character> queue = new Structures.Queue();
        when:
        queue.enqueue('b');
        then:
        queue.peek().equals('b')
    }

    def "Test peek empty queue"(){
        given:
        Structures.Queue<Integer> queue = new Structures.Queue();
        when:
        queue.peek()
        then:
        thrown NoSuchElementException
    }



}
