package tree;

public class Quotient extends Expr{
    public Quotient(Expr left, Expr right)
    {
        super(left, right);
    }
    @Override
    public int eval() {
        return left.eval() / right.eval();
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Sum))
            return false;
        Quotient other = (Quotient) obj; // x+y = x +y
        return left.equals(other.left)
                && right.equals(other.right); // x+y = y+x
    }

    @Override
    public Expr simplify() {
        left = left.simplify();
        right = right.simplify();

        if(right instanceof Constant && right.eval() == 1){ // 2-1
            return left;
        }
        if(left.equals(right)) // 2/2
            return new Constant(1);
        return this;
    }

    public String toString(){
        return "(" + left.toString() + "/" + right.toString() + ")";
    }
}
