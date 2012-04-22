package expression.operators.a_equals_b_op_c;

import expression.Operation;

/**
 * User: Ty
 * Date: 4/21/12
 * Time: 8:47 PM
 */
public class Xor extends AEqualsBOpC {
    public Xor(int startPos, String text) {
        super(startPos, text);
    }

    public Xor(Operation fakeOp) {
        super(fakeOp);
    }

    @Override
    protected String getIdentifier() {
        return "\\^";
    }

    @Override
    protected String getOperatorName() {
        return "XOR";
    }
}
