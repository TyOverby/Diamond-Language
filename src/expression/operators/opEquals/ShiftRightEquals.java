package expression.operators.opEquals;

import expression.Operation;

/**
 * User: Ty
 * Date: 4/21/12
 * Time: 8:40 PM
 */
public class ShiftRightEquals extends OperatorEquals {

    public ShiftRightEquals(int startPos, String text) {
        super(startPos, text);
    }

    public ShiftRightEquals(Operation fakeOp) {
        super(fakeOp);
    }

    @Override
    protected String getIdentifier() {
        return ">>";
    }

    @Override
    protected String getOperatorName() {
        return "SHR";
    }
}
