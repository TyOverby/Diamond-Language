package expression.operators.opEquals;

import expression.Operation;

/**
 * User: Ty
 * Date: 4/21/12
 * Time: 8:42 PM
 */
public class AndEquals extends OperatorEquals {

    public AndEquals(int startPos, String text) {
        super(startPos, text);
    }

    public AndEquals(Operation fakeOp) {
        super(fakeOp);
    }

    @Override
    protected String getIdentifier() {
        return "&=";
    }

    @Override
    protected String getOperatorName() {
        return "AND";
    }
}
