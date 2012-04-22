package expression;

import java.awt.print.Printable;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: Ty
 * Date: 4/21/12
 * Time: 10:08 PM
 */
public class LineManager {
    public static class Position{
        public final int startPos;
        public final int endPos;
        
        public Position(int startPos, int endPos){
            this.startPos = startPos;
            this.endPos = endPos;
        }
    }

    public static class Group{
        public final Position sourceLocation;
        public final String originalSource;
        public final String compiledSource;
        
        public Group(Position sourceLocation,String originalSource,String compiledSource){
            this.sourceLocation = sourceLocation;
            this.originalSource = originalSource;
            this.compiledSource = compiledSource;
        }
    }
    
    private static List<Group> tracker = new ArrayList<Group>();

    public static void addBlank(){
        tracker.add(new Group(new Position(-1,-1),"",""));
    }
    public static void addLine(Group group){
        tracker.add(group);
    }
    public static void addLine(Chunk chunk, String compiled){
        tracker.add(new Group(new Position(chunk.startPos,chunk.endPos),chunk.header.toString(),compiled));
    }
    
    public static void out(PrintStream ps){
        for(Group group:tracker){
            ps.println(group.compiledSource);
        }
    }



    public static void clean(){
        tracker.clear();
    }
}
