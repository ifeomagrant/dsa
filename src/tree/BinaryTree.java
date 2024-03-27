package tree;


import list.Iterator;

/**
 * A BinaryTree may have a value, and at most
 * two children, each of which is a BinaryTree
 *
 */
public interface BinaryTree <E>
{
    /**
     * @return the value of this BinaryTree,
     * or null is it has none
     */
    E getValue();//this one return the value of whoever we are talking to

    /**
     * Search the family of this BinaryTree
     * for th given value.
     * @return that value, or null if not found
     */
    E get(E value);//this one returns the value after searching the BT

    /**
     * @return true iff given obj
     * is in this BinaryTree's family
     */
    boolean containsKey(Object obj);

    /**
     * Add the given value to this BinaryTree's family
     * @return the updated BinaryTree.
     */
    BinaryTree <E> add(E value);

    //homework wk9
    /**
     * @return the left child of this BinaryTree 
    */
    BinaryTree<E> getLeft();

    /** 
     * @return the right child of this BinaryTree 
    */
    BinaryTree<E> getRight();

    /**
     * @return the size of this BinaryTree's family
    */
    int size();

    /**
     * @return true iff this BinaryTree is empty
    */
    boolean isEmpty();

    /** 
     * Set the value of this BinaryTree to the given value 
    */
    void setValue(E value);

    /** 
     * Set the left child of this BinaryTree to the given BinaryTree 
    */
    void setLeft(BinaryTree<E> left);

    /** 
     * Set the right child of this BinaryTree to the given BinaryTree
    */
    void setRight(BinaryTree<E> right);
    
    //must implement above in other classes.
    /**
     * Remove the given Object from this BinaryTree's Family, if possible
     * @return the resulting BinaryTree.
     */
    BinaryTree <E> remove(Object obj);

    Iterator<E> iterator();
}

