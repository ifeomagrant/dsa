package list;
//feb 6th, 2024
/**
 * A ListIterator for LinkedLists.
 *
 * @author sbd & jtm
 */
class RefListIterator <E> extends RefIterator <E> implements ListIterator <E>
{
    //super.cursor is a ref to last
    //value obtained by next() or prev()
    boolean forward = true;

    //constructors
    RefListIterator (LinkedList <E> list)
    {
        super(list);
    }

    //start is the starting position for iterating
    RefListIterator (LinkedList <E> list, int start)
    {
        super(list);
        for (int i = 0; i < start; i++)
        {
            cursor = cursor.next;
        }
    }

    public boolean hasNext()
    {

        
        //try this instead
        if(list.isEmpty())
        {
            return false;
        }
        if(forward)
        {
            return cursor.next != list.tail;
        }
        return true;
    }
    
    public E next()
    {
        if (forward)
        {
            cursor = cursor.next;
        }
        forward = true;
        return cursor.value;
        //this is a simplier version...
    }
    
    public boolean hasPrevious()
    {
        if(! forward)
        {
            return cursor.prev != list.head;
        }
        return cursor != list.head;
    }
    
    public E previous ()
    {
        if(! forward)
        {
            cursor = cursor.prev;
        }
        forward = false;
        return cursor.value;
    }
    
    public void remove()
    {
        super.remove(); //using this tells us what was the last call
        if(forward)
        {
            cursor = cursor.prev;
        }
        else
        {
            cursor = cursor.next;
        }
    }
    
    //lab 4
    public void add(E value)
    {
        if(forward)
        {
            Node <E> newNode = new Node (value, cursor.next, cursor);
            cursor.next.prev = newNode;
            cursor.next = newNode;
            cursor = cursor.next;
        }
        else
        {
            Node <E> newNode = new Node (value, cursor, cursor.prev);
            cursor.prev.next = newNode;
            cursor.prev = newNode;
        }
        list.size++;
    }
}
