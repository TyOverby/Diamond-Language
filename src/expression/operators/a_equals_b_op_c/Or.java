package expression.operators.a_equals_b_op_c;

import expression.Operation;

/**
 * User: Ty
 * Date: 4/21/12
 * Time: 8:46 PM
 */
public class Or extends AEqualsBOpC {
    public Or(int startPos, String text) {
        super(startPos, text);
    }

    public Or(Operation fakeOp) {
        super(fakeOp);
    }

    @Override
    protected String getIdentifier() {
        return "\\|";
    }

    @Override
    protected String getOperatorName() {
        return "BOR";
    }
}
