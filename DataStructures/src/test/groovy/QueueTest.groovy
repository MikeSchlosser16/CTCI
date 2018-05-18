/**
 * Created by MikeS on 5/15/18.
 */
class QueueTest extends spock.lang.Specification {
    def "test isempty"() {
        given:
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        expect:
        stack.isEmpty() == false
    }
}
