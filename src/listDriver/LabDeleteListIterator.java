package listDriver;
import list.*;

/**
 * 
 * @author (sdb and PUT YOUR NAME HERE!) 
 * @version (Feb 2018)
 */
public class LabDeleteListIterator
{
    
    static List <Student> roster;
    
    public static void main(String [] args)
    {   roster = new ArrayList<Student>();
        test();
        roster = new LinkedList<Student>();
        test();


    }
    
    private static void init()
    {
        deleteFirstOfDup();
        roster.add (new Student ("mike", 2345));
        deleteFirstOfDup();
        roster.add (new Student ("jim", 2222));
        roster.add (new Student ("joseph", 2345));
        roster.add (new Student ("joe", 2345));
        roster.add (new Student ("mary", 3333));
        roster.add (new Student ("maryLou", 3333));
        System.out.println("Before deletions " + roster);
    }
    
    private static void test()
    {   
        init();
        deleteFirstOfDup();
        if (roster.size() != 5)
            System.err.println ("Deletion is incorrect");
        System.out.println ("Roster is " + roster);
    }
    
    /** Search the roster for the first pair of neighbors which are
     *  equal.  Delete the first member of that pair.
     */
    private static void deleteFirstOfDup()
    {   ///////////  PUT YOUR CODE HERE ///////////////
        ListIterator<Student> leftiterator = roster.listIterator();
        int leftNDX = 0;
        int rightNDX = 0;

        while(leftiterator.hasNext()){
            Student left = leftiterator.next();
            rightNDX = leftNDX + 1;
            ListIterator<Student> rightIterator = roster.listIterator(rightNDX);
            leftNDX++;

            //while(rightIterator.hasNext()){
                Student right = rightIterator.next();

                if(left.equals(right)){

                    leftiterator.remove();
                    return;
               // }

            }


        }

        
    
    }

    
    
        
        
}
