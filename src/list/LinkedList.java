package list;

/**
 * A List implemented with references.
 * @author sbd
 */
public class LinkedList<E> implements List<E>
{
    int size = 0;
    Node<E> head = new Node<E>(null, null,null);
    Node<E> tail = new Node<E>(null, null, head);
    private Node<E> ref;
    //constructor
    public LinkedList()
    {
        head.next = tail;
    }

    public E get (int ndx)
    {
        setRef(ndx);
        //ref refers to Node
        //at position ndx
        return ref.value;
    }

    //post condition: refe refers to node at position ndx
    private void setRef(int ndx)
    {
        ref = head.next; //Node at position 0
        for(int i=0; i<ndx; i++)
        {
            ref= ref.next;
        }
    }

    public E set(int ndx, E value)
    {
        setRef(ndx);
        E result = ref.value;
        ref.value = value;
        return result;
    }

    public void add(E value)
    {
        Node<E> temp = new Node<E> (value, tail, tail.prev);
        tail.prev.next = tail.prev = temp;
        size++;
    }

    public void add(int ndx, E value)
    {
        setRef(ndx);
        Node<E> temp = new Node<E> (value,ref, ref.prev);
        ref.prev.next = temp;
        ref.prev = temp;
        size++;
    }

    public E remove (int ndx)
    {
        setRef(ndx);
        ref.prev.next = ref.next;
        ref.next.prev = ref.prev;
        size--;
        return ref.value;
    }

    public int size()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public void clear()
    {
        head.next = tail;
        tail.prev = head;
        size = 0;
    }
 // ToDo
    @Override
    public int indexOf(Object obj){
        ref = head.next; // position zero

            for(int ndx= 0; ndx < size; ndx++){
                if(ref.value.equals(obj)) {
                    return ndx;
                }
                ref = ref.next;
            }

        return -1;
    }


    @Override
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        ref = head.next;
        for (int i = 0; i < size(); i++) {
            sb.append(ref.value);
            ref =ref.next;
            if (i < size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
    public Iterator<E> iterator(){
        return new RefIterator<E>(this);  // Under construction
    }

    @Override
    public ListIterator<E> listIterator() {
        return new RefListIterator<E>(this);
    }

    @Override
    public ListIterator<E> listIterator(int start) {
        return new RefListIterator<E>(this, start);
    }

    @Override
    public boolean remove(Object obj) {
        ListIterator<E> iterator = listIterator();
        while(iterator.hasNext()){
            if(iterator.next().equals(obj)){
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj){
        if(obj instanceof List){
            if(((List<?>) obj).size() == size){
                ListIterator<?> iteratorOne = ((List<?>) obj).listIterator();
                ListIterator<E> iteratorTwo = listIterator();
                while(iteratorOne.hasNext()){
                    if(! (iteratorOne.next().equals(iteratorTwo.next()))){
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    /** @return a List in which the values of this List are in reverse order.
     */
    public List<E> reversed(){
        size = size -1;
        LinkedList<E> reversedList = new LinkedList<E>();

        for(int ndx = 0; ndx < size; ndx++){
            E obj = get(size);
            reversedList.add(obj);
            size--;
        }

        return reversedList;
    }




}
