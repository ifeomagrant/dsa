package sort;
import list.*;

/**
 * Write a description of class SelectionSort here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SelectionSort<E extends Comparable> implements Sorter<E>
{
    List<E> list;
    
    public void sort(List<E> list)
    {
        this.list = list;
        
        for(int i = 0; i < list.size()-1; i++)
        {
            swap(i, posSmallest(i));
        }
    }
    
    private int posSmallest(int start)
    {
       
        int result = start;
       
        for(int i =  start + 1; i < list.size(); i++)
        {
            if(list.get(i).compareTo(list.get(result))<0)
            {
                result = i;
                
            }
        }
        return result;
    }
    
   private void swap(int x, int y)
    {
	E temp = list.get(x);
	list.set(x, list.get(y));
	list.set(y,temp);
    }

    
    
}
