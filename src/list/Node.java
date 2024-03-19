package list;
//Node.java source file

/**
 * A Node has a value,
 * and references to two other nodes.
 * @author sbd & jtm
 */
class Node <E>
{
    //default class because can be accessed from any class in package
    E value;
    Node<E> next;
    Node<E> prev;

    //constructor
    Node(E value, Node<E> next, Node<E> prev)
    {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }


}
