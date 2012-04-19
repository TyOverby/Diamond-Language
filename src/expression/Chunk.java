package expression;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Ty
 * Date: 4/15/12
 * Time: 5:56 PM
 */
public class Chunk extends Expression {
    private Expression parent;
    
    private Expression chunkHeader;
    public int headerStartPos;
    public final int startPos;
    public int endPos;
    
    public final List<Expression> expressions = new ArrayList<Expression>();

    public Chunk(int startPos){
        this.startPos = startPos;
    }

    public void setHeader(Expression expression){
        this.chunkHeader = expression;
    }
    public void setHeaderStartPos(int headerStartPos){
        this.headerStartPos = headerStartPos;
    }
    
    public void addChunk(Chunk chunk){
        this.expressions.add(chunk);
        chunk.setParent(this);
    }
    public void removeChunk(Chunk chunk){
        for(int i=0;i<expressions.size();i++){
            Expression exp =expressions.get(i);
            if(exp instanceof Chunk){
                if(chunk.equals(exp)){
                    expressions.remove(i);
                    //ChunkFactory.remove(chunk);
                }
            }
        }
    }

    /**
     * Adds an expression to the chunk.
     * @param expression The expression to add to the chunk
     *
     */
    public void addExpression(Expression expression){
        this.expressions.add((expression));
    }
    public List<Expression> getExpressions(){
        return this.expressions;
    }

    public void setEndPos(int endPos){
        this.endPos = endPos;
    }

    public boolean inRange(int location){
        return location>this.headerStartPos && location<this.endPos;
    }
    
    public void setParent(Expression parent){
        this.parent = parent;
    }
    public boolean hasParent(){
        return this.parent != null;
    }

    @Override
    public String toAssembly() {
        System.err.println("you fucked up");
        return null;
    }

    @Override
    public boolean equals(Object other){
        if(other instanceof Chunk){
            if(this.startPos==((Chunk) other).startPos&&this.endPos==((Chunk) other).endPos){
                return true;
            }
        }

        return false;
    }

    public void print(int tabLevel){
        String tabs ="";
        for(int i=0;i<tabLevel;i++){
            tabs += "\t";
        }

        System.out.println(tabs+"("+startPos+", "+endPos+")["+chunkHeader);
        for(Expression e: expressions){
            e.print(tabLevel+1);
        }
    }
}
