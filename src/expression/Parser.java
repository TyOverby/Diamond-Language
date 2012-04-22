    package expression;

    import expression.blocks.Function;
    import expression.blocks.Loop;
    import expression.operators.a_equals_b_op_c.*;
    import expression.operators.opEquals.*;
    import expression.operators.opEquals.Set;
    import expression.operators.opEquals.XOrEquals;

    import java.io.*;
    import java.util.*;

    /**
     * User: Ty
     * Date: 4/15/12
     * Time: 6:20 PM
     */
    public class Parser {
        public static boolean debug = true;

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

        public static void load(String string){
            wholeFile=string;
            charArray=string.toCharArray();
        }

        /**
         * At the end of this method, the entire source tree
         * will be built into
         */
        public static void firstPass(){
            buildBlocks();
            claimHeaders();
            consumeExpressions();
            sort();

            if(debug){
                System.out.println("======================= First Sorting =======================");
                ChunkFactory.print();
            }

            transform();
            if(debug){
                System.out.println("======================= Categorizing  =======================");
                printChunks();
                System.out.println("========================= Assembled  ========================");
            }
            assembleChunks();
        }

        public static void secondPass(){

        }

        public static Stack<FakeChunk> startQueue = new Stack<FakeChunk>();
        /**
         * This goes through the array of characters and builds blocks out of them
         * If it finds a '{', it pushes a new Block into startQueue with the position
         * of the opening curly.  Then whenever it finds a '}', it will pop a FakeChunk from
         * the stack and set the ending position.
         */
        private static void buildBlocks(){
            for(int i=0;i<charArray.length;i++){
                char c = charArray[i];

                if(c=='{'){
                    FakeChunk parent = null;
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

        /**
         * Now that we know where all of the blocks are, we try to find the headers for them.
         * The headers are something like "for(int i=0;i<10;i++)".  They tell us information
         * about what is in that block.
         *
         * The way this works is it jumps backward from the
         */
        private static void claimHeaders(){
            for(FakeChunk fakeChunk :ChunkFactory.getFakeChunkList()){
                String header = "";

                for(int i= fakeChunk.startPos-1;i>=0;i--){
                    char c = charArray[i];

                    if(c==';'||c=='{'||c=='}'){
                        fakeChunk.setHeader(new Header(i + 1, header));
                        break;
                    }
                    else{
                        header = c+header;
                    }

                    if(i==0){
                        fakeChunk.setHeader(new Header(0, header));
                        break;  // This isn't necessary.  I'm just stubborn;
                    }
                }
            }
        }

        private static void consumeExpressions(){
            for(FakeChunk fakeChunk :ChunkFactory.getFakeChunkList()){
                String containedExpression = "";

                for(int i= fakeChunk.startPos;i< fakeChunk.endPos;i++){
                    boolean owned = false;

                    for(Expression children: fakeChunk.getExpressions()){
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
                        else if(containedExpression.trim().length() >0){
                            fakeChunk.addExpression(new FakeOperation(i-containedExpression.length(),containedExpression));
                            containedExpression = "";
                        }
                    }
                    else if(containedExpression.trim().length() >0){
                        fakeChunk.addExpression(new FakeOperation(i-containedExpression.length(),containedExpression));
                        containedExpression = "";
                    }
                }
            }
        }

        /**
         * Before this, the chunks contained other chunks
         * and expressions in a non-sensical order
         * (It would have Chunks first and then operations)
         *
         * This sorts all of the chunks.
         */
        private static void sort(){
            for(FakeChunk fakeChunk : ChunkFactory.getFakeChunkList()){
                fakeChunk.sort();
            }
        }


        private static List<Chunk> chunkList = new ArrayList<Chunk>();
        private static void transform(){

            for(FakeChunk fakeChunk :ChunkFactory.getFakeChunkList()){
                if(!fakeChunk.hasParent()){
                    chunkList.add(transformChunk(fakeChunk));
                }
            }

        }

        private static void printChunks(){
            for(Chunk chunk : chunkList){
                if(!chunk.hasParent()){
                    chunk.print("");
                }
            }
        }
        private static void assembleChunks(){
            for(Chunk chunk : chunkList){
                if(!chunk.hasParent()){
                    chunk.toAssembly("");
                }
            }
        }

        private static Chunk transformChunk(FakeChunk fakeChunk){
            Chunk toReturn = null;
            String header = fakeChunk.getHeader().toString();

            System.out.println("running");

            if(header.contains("loop(")){
                toReturn = new Loop(fakeChunk.startPos, fakeChunk.endPos, fakeChunk.header);
            }
            else if(header.contains("for(")){
                // Handle for loop
            }
            else if(header.contains("function")){
                toReturn = new Function(fakeChunk.startPos, fakeChunk.endPos, fakeChunk.header);
            }
            else if(header.contains("subroutine")){
                // Handle subroutine definition
            }
            else if(header.contains("struct")){

            }
            else if(header.contains("if")){

            }
            else{
                throw new IllegalArgumentException("Can't identify the block starting at "+fakeChunk.startPos);
            }

            for(Expression expression: fakeChunk.expressions){
                if(expression instanceof FakeChunk){
                    toReturn.addChunk(transformChunk((FakeChunk)expression));
                }
                else if(expression instanceof Operation){
                    toReturn.addExpression(transformOperator((Operation) expression));
                }
                else{
                    throw new IllegalArgumentException("Expression is neither a Chunk or an Operation");
                }
            }

            return toReturn;
        }

        private static Operation transformOperator(Operation operation){
            Operation toReturn = null;

            /**
             * All of the Operator-Equals operations
             */
            if(operation.text.contains("+=")){
                toReturn = new PlusEquals(operation);
                //System.out.println("EAUALS");
            }
            else if(operation.text.contains("-=")){
                toReturn = new MinusEquals(operation);
            }
            else if(operation.text.contains("*=")){
                toReturn = new TimesEquals(operation);
            }
            else if(operation.text.contains("/=")){
                toReturn = new DivideEquals(operation);
            }
            else if(operation.text.contains("%=")){
                toReturn = new ModuloEquals(operation);
            }
            else if(operation.text.contains("|=")){
                toReturn = new PlusEquals(operation);
            }
            else if(operation.text.contains("&=")){
                toReturn = new AndEquals(operation);
            }
            else if(operation.text.contains("^=")){
                toReturn = new XOrEquals(operation);
            }
            else if(operation.text.contains("<<")&& !operation.text.contains("=")){
                toReturn = new ShiftLeftEquals(operation);
            }
            else if(operation.text.contains(">>")&& !operation.text.contains("=")){
                toReturn = new ShiftRightEquals(operation);
            }

            /**
             * Any operation of the form a = b + c
             */
            else if(operation.text.contains("+")){
                toReturn = new Plus(operation);
            }
            else if(operation.text.contains("-")){
                toReturn = new Minus(operation);
            }
            else if(operation.text.contains("*")){
                toReturn = new Times(operation);
            }
            else if(operation.text.contains("/")){
                toReturn = new Divide(operation);
            }
            else if(operation.text.contains("%")){
                toReturn = new Modulo(operation);
            }
            else if(operation.text.contains("|")){
                toReturn = new Plus(operation);
            }
            else if(operation.text.contains("&")){
                toReturn = new And(operation);
            }
            else if(operation.text.contains("^")){
                toReturn = new Xor(operation);
            }
            else if(operation.text.contains("<<")){
                toReturn = new ShiftLeft(operation);
            }
            else if(operation.text.contains(">>")){
                toReturn = new ShiftRight(operation);
            }

            else if (operation.text.contains("=")){
                toReturn = new Set(operation);
            }
            else{
                throw new IllegalArgumentException("Cannot tell what "+operation.text+" is.");
            }
            return toReturn;
        }

        public static void clean(){
            startQueue.clear();
            chunkList.clear();
            wholeFile = "";
            charArray = new char[0];
        }
    }
