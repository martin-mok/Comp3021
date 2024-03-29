import java.math.BigInteger;
import java.util.ArrayList;


/**
 * TODO 6: Define Division operation
 * It should be a subclass of Operation
 * Hint: refer to the Addition class to see how to implement this one.
 * Hint: BigInteger.ONE and BigInteger.divide(BigInteger) are useful
 * Note: if there is only one operand, return 1 / the operand (integer division). Otherwise divide
 * the first operand by the rest of operands.
 */

public class Division extends Operation{

    public Division(ArrayList<Expression> operands) {
        super("/", operands);
    }

    /**
     * TODO 6.1
     *
     * @return The result of the division
     */
    public BigInteger eval() {
        BigInteger sum = BigInteger.ONE;
        if(operands.size()==1){
            return sum.divide(operands.get(0).eval());
        }else {
            sum = operands.get(0).eval();
            for (int i = 1; i < operands.size(); i++) {
                sum=sum.divide(operands.get(i).eval());
            }
            return sum;
        }
    }

}