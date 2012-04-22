package expression.operators.opEquals;

import expression.Operation;

/**
 * User: Ty
 * Date: 4/21/12
 * Time: 8:32 PM
 */
public class MinusEquals extends OperatorEquals {
    public MinusEquals(int startPos, String text) {
        super(startPos, text);
    }

    public MinusEquals(Operation fakeOp) {
        super(fakeOp);
    }

    @Override
    protected String getIdentifier() {
        return "-=";
    }

    @Override
    protected String getOperatorName() {
        return "SUB";
    }
}
