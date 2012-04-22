package expression.operators.a_equals_b_op_c;

import expression.Operation;

/**
 * User: Ty
 * Date: 4/21/12
 * Time: 8:37 PM
 */
public class Modulo extends AEqualsBOpC {
    public Modulo(int startPos, String text) {
        super(startPos, text);
    }

    public Modulo(Operation fakeOp) {
        super(fakeOp);
    }

    @Override
    protected String getIdentifier() {
        return "%";
    }

    @Override
    protected String getOperatorName() {
        return "MOD";
    }
}
