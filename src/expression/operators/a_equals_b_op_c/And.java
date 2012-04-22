package expression.operators.a_equals_b_op_c;

import expression.Operation;

/**
 * User: Ty
 * Date: 4/21/12
 * Time: 8:42 PM
 */
public class And extends AEqualsBOpC {

    public And(int startPos, String text) {
        super(startPos, text);
    }

    public And(Operation fakeOp) {
        super(fakeOp);
    }

    @Override
    protected String getIdentifier() {
        return "&";
    }

    @Override
    protected String getOperatorName() {
        return "AND";
    }
}
