import java.util.*;

public class Starter {
    public int begins(String[] words, String first) {
        int total = 0;
        Set<String> unique = new HashSet<>(Arrays.asList(words));
        String[] uniqueWords = unique.toArray(new String[unique.size()]);
        for (int i = 0; i < unique.size(); i++) {

            // String.valueOf(words[i].charAt(0) ch)
            // words[i].charAt(0).toString().equals(first)
            if (String.valueOf(uniqueWords[i].charAt(0)).equals(first)) {                
                total++;
            }
        }
        return total;
    }
}