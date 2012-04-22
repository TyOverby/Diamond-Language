package expression.operators.opEquals;

import expression.Operation;

/**
 * User: Ty
 * Date: 4/21/12
 * Time: 8:33 PM
 */
public class DivideEquals extends OperatorEquals {
    public DivideEquals(int startPos, String text) {
        super(startPos, text);
    }

    public DivideEquals(Operation fakeOp) {
        super(fakeOp);
    }

    @Override
    protected String getIdentifier() {
        return "/=";
    }

    @Override
    protected String getOperatorName() {
        return "DIV";
    }
}
