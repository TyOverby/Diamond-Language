package expression.operators.opEquals;

import expression.Operation;

/**
 * User: Ty
 * Date: 4/21/12
 * Time: 8:46 PM
 */
public class OrEquals extends OperatorEquals {
    public OrEquals(int startPos, String text) {
        super(startPos, text);
    }

    public OrEquals(Operation fakeOp) {
        super(fakeOp);
    }

    @Override
    protected String getIdentifier() {
        return "\\|=";
    }

    @Override
    protected String getOperatorName() {
        return "BOR";
    }
}
