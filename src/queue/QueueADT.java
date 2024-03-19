package queue;
//QueueADT.java

/**
 * A FIFO List
 *
 * @author sbd & jtm
 */
public interface QueueADT <E>
{
    /**
     * Add the given value at
     * back of this QueueADT
     */
    void add(E value);
    
    /**
     * @return the value at 
     * front of this QueueADT
     * or null if empty
     */
    E peek();
    
    /**
     * Remove value at the front
     * of this QueueADT
     * @return value removed
     * pre: this QueueADT is not empty
     */
    E remove();
    
    //hw wk5
    /** @return true iff this Queue is empty 
    */
    boolean isEmpty();
    
    String toString();
    
    void clear();

    int size();
}
