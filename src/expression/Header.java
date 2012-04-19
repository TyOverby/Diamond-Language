package expression;

/**
 * User: Ty
 * Date: 4/17/12
 * Time: 9:12 PM
 */
public class Header extends Expression{
    private String header;
    
    public Header(int startPos, String header){
        this.header = header;
    }

    @Override
    public String toAssembly() {
        return null;
    }

    @Override
    public String toString(){
        return header;
    }

    @Override
    public void print(int printLevel) {

    }

    @Override
    public boolean inRange(int location) {
        return false;  // This is already handled in the Chunk class
    }
}
