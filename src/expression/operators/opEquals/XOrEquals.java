package expression.operators.opEquals;

import expression.Operation;

/**
 * User: Ty
 * Date: 4/21/12
 * Time: 8:47 PM
 */
public class XOrEquals extends OperatorEquals {
    public XOrEquals(int startPos, String text) {
        super(startPos, text);
    }

    public XOrEquals(Operation fakeOp) {
        super(fakeOp);
    }

    @Override
    protected String getIdentifier() {
        return "\\^=";
    }

    @Override
    protected String getOperatorName() {
        return "XOR";
    }
}
