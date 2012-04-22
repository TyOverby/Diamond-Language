package expression.operators.opEquals;

import expression.Operation;

/**
 * User: Ty
 * Date: 4/21/12
 * Time: 11:30 PM
 */
public class Set extends OperatorEquals {

    public Set(int startPos, String text) {
        super(startPos, text);
    }

    public Set(Operation fakeOp) {
        super(fakeOp);
    }

    @Override
    protected String getIdentifier() {
        return "=";
    }

    @Override
    protected String getOperatorName() {
        return "SET";
    }
}
