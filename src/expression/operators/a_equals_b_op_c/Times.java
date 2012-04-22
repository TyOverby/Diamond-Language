package expression.operators.a_equals_b_op_c;

import expression.Operation;

/**
 * User: Ty
 * Date: 4/21/12
 * Time: 8:34 PM
 */
public class Times extends AEqualsBOpC {

    public Times(int startPos, String text) {
        super(startPos, text);
    }

    public Times(Operation fakeOp) {
        super(fakeOp);
    }

    @Override
    protected String getIdentifier() {
        return "*";
    }

    @Override
    protected String getOperatorName() {
        return "MUL";
    }
}
