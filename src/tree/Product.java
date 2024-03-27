package tree;
//Expr.java

/**
 * A Productm multiplication,
 * has two operands
 *
 * @author sbd & jtm
 */
public class Product extends Expr
{
    //constructor
    public Product(Expr left, Expr right)
    {
        super(left, right);
    }
    
    public int eval()
    {
        return left.eval() * right.eval();
    }
    
    public boolean equals (Object obj)
    {
        if(!(obj instanceof Product))
        {
            return false;
        }
        Product other = (Product) obj;
        return left.equals(other.left) //x * y = x * y
        && right.equals(other.right)
        || right.equals(other.left) //x * y = y * x
        && left.equals(other.right);
    }
    
    public Expr simplify()
    {
        left = left.simplify();
        right = right.simplify();
        if(left instanceof Constant && left.eval() == 0) //0 * x = 0
        {
            return new Constant(0); //or left, same thing
        }
        if(right instanceof Constant && right.eval() == 0)//x * 0 = 0
        {
            return right;
        }
        if(left instanceof Constant && left.eval() == 1)
        {
            return right;
        }
        if(right instanceof Constant && right.eval() == 1)
        {
            return left;
        }
        return this;
    }
    
    public String toString()
    {
        return "(" + left.toString() + "*" + right.toString() + ")";
    }
}
