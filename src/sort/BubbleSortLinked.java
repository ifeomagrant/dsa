package sort;
import list.*;

/**
 * Write a description of class BubbleSortLinked here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BubbleSortLinked<E extends Comparable> implements Sorter<E>
{
    List<E> list;
    
    public void sort(List<E> list)
    {
        this.list = list;
        E left, right;
        ListIterator<E> lit;
        
        for(int i =0; i < list.size(); i++)
        {
            lit = list.listIterator();
            right = lit.next();
            for(int j = 0; j < list.size()-i-1; j++)
            {
                left = right;
                right = lit.next();
                
                if(left.compareTo(right) > 0)
                {
                    lit.remove();
                    lit.previous();
                    lit.add(right);
                    lit.next();
                }
            }
        }
    }
}
