package tree;
import list.*;
import Queue.*;

/** An iterator for BTs,
 * using an In Order traversal.
 * @author sdb& ig
 * @param <E>
 */
public class TreeIterator<E> implements Iterator<E>{
    BinaryTree<E> tree;
    //Contrustor
    E lastGotten; //returned by next()
    QueueADT<E> queue = new Queue<E>();

    TreeIterator(BinaryTree<E> tree){
        this.tree = tree;
        buildQ(tree);
    }

    //Add all values from tree
    // to the queue. Inorder.
    private void buildQ(BinaryTree<E> tree) {
        if(tree.isEmpty()) return;
        buildQ(tree.getLeft());
        queue.add(tree.getValue());
        buildQ(tree.getRight());
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    @Override
    public E next(){
        lastGotten = queue.remove();
        return lastGotten;
    }

    @Override
    public void remove() {
        if(lastGotten.equals(tree.getValue()) && //removing root
                tree.getLeft().isEmpty() != tree.getRight().isEmpty())
        { // 1 child
            BinaryTree<E> kid = tree.getLeft();
            if(kid.isEmpty()) {kid = tree.getRight();} // kid is the only child
                tree.setValue(kid.getValue());
                tree.setLeft(kid.getLeft());
                tree.setRight(kid.getRight());

        }else{
            tree = tree.remove(lastGotten);
        }
    }
}
