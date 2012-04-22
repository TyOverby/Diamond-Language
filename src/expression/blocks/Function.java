package expression.blocks;

import static expression.LineManager.*;
import expression.Chunk;
import expression.Expression;
import expression.LineManager;

/**
 * User: Ty
 * Date: 4/21/12
 * Time: 7:23 PM
 */
public class Function extends Chunk {
    private String head;

    public Function(int startPos, int endPos, Expression header) {
        super(startPos);
        this.endPos = endPos;
        this.setHeader(header);
    }


    @Override
    public void toAssembly(String tabs) {
        String functionName  = this.header.toString().replace("function","").replace(("("),"").replace(")","").trim();
        String functionStart = tabs+":function_"+functionName+"_start";
        String functionEnd   = tabs+":function_"+functionName+"_end";
        
        LineManager.addLine(new Group(new Position(this.startPos,this.endPos),this.head,functionStart));
        for(Expression expression:this.getExpressions()){
            expression.toAssembly(tabs+"\t");
        }
        LineManager.addLine(new Group(new Position(this.startPos,this.endPos),this.head,functionEnd));
    }

    @Override
    public void print(String tabs) {
        System.out.println(tabs+"function");

        tabs += "\t";
        for(Expression ex:this.getExpressions()){
            ex.print(tabs);
        }
    }
}
