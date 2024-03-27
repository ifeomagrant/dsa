package tree;
/** A sum represents addition of Expr */

public class Sum extends Expr{
    public Sum(Expr left, Expr right){
        super(left,right);
    }
    @Override
    public int eval() {
        return left.eval() + right.eval();
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Sum))
            return false;
        Sum other = (Sum) obj; // x+y = x +y
        return left.equals(other.left)
                && right.equals(other.right)
                || left.equals(other.right) && right.equals(other.left); // x+y == y+x

    }

    @Override
    public Expr simplify() {
        left = left.simplify();
        right = right.simplify();
        if(left instanceof Constant && left.eval() == 0) // 0+x =x
            return right;
        if(right instanceof Constant && right.eval() == 0){ // x +0 = x
            return left;
        }
        return this;
    }

    public String toString(){
        return "(" + left.toString() + "+" + right.toString() + ")";
    }
}
