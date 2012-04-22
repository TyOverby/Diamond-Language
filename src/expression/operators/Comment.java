package expression.operators;

import expression.Operation;
import expression.operators.opEquals.OperatorEquals;

/**
 * User: Ty
 * Date: 4/21/12
 * Time: 9:34 PM
 */
public class Comment extends Operation {
    public Comment(Operation fakeOp) {
        super(fakeOp);
    }

    public Comment(int startPos, String text) {
        super(startPos, text);
    }

    @Override
    public void toAssembly(String tabs) {
    }
}
