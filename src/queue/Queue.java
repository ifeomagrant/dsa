package queue;
import list.*;
//Queue.java

/**
 * A QueueADT using a LinkedList
 *
 * @author sbd & jtm
 */
public class Queue <E> implements QueueADT <E>
{
    List <E> list = new LinkedList <E> ();
    
    public void add (E value)
    {
        list.add(value);
    }
    
    public E peek ()
    {
        if (list.isEmpty())
        {
            return null;
        }
        return list.get(0);
    }
    
    public E remove()
    {
        return list.remove(0);
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return list.size();
    }


    public String toString(){

        return list.toString();

    }

    @Override
    public void clear() {
        list.clear();
    }
}
