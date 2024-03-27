package tree;

//EmptyBinarySearchTree.java

import list.Iterator;

/**
 * A BinaryTree with no value, no children
 *
 */
public class EmptyBinarySearchTree <E extends Comparable> implements BinaryTree <E>
{
    public E getValue()
    {
        return null;
    }
    
    public E get(E value)
    {
        return null;
    }
    
    public boolean containsKey(Object obj)
    {
        return false;
    }
    
    public BinaryTree <E> add(E value)
    {
        BinarySearchTree.added = true;
        return new BinarySearchTree <E> (value);
    }

    @Override
    public BinaryTree<E> getLeft() {
        return null;
    }

    @Override
    public BinaryTree<E> getRight() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    public boolean isEmpty() {
        return true;
    }

    @Override
    public void setValue(E value) {

    }

    @Override
    public void setLeft(BinaryTree<E> left) {

    }

    @Override
    public void setRight(BinaryTree<E> right) {

    }

    //here i need to add homework
    
    //tuesday
    public BinaryTree <E> remove (Object obj)
    {
        return new EmptyBinarySearchTree <E> ();
    }
    public Iterator<E> iterator(){ return new TreeIterator<E>(this);}

}
