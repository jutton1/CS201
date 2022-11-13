import java.util.*;
  

public class CounterAttack {
    public int[] analyze(String str, String[] words) {
        String parts[] = str.split(" ");
        HashMap<String, Integer> partsMap = new HashMap<String, Integer>();
        for (String part : parts) {
            if (!(partsMap.containsKey(part))) {
                partsMap.put(part, 1);
            }
            else {
                partsMap.put(part, (partsMap.get(part) + 1));
            }
        }

        int[] returnArray = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            if (partsMap.containsKey(words[i])) {
                returnArray[i] = partsMap.get(words[i]);
            }
            else {
                returnArray[i] = 0;
            }
            
        }

        return returnArray;

    }
}