import java.util.Arrays;
import java.util.HashSet;

public class Closet {
    public String anywhere(String[] list) {
        HashSet<String> returnSet = new HashSet<String>();
        for (String entry : list) {
            for (String word : entry.split(" ")) {
                returnSet.add(word);
            }
        }

        String[] returnArray = new String[returnSet.size()];

        int i = 0;
        for (String word: returnSet) {
            returnArray[i] = word;
            i++;
        }

        Arrays.sort(returnArray);

        String returnString = String.join(" ", returnArray);

        return returnString;
    }
}