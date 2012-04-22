import expression.ChunkFactory;
import expression.LineManager;
import expression.Parser;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Queue;

/**
 * User: Ty
 * Date: 4/22/12
 * Time: 12:31 AM
 */
public class Wrapper {
    public static String compile(String input) {


        Parser.load(input);

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);

        Parser.firstPass();

        LineManager.out(ps);


        return os.toString();
    }

    public static void clean(){
        Parser.clean();
        LineManager.clean();
        ChunkFactory.clean();
    }
}
