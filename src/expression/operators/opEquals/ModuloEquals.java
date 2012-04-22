package expression.operators.opEquals;

import expression.Operation;

/**
 * User: Ty
 * Date: 4/21/12
 * Time: 8:37 PM
 */
public class ModuloEquals extends OperatorEquals {
    public ModuloEquals(int startPos, String text) {
        super(startPos, text);
    }

    public ModuloEquals(Operation fakeOp) {
        super(fakeOp);
    }

    @Override
    protected String getIdentifier() {
        return "%=";
    }

    @Override
    protected String getOperatorName() {
        return "MOD";
    }
}
