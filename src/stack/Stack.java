package stack;
import list.*;

/**
 * an implementation of the StackADT interface
 * @author sdb &____
 */

public class Stack<E> implements StackADT<E>{

    public Stack(boolean arrayBased){
        if(!arrayBased)
            list = new LinkedList<E>();
    }
    public Stack(){}
    List<E> list = new ArrayList<E>();

    @Override
    public E push(E value) {
        list.add(value);
        return value;
    }

    @Override
    public E peek() {
        return list.get(list.size() - 1);
    }

    @Override
    public E pop() {
        return
         list.remove(list.size()-1);
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {

    }
    /**
     * What are stacks used for?
     * undo in an office app
     * Undo in an office app
     * Runtime stack
     */

    /** when a method is called, Local variables and parameters.
     *    must be pushed onto a stack.
     *
     *    when method terminates the local variable, aparamterers are popped
     *    return addres is popped
     *    Return address is used to resume in the calling method
     */

    void mi(){
        int x = 4;
        m2();
        x=5;
        m3();
        x=6;
    }
    void m2(){
        int x=7;
        m3();
        x=8;
    }

    void m3(){
        int x = 9;
    }

    public String toString(){

        return list.toString();
    }








}
