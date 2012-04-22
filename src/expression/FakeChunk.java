package expression;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * User: Ty
 * Date: 4/15/12
 * Time: 5:56 PM
 */
public class FakeChunk extends Chunk {

    public FakeChunk(int startPos) {
        super(startPos);
    }

    @Override
    public void toAssembly(String tabs) {
    }

    public void print(String tabs){

        System.out.println(tabs+"("+startPos+", "+endPos+")["+header);
        for(Expression e: expressions){
            e.print(tabs+"\t");
        }
    }

    public void sort(){
        Collections.sort(this.expressions,new Comparator<Expression>(){
            @Override
            public int compare(Expression o1, Expression o2) {
                if(o1.getStartPos()<o2.getStartPos()){
                    return -1;
                }
                else{
                    return 1;
                }
            }
        });
    }
}
