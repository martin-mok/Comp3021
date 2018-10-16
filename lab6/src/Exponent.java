import java.math.BigInteger;
import java.util.ArrayList;


/**
 * TODO 7: Define Exponent operation
 * It should be a subclass of Operation
 * Hint: BigInteger.pow(int)
 */

public class Exponent extends Operation {

    public Exponent(ArrayList<Expression> operands) {
        super("^", operands);
    }

    /**
     * TODO 7.1
     *
     * @return The result of the exponentiation
     */
    public BigInteger eval() {
        BigInteger sum = operands.get(0).eval();
        for (int i=1;i<operands.size();i++) {
            sum=sum.pow(operands.get(i).eval().intValue());
        }
        return sum;
    }

}