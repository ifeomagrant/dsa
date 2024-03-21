package sort;
import list.*;

/**
 * Write a description of class BubbleSort here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BubbleSort<E extends Comparable> implements Sorter<E>
{
  List<E> list;

    public void sort (List <E> list)
    {
        this.list = list;

        for(int i = 0; i < list.size() - 1; i++)
        {
            boolean swapped = false;
            for(int j = 0; j < list.size() - i - 1; j++)
            {
                if (list.get(j).compareTo(list.get(j+1)) > 0)
                {
                    swap(j, j+1);
                    swapped = true;
                }
            }
            if(!swapped)
            {
                break;
            }
        }
    }
    
    private void swap(int x, int y)
    {
	E temp = list.get(x);
	list.set(x, list.get(y));
	list.set(y,temp);
    }

 
}
