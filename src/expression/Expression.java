package expression;

/**
 * User: Ty
 * Date: 4/15/12
 * Time: 10:05 PM
 */
public abstract class Expression {
    public abstract String toAssembly();

    public abstract void print(int printLevel);

    public abstract boolean inRange(int location);
}
