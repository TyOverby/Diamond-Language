package expression;

import java.util.*;

/**
 * User: Ty
 * Date: 4/15/12
 * Time: 10:51 PM
 */
public class ChunkFactory {
    private static List<Chunk> chunkList = new ArrayList<Chunk>();

    public static Chunk getChunk(int startPos){
        // Try to find the requested chunk
        for(Chunk c: chunkList){
            if(c.startPos==startPos){
                return c;
            }
        }

        // We didn't find it, so we will make a new one.
        Chunk c = new Chunk(startPos);
        chunkList.add(c);
        return c;
    }

    public static List<Chunk> getChunkList(){
        return chunkList;
    }
    
    public static void print(){
        for(Chunk chunk:chunkList){
            if(!chunk.hasParent()){
                chunk.print(0);
            }
        }
    }
}
