package list;
//ArrayListIterator.java

/**
 * A ListIterator for ArrayLists
 *
 * @author
 */
class ArrayListIterator<E> extends ArrayIterator <E> implements ListIterator<E>
{
    //implicit cursor is between
    //positions ndx, ndx+1
    
    //constructor
    
    boolean forward = true;
    
    ArrayListIterator(List <E> list)
    {
        super(list);
    }
    
    /**
     * Given a start position,
     * start = 0 => start at the beginning
     * start = size => start at the end
     */
    ArrayListIterator(List <E> list, int start)
    {
        super(list);
        ndx = start -1;
    }
    
    //most methods are already in the superclass
    
    public boolean hasPrevious()
    {
        return ndx >= 0;
    }
    
    public E previous()
    {
        forward = false;
        ndx--;
        return list.get(ndx + 1);
    }
    
    public E next(){
        forward = true;
        return super.next();
    }
    
    public void remove()
    {
        //we don't really know which one but whichever was in the last call
        //remember which way we are going
        if(forward)
        {
            //if(forward) is already a boolean = true
            ndx--;
        }
        list.remove(ndx + 1); //going backwards
    }
    
    //lab 4
    public void add(E value)
    {
        list.add(ndx + 1, value);
        ndx++;
    }
}
