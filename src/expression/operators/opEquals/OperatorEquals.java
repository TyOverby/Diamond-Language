package expression.operators.opEquals;

import static expression.LineManager.*;
import expression.LineManager;
import expression.Operation;

/**
 * User: Ty
 * Date: 4/21/12
 * Time: 8:20 PM
 */
public abstract class OperatorEquals extends Operation {

    public OperatorEquals(int startPos, String text) {
        super(startPos, text);
    }
    public OperatorEquals(Operation fakeOp) {
        super(fakeOp);
    }

    protected abstract String getIdentifier();
    protected abstract String getOperatorName();
    
    @Override
    public void toAssembly(String tabs) {
        String original = this.text;
        String[] split = original.split(getIdentifier());

        String toReturn = tabs + getOperatorName()+" "+split[0].trim()+", "+split[1].trim();
        LineManager.addLine(new Group(new Position(startPos,endPos),this.text,toReturn));
    }
}
