package recursion;

import list.List;

public class recursion {

    int j;
    /** @return the integer quotient when x is divided by y, using recursion.
     @param x is not negative, y is positive
     */
    int div(int x, int y) {
        if (y < 1 || x < y) {
            return 0;
        } else {
            return 1 + div(x - y, y);
        }
    }

    void m1(int x)
    {     for (int i=0; i< x; i++)
        for (j=0; j<10000000; j++)
            System.out.println (x+j);
    }

    void m2(List<Character> chars)
    {   for (int i=0; i<chars.size(); i++)
        System.out.print (chars.get(i));
    }
}
