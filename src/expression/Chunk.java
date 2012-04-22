package expression;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Ty
 * Date: 4/21/12
 * Time: 7:02 PM
 */
public abstract class Chunk extends Expression {
    public final int startPos;
    protected int endPos;

    protected Chunk parent;
    protected Expression header;

    public final List<Expression> expressions = new ArrayList<Expression>();
    
    public Chunk(int startPos){
        this.startPos = startPos;
    }

    public void setEndPos(int endPos){
        this.endPos = endPos;
    }
    
    public void addExpression(Expression ex){
        this.expressions.add(ex);
    }
    public List<Expression> getExpressions(){
        return this.expressions;
    }

    public void addChunk(Chunk chunk){
        this.expressions.add(chunk);
        chunk.setParent(this);
    }

    public void setHeader(Expression expression){
        this.header = expression;
    }
    public Expression getHeader(){
        return header;
    }

    public void setParent(Chunk parent){
        this.parent = parent;
    }
    public boolean hasParent(){
        return this.parent != null;
    }

    @Override
    public boolean inRange(int location) {
        if(location>header.getStartPos()&&location<endPos){
            return true;
        }

        return false;
    }


    @Override
    public int getStartPos() {
        return this.header.getStartPos();
    }

    @Override
    public boolean equals(Object other){
        if(other instanceof FakeChunk){
            if(this.startPos==((FakeChunk)other).startPos){
                return true;
            }
        }

        return false;
    }
}
