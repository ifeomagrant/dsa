package stack;

/**
 * A LIFO List
 * @author sdb&__
 * @param <E>
 */
public interface StackADT<E>{
    /** put the given value on top of this StackADT
     * return the value
     */

    E push(E value);
    /** @return value on top of this StackADT
     * Pre: This StackADT
     * is not empty
     */

    E peek();
    /** remove the top value
    from the StackADT.
     @return the value()
     PreL This StackADT is not empty
     */

    E pop();

    /** @return true iff this Stack is empty */
    boolean isEmpty();

    void clear();
}
