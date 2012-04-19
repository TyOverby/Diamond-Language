package expression;

import javax.management.QueryEval;
import java.io.*;
import java.util.*;

/**
 * User: Ty
 * Date: 4/15/12
 * Time: 6:20 PM
 */
public class Parser {
    private static String wholeFile;
    private static char[] charArray;

    /**
     * Put the entire file into a massive string
     * @param toLoad The file to load
     */
    public static void load(File toLoad){
        try{
            final StringBuilder completeFile = new StringBuilder();

            FileInputStream fstream;
            fstream = new FileInputStream(toLoad);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;

            while ((strLine = br.readLine()) != null){
                completeFile.append(strLine);
            }
            in.close();

            wholeFile = completeFile.toString();
            charArray = wholeFile.toCharArray();

            String totalLabel="";
            String totalCharacter="";
            for(int i=0;i<charArray.length;i++){
                String label = String.valueOf(i)+" ";

                String character  = String.valueOf(charArray[i]);
                for(int j=1;j<label.length();j++){
                    character = character+" ";
                }
                
               totalLabel=totalLabel+label;
               totalCharacter = totalCharacter+character;
            }
            System.out.println(totalLabel);
            System.out.println(totalCharacter);

        }catch (Exception e){
            System.err.println("Error: " + e.getMessage());
        }
    }


    public static void firstPass(){
        buildBlocks();
        claimHeaders();
        consumeExpressions();
        ChunkFactory.print();

    }

    private static int globalLocation;
    private static int totalCount = 0;
    private static List<BlockLocation> blockLocations = new ArrayList<BlockLocation>(100);

    private static Stack<Chunk> startQueue = new Stack<Chunk>();
    /**
     * Find all of the matching curly braces.
     * Store them in blockLocations.
     */
    private static void buildBlocks(){
        for(int i=0;i<charArray.length;i++){
            char c = charArray[i];

            if(c=='{'){
                Chunk parent = null;
                if(startQueue.size()>0){
                    parent = startQueue.peek();
                }
                startQueue.push(ChunkFactory.getChunk(i));

                if(parent!=null){
                    parent.addChunk(startQueue.peek());
                }
            }
            else if(c=='}'){
                startQueue.pop().setEndPos(i);
            }
        }
    }

    private static void claimHeaders(){
        for(Chunk chunk:ChunkFactory.getChunkList()){
            String header = "";

            for(int i=chunk.startPos-1;i>=0;i--){
                char c = charArray[i];

                if(c==';'||c=='{'||c=='}'){
                    chunk.setHeader(new Header(i + 1, header.trim()));
                    chunk.setHeaderStartPos(i+1);
                    break;
                }
                else{
                    header = c+header;
                }

                if(i==0){
                    chunk.setHeader(new Header(0,header.trim()));
                    chunk.setHeaderStartPos(i+1);
                    break;  // This isn't necessary.  I'm just stubborn;
                }
            }
        }
    }

    private static void consumeExpressions(){
        for(Chunk chunk:ChunkFactory.getChunkList()){
            String containedExpression = "";
            
            for(int i=chunk.startPos;i<chunk.endPos;i++){
                boolean owned = false;
                
                for(Expression children:chunk.getExpressions()){
                    if(children.inRange(i)){
                        owned = true;
                        break;
                    }
                }

                if(!owned){
                    if(charArray[i]!=';' && charArray[i]!='{' && charArray[i]!='}'){
                        containedExpression += charArray[i];
                        continue;
                    }
                }
                else if(containedExpression.length() >0){
                    chunk.addExpression(new Operation(i-containedExpression.length(),containedExpression.trim()));
                    containedExpression = "";
                }
            }
        }
    }
}
