package expression;

/**
 * User: Ty
 * Date: 4/18/12
 * Time: 10:58 PM
 */
public abstract class Operation extends Expression {
    public final int startPos;
    public final int endPos;
    public final String text;

    public Operation(Operation fakeOp){
        this.startPos = fakeOp.startPos;
        this.endPos   = fakeOp.endPos;
        this.text     = fakeOp.text;
    }
    public Operation(int startPos, String text){
        this.startPos = startPos;
        this.endPos = startPos+text.length();
        this.text = text.trim();
    }

    @Override
    public void print(String tabs) {
        System.out.println(tabs+"O ("+startPos+")"+text);
    }

    @Override
    public boolean inRange(int location) {
        return false;
    }

    @Override
    public int getStartPos() {
        return this.startPos;
    }
}
