package list;

public class RefIterator<E> implements Iterator<E>{
    /** An Iterator for LinkedLists @author sdb& ____
     * */

    LinkedList<E> list;
    Node<E> cursor;
    //cursor is a ref to the last
    //node obtained by next()

    RefIterator(LinkedList<E> list){
        this.list =list;
        cursor = list.head;
    }
    @Override
    public boolean hasNext() {
        return cursor.next != list.tail;
    }

    @Override
    public E next() {
        cursor = cursor.next;
        return cursor.value;
    }

    @Override
    public void remove() {
        cursor.prev.next = cursor.next;
        cursor.next.prev = cursor.prev;
        list.size--;
    }
    /** an object is recycled when there are no references to it. */
    
}
