package list;
//List.java

/**
 * An ordered collection.
 * @author
 */
public interface List <E>
{
    /**
     * @param  0 <= ndx
     * @return value at give ndx < size
     */
    E get (int ndx);

    /**
     * Change value at given ndx to given value
     * @return old value
     * @param 0 <= ndx < size
     */
    E set(int ndx, E value);

    /**
     * Add given value at end of this List
     */
    void add(E value);

    /**
     * Insert given value at given ndx
     * @param 0 <= ndx <= size
     */
    void add(int ndx, E value);

    /**
     * Remove the value at the given ndx
     * @return value removed
     * @param 0 <= ndx < size
     */
    E remove(int ndx);

    //hw
    /**
     * @return the size of this List
     */
    int size();

    /**
     * @return true iff this List is empty
     */
    boolean isEmpty();

    /**
     * Clear this List
     */
    void clear();
    /** @return the index of the given object in this List, or -1 if not found */
    int indexOf(Object obj);

    /** @return true iff this List contains the given object */
    boolean contains(Object obj);

    /**
     * Return an Iterator for this list
     */

    Iterator<E> iterator();

    /** return a ListIterator
     * for this list
     */
    ListIterator<E> listIterator();

    /** @ return a ListIterator
     * for this list, starting at
     * given start position
     */

    ListIterator<E> listIterator(int start);

    /** Remove the first occurrence of obj from this List, if possible.
     @return true iff the object was removed
     */
    boolean remove (Object obj);

}
