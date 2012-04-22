package expression;

/**
 * User: Ty
 * Date: 4/15/12
 * Time: 10:05 PM
 */
public abstract class Expression {
    
    public abstract void toAssembly(String tabs);

    public abstract void print(String tabs);

    public abstract boolean inRange(int location);
    
    public abstract int getStartPos();
}
