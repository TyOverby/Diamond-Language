package expression;

/**
 * User: Ty
 * Date: 4/15/12
 * Time: 6:47 PM
 */
public class BlockLocation implements Comparable {
    public final int start;
    public final int end;

    public BlockLocation(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Object o) {
        BlockLocation other = (BlockLocation)o;
        if(this.start>other.start){
            return 1;
        }
        else if(this.start<other.start){
            return -1;
        }
        
        System.err.println("something is not good");
        return 0;
    }
    
    public String toString(){
        return "("+start+", "+end+")";
    }
}
