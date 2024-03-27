package sort;
import list.*;

/** Binary Search Algorithm. use a sorted9ascending) ArrayList.
 * ArrayList
 */
public class BinarySearch<E extends Comparable>{
    List<E> list;
    E target;

    public BinarySearch(List<E> list){
        this.list = list;

    }

    public int search(E target) {
        this.target = target;
        return binSrch(0, list.size() - 1);
    }

    /**return position of target, or -1 if not found search from start than end */

    private int binSrch(int start, int end){
        if(start > end)
            return -1; // not found
        int mid = (start + end) /2;
        int emp = target.compareTo(list.get(mid));
        if(emp == 0) return mid; //found it
        if(emp < 0) return binSrch(start, mid -1); // left part
        return binSrch(mid + 1, end);

    }





}
