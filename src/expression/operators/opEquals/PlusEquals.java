package expression.operators.opEquals;

import expression.Operation;

/**
 * User: Ty
 * Date: 4/21/12
 * Time: 8:13 PM
 */
public class PlusEquals extends OperatorEquals {

    public PlusEquals(int startPos, String text) {
        super(startPos, text);
    }

    public PlusEquals(Operation fakeOp) {
        super(fakeOp);
    }

    @Override
    protected String getIdentifier() {
        return "\\+=";
    }

    @Override
    protected String getOperatorName() {
        return "ADD";
    }
}
