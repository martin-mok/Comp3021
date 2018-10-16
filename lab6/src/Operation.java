import java.util.ArrayList;


/**
 * TODO 3: Define the abstract class Operation
 * it should be a subclass of Expression
 */

public abstract class Operation extends Expression{
    protected String operator;
    protected ArrayList<Expression> operands;

    protected Operation(String operator, ArrayList<Expression> operands) {
        super();
        this.operator = operator;
        this.operands = operands;
    }

    /**
     * TODO: 3.1
     * An operation has a operator and multiple operands
     * Override the toString method to convert the operation to a string.
     * The format is "(operator operand1 operand2 operand3 ...)".
     * E.g.
     * If the operator is "+", and the operands are "2, 3, 5".
     * Then the string representation of this operation is (+ 2 3 5).
     *
     * @return the string representation of the operation
     */
    @Override
    public String toString() {
        String tobereturn= "("+this.operator;
        for(int i=0;i<this.operands.size();i++){
            tobereturn+=" "+this.operands.get(i);
        }
        tobereturn+=")";
        return tobereturn;
    }

}