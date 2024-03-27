package tree;

public class Difference extends Expr{
    public Difference(Expr left, Expr right)
    {
        super(left, right);
    }
    @Override
    public int eval() {
        return left.eval() - right.eval();
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Difference))
            return false;
        Difference other = (Difference) obj; // x+y = x +y
        return left.equals(other.left)
                && right.equals(other.right); // x+y = y+x
    }

    @Override
    public Expr simplify() {
        left = left.simplify();
        right = right.simplify();
        if(left instanceof Constant && left.eval() == 0) // 0-2 = -2
            return new Constant(right.eval() * -1);
        if(right instanceof Constant && right.eval() == 0){ // x +0 = x
            return right;
        }
        return this;
    }

    public String toString(){
        return "(" + left.toString() + "-" + right.toString() + ")";
    }
}
