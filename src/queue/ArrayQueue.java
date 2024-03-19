package queue;
import list.*;
//ArrayQueue.java

/**
 * A QueueADT using an ArrayList.
 *
 * @author sbd & jtm
 */
public class ArrayQueue <E> implements QueueADT <E>
{
    List <E> list = new ArrayList <E> ();
    
    int front = 0;
    int back = 0;
    int size = 0; //size of queue
    
    public void add(E value)
    {
        if(size == list.size())
        {
            //insertion
            list.add(back, value);
            front = (front + 1) % list.size();
        }
        else
        {
            list.set(back, value);
        }
        back = (back + 1) % list.size();
        size++;
    }
    
    public E peek()
    {
        if (size == 0)
        {
            return null;
        }
        return list.get(front);
    }
    
    public E remove()
    {
        E result = list.get(front);
        front = (front +1) % list.size();
        size--;
        return result;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {
        size = 0;
        front = 0;
        back = 0;
    }

    @Override
    public int size() {
        return size;
    }

}
