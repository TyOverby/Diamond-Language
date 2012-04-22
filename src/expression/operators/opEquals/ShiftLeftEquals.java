package expression.operators.opEquals;

import expression.Operation;

/**
 * User: Ty
 * Date: 4/21/12
 * Time: 8:38 PM
 */
public class ShiftLeftEquals  extends OperatorEquals {
    public ShiftLeftEquals(int startPos, String text) {
        super(startPos, text);
    }

    public ShiftLeftEquals(Operation fakeOp) {
        super(fakeOp);
    }

    @Override
    protected String getIdentifier() {
        return "<<";
    }

    @Override
    protected String getOperatorName() {
        return "SHL";
    }
}
