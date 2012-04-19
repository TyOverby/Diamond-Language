package expression;

/**
 * User: Ty
 * Date: 4/18/12
 * Time: 10:58 PM
 */
public class Operation extends Expression {
    public final int startPos;
    public final String text;

    public Operation(int startPos, String text){
        this.startPos = startPos;
        this.text = text;
    }

    @Override
    public String toAssembly() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void print(int printLevel) {
        String tabs = "";
        for(int i=0;i<printLevel;i++){
            tabs+="\t";
        }
        System.out.println(tabs+"O "+text);
    }

    @Override
    public boolean inRange(int location) {
        return false;
    }
}
