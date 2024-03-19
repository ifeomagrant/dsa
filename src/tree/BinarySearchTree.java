package tree;
import list.*;
/**
 * A BinaryTree with left child smaller, right child larger,
 * each nonEmpty is also a BinarySearchTree.
 *
 * @author sbd & jtm
 */
public class BinarySearchTree <E extends Comparable> implements BinaryTree <E>
{
    E value;
    BinaryTree <E> left = new EmptyBinarySearchTree <E> ();
    BinaryTree <E> right = new EmptyBinarySearchTree <E> ();
    int size = 1;
    static boolean added;
    //constructor
    public BinarySearchTree(E value)
    {
        this.value = value;
    }

    public E getValue()
    {
        return value;
    }

    public E get(E value)
    {
        int cmp = this.value.compareTo(value);

        if(cmp == 0)
        {
            return this.value;
        }

        if(cmp < 0)
        {
            return right.get(value);
        }

        return left.get(value);
    }

    public boolean containsKey(Object obj)
    {
        try
        {
            E value = (E) obj; //casting
            int cmp = this.value.compareTo(value);

            if(cmp == 0)
            {
                return true;
            }
            if(cmp < 0)
            {
                return right.containsKey(obj); //can try value instead if doesnt work
            }
            return left.containsKey(obj);
        }
        catch (ClassCastException cce)
        {
            return false;
        }
    }

    public BinaryTree <E> add (E value)
    {
        added = false;
        return addHelper(value);
    }

    private BinaryTree <E> addHelper (E value)
    {
        int cmp = this.value.compareTo(value);
        if(cmp < 0)
        {
            right = right.add(value);
        }
        if(cmp > 0)
        {
            left = left.add(value);
        }
        if(added) {
            size++;
        }
        return this;
    }
    
    //also have to add homework

    //tuesday
    static boolean removed;
    public BinaryTree <E> remove (Object obj)
    {
        try
        {
            removed = false;
            E value = (E) obj;
            return removeHelper(value);
        }

        catch(ClassCastException cce)
        {
            return this;
        }
    }

    private BinaryTree <E> removeHelper (E value)
    {
        int cmp = this.value.compareTo(value);
        if(cmp == 0) //found it
        {
            List <BinaryTree<E>> kids = children();
            if(kids.size() == 0)
            {
                return new EmptyBinarySearchTree <E> ();
            }
            if(kids.size() == 1)
            {
                return kids.get(0);
            }

            //two children
            BinaryTree <E> successor = getSuccessor();
            removeHelper(successor.getValue());
            this.value = successor.getValue();
            return this;
        }
        if (cmp < 0) 
        {
            right = right.remove(value);
        }
        if (cmp > 0) 
        {
            left = left.remove(value);
        }
        if(removed)
        {
            size--;
        }
        return this;
    }
    
    private List <BinaryTree<E>> children ()
    {
        List<BinaryTree<E>> result = new ArrayList <BinaryTree<E>> (); 
        //our choice don't matter 'cuz size max is 2
        if(!left.isEmpty()) 
        {
            result.add(left);
        }
        if(!right.isEmpty()) 
        {
            result.add(right);
        }
    }
    
    //return the successor of this BinaryTree
    private BinaryTree<E> getSuccessor (){
        BinaryTree <E> result = right;
        while(!result.getLeft().isEmpty())
        {
            result = result.getLeft();
        }
        return result;
    }
}

