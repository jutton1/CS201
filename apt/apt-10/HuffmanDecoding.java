import java.util.ArrayList;
import java.util.HashMap;


public class HuffmanDecoding {
    public String decode(String archive, String[] dictionary) {
        Character[] alphabet = new Character[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
                                         'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
                                         'U', 'V', 'W', 'X', 'Y', 'Z'};
        
        HashMap<String, Character> alphaDecoding = new HashMap<String, Character>();

        for (int i = 0; i < dictionary.length; i++) {
            alphaDecoding.put(dictionary[i], alphabet[i]);
        }

        StringBuilder buildReturn = new StringBuilder();
        int i = 0;
        int y = 1;
        while (true) {
            if (alphaDecoding.containsKey(archive.substring(i, i + y)) && !(i + y > archive.length())) {
                buildReturn.append(alphaDecoding.get(archive.substring(i, i + y)));
                i = i + y;
                y = 0;
            }
            if (i + y >= archive.length()) break;
            y++;
        }

        String returnString = buildReturn.toString();

        return returnString;
    }
 }