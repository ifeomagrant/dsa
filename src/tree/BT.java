package tree;

/** A BinaryTree may have a value, and at most two children, each of which is a BT.
 * @author sdb&____
 */
public interface BT<E>{
    /**
     * @return the balue of BT,
     * or null if it has none
     */

    E getValue();

    /** Search the family of this BT for the given value
     * @ return that value, or null if not found
     * @param value
     * @return
     */
    E get(E value);

    /** @ return true if given object is in this BT's family
     *
     */

    boolean containsKey(Object obj);

    /** Add the given value to this binary tre's family
     * return a reference to the updated BT
     */

    BT<E> add(E value);




}
