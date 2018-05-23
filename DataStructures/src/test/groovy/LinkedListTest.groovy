import Structures.LinkedList
import spock.lang.Specification

/**
 * Created by MikeS on 5/22/18.
 */
class LinkedListTest extends Specification {
    def "Test get populated list"(){
        given:
        Structures.LinkedList<Integer> linkedList = new Structures.LinkedList()
        when:
        linkedList.addFirst(3)
        linkedList.insertAfter(3,5)
        linkedList.insertBefore(5,6)
        then:
        linkedList.getSize() == 3
        linkedList.get(2) == 6
    }

    def "Test get empty LinkedList"(){
        given:
        Structures.LinkedList<Integer> linkedList = new Structures.LinkedList()
        when:
        linkedList.get(1)
        then:
        linkedList.getSize() == 0
        thrown IllegalAccessError
    }

    def "Test addFirst null head"(){
        given:
        Structures.LinkedList<Integer> linkedList = new Structures.LinkedList()
        when:
        linkedList.addFirst(3)
        then:
        linkedList.getSize() == 1
        linkedList.get(1) == 3
    }

    def "Test addFirst nonnull head"(){
        given:
        Structures.LinkedList<Integer> linkedList = new Structures.LinkedList()
        when:
        linkedList.addFirst(3)
        linkedList.addFirst(2)
        then:
        linkedList.getSize() == 2
        linkedList.get(0) == 2
        linkedList.get(1) == 3
    }

    def "Test addLast null head"(){
        given:
        Structures.LinkedList<Integer> linkedList = new Structures.LinkedList()
        when:
        linkedList.addLast(3)
        then:
        linkedList.getSize() == 1
        linkedList.get(0) == 3
    }

    def "Test addLast nonnull head"(){
        given:
        Structures.LinkedList<Integer> linkedList = new Structures.LinkedList()
        when:
        linkedList.addFirst(16)
        linkedList.addLast(20)
        then:
        linkedList.getSize() == 2
        linkedList.get(0) == 16
        linkedList.get(1) == 20
    }

    def "Test insertBefore null head"(){
        given:
        Structures.LinkedList<Integer> linkedList = new Structures.LinkedList()
        when:
        linkedList.insertBefore(3,4)
        then:
        thrown IllegalArgumentException
    }

//    def "Test insertBefore nonnull head"(){
//        given:
//        Structures.LinkedList<Integer> linkedList = new Structures.LinkedList()
//        when:
//        linkedList.addFirst(16)
//        linkedList.addLast(20)
//        linkedList.insertBefore(20,2)
//        then:
//        linkedList.getSize() == 3
//        linkedList.get(0) == 16
//        linkedList.get(1) == 2
//        linkedList.get(2) == 2
//    }

    def "Test insertAfter null head"(){

    }

    def "Test insertAfter nonnull head"(){

    }

    def "Test remove null head"(){

    }

    def "Test remove nonnull head"(){

    }

    def "Test reverse"(){
        
    }

}
