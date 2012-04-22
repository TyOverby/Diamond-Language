package expression.operators.opEquals;

import expression.Operation;

/**
 * User: Ty
 * Date: 4/21/12
 * Time: 8:34 PM
 */
public class TimesEquals extends OperatorEquals {

    public TimesEquals(int startPos, String text) {
        super(startPos, text);
    }

    public TimesEquals(Operation fakeOp) {
        super(fakeOp);
    }

    @Override
    protected String getIdentifier() {
        return "*=";
    }

    @Override
    protected String getOperatorName() {
        return "MUL";
    }
}
