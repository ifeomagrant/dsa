package tree;

/**
 * A BT with left child smaller, right child
 * larger, each nonEmpty is also a BST
 */

public class BST<E extends Comparable> implements BT<E>{
    E value;
    int size;
    static boolean added;
    BT <E> left = new EBST<E>();
    BT <E> right =  new EBST<E>();

    public BST(E value) {
        this.size = 1;
    }

    @Override
    public E getValue() {
        return value;
    }

    @Override
    public E get(E value) {
        int cmp = this.value.compareTo(value);
        if(cmp == 0) return this.value;
        if(cmp < 0) return right.get(value);
        return left.get(value);
    }

    @Override
    public boolean containsKey(Object obj) {
        try{
            E value = (E) obj;
            int cmp = this.value.compareTo(value);
            if(cmp == 0) return true;
            if(cmp < 0) return right.containsKey(obj);
            return left.containsKey(obj);
        }catch(Exception cce){
            return false;
        }
    }

    @Override


    public BT<E> add(E value){
        added =  false;
        return addHelper(value);
    }

    public BT<E> addHelper(E value){
        int cmp = this.value.compareTo(value);
        if(cmp < 0) right = right.add(value);
        if(cmp > 0) left = left.add(value);
        if(added) size++;
        return this;
    }


}
