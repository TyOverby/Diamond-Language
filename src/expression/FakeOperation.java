package expression;

/**
 * User: Ty
 * Date: 4/21/12
 * Time: 8:14 PM
 */
public class FakeOperation extends Operation{
    public FakeOperation(int startPos, String text) {
        super(startPos, text);
    }

    @Override
    public void toAssembly(String tabs) {
        throw new IllegalArgumentException("toAssembly should not be called on a fake operation");
    }
}
