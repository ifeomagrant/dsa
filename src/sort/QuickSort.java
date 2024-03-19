package sort;
import list.*;

/**QuickSort algorithm use an ArrayList @ author sdb &z___*/

public class QuickSort < E extends Comparable> implements Sorter<E>{
    List<E> list;

    public void sort(List<E> list){
        this.list = list;
        qSort(0, list.size() - 1);
    }

    /** Sort the portion of the list from start through end */

    private void qSort(int start, int end){
        if(end -start < 1) return; // base case.
        int p = partition(start, end);
        qSort(start, p-1);

        qSort(p+1, end);
    }

    /** Choose a value as pivot, [start position] position p.
     * Post: All values to the left of Pivot are smaller.
     * All values to the right of Pivot are greater or equal to pivot.
     * @return Position of Pivot.
     */

    private int partition(int start, int end) {
        int p = start; // Pivot position
        E pivot = list.get(p);

        for (int i = start + 1; i <= end; i++) //smaller
        {
            if (list.get(i).compareTo(pivot) < 0) {
                list.set(p, list.get(i));
                p++;
                list.set(i, list.get(p));
            }
        }

            list.set(p, pivot);
            return p;

    }
}