package expression;

/**
 * User: Ty
 * Date: 4/17/12
 * Time: 9:12 PM
 */
public class Header extends Expression{
    private final String header;
    private final int startPos;
    
    public Header(int startPos, String header){
        this.header = header;
        this.startPos = startPos;
    }

    @Override
    public void toAssembly(String tabs) {
    }

    @Override
    public String toString(){
        return header;
    }

    @Override
    public void print(String tabs) {

    }

    @Override
    public boolean inRange(int location) {
        return false;  // This is already handled in the FakeChunk class
    }

    @Override
    public int getStartPos() {
        return this.startPos;
    }
}
