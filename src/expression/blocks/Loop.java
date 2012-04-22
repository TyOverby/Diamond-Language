package expression.blocks;

import expression.Chunk;
import expression.Expression;
import expression.FakeChunk;
import expression.LineManager;

import java.security.PrivateKey;

import static expression.LineManager.*;

/**
 * User: Ty
 * Date: 4/21/12
 * Time: 6:47 PM
 */
public class Loop extends Chunk {
    
    public Loop(int startPos, int endPos, Expression header) {
        super(startPos);
        this.endPos = endPos;
        this.setHeader(header);
    }


    @Override
    public void toAssembly(String tabs) {
        Position pos = new Position(startPos,endPos);
        String loopStart = tabs+":loop_"+startPos+"_start";
        String loopEnd   = tabs+":loop_"+startPos+"_end";
        
        String push  = tabs+"\tSET PUSH, 1";
        
        String value = header.toString().replace("loop","").replace("(","").replace(")","").trim();
        
        String checkStart = tabs+"\t:check_"+startPos;
        String actualCheck = tabs+"\t\t"+tabs+"IFG PEEK, "+value;
        String checkResult = tabs+"\t\t\t"+"SET PC, "+loopEnd.replace(":","").trim();
        
        String increment = tabs+"\t"+"ADD PEEK, 1";
        String goBackToCheck = tabs+"\tSET PC, "+checkStart.replace(":","").trim();


        LineManager.addLine(this,loopStart);
        LineManager.addLine(this,push);
        LineManager.addLine(this,checkStart);
        LineManager.addLine(this,actualCheck);
        LineManager.addLine(this,checkResult);
        LineManager.addBlank();
        for(Expression expression:this.getExpressions()){
            expression.toAssembly(tabs+"\t");
        }
        LineManager.addBlank();
        LineManager.addLine(this,increment);
        LineManager.addLine(this,goBackToCheck);
        LineManager.addLine(this,loopEnd);
    }

    @Override
    public void print(String tabs) {
        System.out.println(tabs+"loop");
    }
}
