package list;
// an iterator which goes in both direction. For Lists.
// @ author sdb & _____*/
public interface ListIterator<E> extends Iterator<E>{
    /** @ return true if there is a previous values */

    boolean hasPrevious();

    /** return previous value. pre: hasprevious() is true */
    E previous();

    /** Remove value returned by a call to next() or previous().
     Pre: next() or previous used called since last call to remove() */

    void remove();

    /** Insert the given value just prior to the implicit cursor position. A subsequent
     call to previous() should return the inserted value, and a subsequent call to next() should be
     unaffected.
     */

    void add(E value);
}
