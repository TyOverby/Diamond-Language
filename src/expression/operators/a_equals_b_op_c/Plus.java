package expression.operators.a_equals_b_op_c;

import expression.Operation;

/**
 * User: Ty
 * Date: 4/21/12
 * Time: 8:13 PM
 */
public class Plus extends AEqualsBOpC {

    public Plus(int startPos, String text) {
        super(startPos, text);
    }

    public Plus(Operation fakeOp) {
        super(fakeOp);
    }

    @Override
    protected String getIdentifier() {
        return "\\+";
    }

    @Override
    protected String getOperatorName() {
        return "ADD";
    }
}
