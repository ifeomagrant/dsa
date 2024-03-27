package list;

public interface Iterator<E> {
    /**
     * Why Iterators?
     * Allow you to visit all values in a collection (list, Set)
     * Allow you to remove values selectively.
     */

    /**
     *  [a,b,c,d]
     * next() -> a
     * next() -> b
     * next() -> c
     * next() -> d
     * next() -> X Error
     * hasNext() -> false
     */

    /** iterator.java
     * package list;
     * Permit iteration
     * through a Collection
     * @author solb & ___
     * */

    /** @return true if there are more values */
    boolean hasNext();

    /** @return the next value from the collection
     * Pre: hasNext() is true
     */
    E next();

    /** Remove the last value obtained by next() from the Collection.
     * Pre: Next was called at least once since last call to remove()
     */

    void remove();
}
