package tree;

//EmptyBinarySearchTree.java

/**
 * A BinaryTree with no value, no children
 *
 * @author sbd & jtm
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
    
    //here i need to add homework
    
    //tuesday
    public BinaryTree <E> remove (Object obj)
    {
        return new EmptyBinarySearchTree <E> ();
    }
}
