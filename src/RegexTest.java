/**
 * User: Ty
 * Date: 4/21/12
 * Time: 8:55 PM
 */
public class RegexTest {
    public static void main(String... args){
        String regex = "\\+|=";
        String testing = "a = b + c";
        
        for(String s: testing.split(regex)){
            System.out.println(s.trim());
        }
    }
}
