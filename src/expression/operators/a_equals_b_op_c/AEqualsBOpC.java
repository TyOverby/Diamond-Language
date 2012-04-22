package expression.operators.a_equals_b_op_c;

import static expression.LineManager.*;
import expression.LineManager;
import expression.Operation;

/**
 * User: Ty
 * Date: 4/21/12
 * Time: 8:53 PM
 */
public abstract class AEqualsBOpC extends Operation{
    public AEqualsBOpC(int startPos, String text) {
        super(startPos, text);
    }
    public AEqualsBOpC(Operation fakeOp) {
        super(fakeOp);
    }

    protected abstract String getIdentifier();
    protected abstract String getOperatorName();

    @Override
    public void toAssembly(String tabs) {
        String toReturn = "";

        String original = this.text;
        String[] split = original.split(getIdentifier()+"|=");

        String firstPart = tabs+"SET "+split[0].trim()+", "+split[1].trim();
        String secondPart = tabs+getOperatorName()+" "+split[0].trim()+", "+split[2].trim();
        
        LineManager.addLine(new Group(new Position(startPos,endPos),this.text,firstPart));
        LineManager.addLine(new Group(new Position(startPos,endPos),this.text,secondPart));
    }
}
