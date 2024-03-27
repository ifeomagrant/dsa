package tree;

public abstract class Expr {
    /** An Expression may have two operands each of which is an Expression
     * @author sdb & ife
     */
    Expr left, right;
    public Expr(Expr left, Expr right){
        this.left = left;
        this.right = right;
    }

    /** @ return the int of an Expression if possible
     *
     */

    public abstract  int eval();

    /** @ return true iff this Expression equals obj
     *
     */

    public abstract boolean equals(Object obj);

    /** return a simplified version of this expression
     *
     */

    public abstract Expr simplify();
}
