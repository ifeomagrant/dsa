package list;

import java.util.Arrays;

public class ArrayList<E> implements List<E> {
    int size = 0;
    E[] values;

    //Constructor
    public ArrayList(int cap)
    {
        // initialise instance variables
        values = (E[]) new Object[cap];
    }

    public ArrayList()
    {
        this(10);
    }

    public E get(int ndx)
    {
        return values[ndx];
    }

    public E set(int ndx, E value)
    {
        E result = values[ndx];
        values[ndx] = value;
        return result;
    }

    public void add(E value)
    {
        add(size, value);
    }

    public void add(int ndx, E value)
    {
        if(size == values.length)
        {
            alloc();  //only called if out of space in array
        }
        for(int i = size; i > ndx; i--)
        {
            values[i] = values[i-1];
        }
        values[ndx] = value;
        size++;
    }

    private void alloc()
    {
        //allocate a bigger array
        E[] temp = (E[]) new Object[ 2 * values.length];

        if (size >= 0) System.arraycopy(values, 0, temp, 0, size);
        values = temp;
    }

    public E remove(int ndx)
    {
        E result = values[ndx];
        for(int i = ndx; i < size -1; i++)
        {
            values[i] = values[i+1];
        }
        size--;
        return result;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void clear() {
        size = 0;
    }

    public int indexOf(Object obj) {
        for (int i = 0; i < size; i++) {
            if (get(i).equals(obj)) {
                return i;
            }
        } return -1;
    }

    public boolean contains(Object obj){
        return indexOf(obj) != -1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size(); i++) {
            sb.append(get(i));
            if (i < size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public Iterator<E> iterator(){
        return new ArrayIterator<E>(this);
    }

    public ListIterator<E> listIterator(){
        return new ArrayListIterator<>(this);
    }

    public ListIterator<E> listIterator(int start){
        return new ArrayListIterator<E>(this, start);
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



    /** @return true iff the given Object is a List and this List is equal to the given List. */
    public boolean equals(Object obj)
    {

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


}
