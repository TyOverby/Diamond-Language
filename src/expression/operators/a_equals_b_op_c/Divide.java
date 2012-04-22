package expression.operators.a_equals_b_op_c;

import expression.Operation;

/**
 * User: Ty
 * Date: 4/21/12
 * Time: 8:33 PM
 */
public class Divide extends AEqualsBOpC {
    public Divide(int startPos, String text) {
        super(startPos, text);
    }

    public Divide(Operation fakeOp) {
        super(fakeOp);
    }

    @Override
    protected String getIdentifier() {
        return "/";
    }

    @Override
    protected String getOperatorName() {
        return "DIV";
    }
}
