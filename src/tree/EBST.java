package tree;
/** A BT with no value, no children
 *
 */
public class EBST<E extends Comparable> implements BT<E>{

    @Override
    public E getValue() {
        return null;
    }

    @Override
    public E get(E value) {
        return null;
    }

    @Override
    public boolean containsKey(Object obj) {
        return false;
    }


    public BT<E> add(E value) {
        BST.added = true;
        return new BST(value);
    }
}