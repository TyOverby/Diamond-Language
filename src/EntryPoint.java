import expression.Parser;

import java.io.File;

/**
 * User: Ty
 * Date: 4/15/12
 * Time: 5:53 PM
 */
public class EntryPoint {
    public static void main(String... args){
        Parser.load(new File("TestingFunctions.diamond"));

        Parser.firstPass();
    }
}
