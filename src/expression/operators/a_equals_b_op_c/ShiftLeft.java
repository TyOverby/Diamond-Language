package expression.operators.a_equals_b_op_c;

import expression.Operation;

/**
 * User: Ty
 * Date: 4/21/12
 * Time: 8:38 PM
 */
public class ShiftLeft extends AEqualsBOpC {
    public ShiftLeft(int startPos, String text) {
        super(startPos, text);
    }

    public ShiftLeft(Operation fakeOp) {
        super(fakeOp);
    }

    @Override
    protected String getIdentifier() {
        return "<<";
    }

    @Override
    protected String getOperatorName() {
        return "SHL";
    }
}
