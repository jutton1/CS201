import java.util.Arrays;
import java.util.Comparator;

public class LengthSort {
    public String[] rearrange(String[] values){
        //Comparator<String> comp =;
        Comparator<String> comp = Comparator.comparing(String::length).thenComparing(String.CASE_INSENSITIVE_ORDER);
        Arrays.sort(values, comp);

        return values;
    }
}