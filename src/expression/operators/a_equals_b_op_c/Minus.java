package expression.operators.a_equals_b_op_c;

import expression.Operation;

/**
 * User: Ty
 * Date: 4/21/12
 * Time: 8:32 PM
 */
public class Minus extends AEqualsBOpC {
    public Minus(int startPos, String text) {
        super(startPos, text);
    }

    public Minus(Operation fakeOp) {
        super(fakeOp);
    }

    @Override
    protected String getIdentifier() {
        return "-";
    }

    @Override
    protected String getOperatorName() {
        return "SUB";
    }
}
