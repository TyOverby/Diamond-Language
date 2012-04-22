package expression;

import java.util.*;

/**
 * User: Ty
 * Date: 4/15/12
 * Time: 10:51 PM
 */
public class ChunkFactory {
    private static List<FakeChunk> fakeChunkList = new ArrayList<FakeChunk>();

    public static FakeChunk getChunk(int startPos){
        // Try to find the requested chunk
        for(FakeChunk c: fakeChunkList){
            if(c.startPos==startPos){
                return c;
            }
        }

        // We didn't find it, so we will make a new one.
        FakeChunk c = new FakeChunk(startPos);
        fakeChunkList.add(c);
        return c;
    }

    public static List<FakeChunk> getFakeChunkList(){
        return fakeChunkList;
    }
    
    public static void print(){
        for(FakeChunk fakeChunk : fakeChunkList){
            if(!fakeChunk.hasParent()){
                fakeChunk.print("");
            }
        }
    }

    public static void clean(){
        fakeChunkList.clear();
    }
}
