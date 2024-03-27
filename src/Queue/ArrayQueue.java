package Queue;
import list.*;
//ArrayQueue.java

/**
 * A QueueADT using an ArrayList.
 *
 * @author sbd & ----
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
    
    //hw wk5
    public boolean isEmpty()
    {
        return size == 0;
    }

    public String toString()
     {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(list.get((front + i) % list.size()));
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public void clear() {
        front = 0;
        back = 0;
        size = 0;
        list.clear();
    }
    
    public int size(){
        return size;//testing 2.19
    }
}