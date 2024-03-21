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
        int mid = (start + end) / 2; // middle
        E pivot = list.get(mid); // Choose pivot as the mid

        list.set(mid, list.get(end)); // Move pivot to the end
        list.set(end, pivot);

        int p = start; // Index to track elements <= pivot

        for (int j = start; j < end; j++) {
            if (list.get(j).compareTo(pivot) < 0) { // If smaller than pivot
                // Swap list[p] and list[j]
                E temp = list.get(p);
                list.set(p, list.get(j));
                list.set(j, temp);
                p++;
            }
        }

        // Move pivot to its correct position
        list.set(end, list.get(p));
        list.set(p, pivot);
        return p;
    }




}