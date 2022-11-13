import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class SetAside {
    public String common(String[] list) {
        HashMap<String, Integer> returnWords = new HashMap<String, Integer>();
        String[] returnArrayDraft = new String[50];
        int count = 0;
        HashSet<String> hasChecked = new HashSet<String>();
        for (int i = 0; i < list.length; i++) {
            hasChecked.clear();
            String[] wordsI = list[i].split(" ");
            for (int j = 0; j < wordsI.length; j++) {
                returnWords.putIfAbsent(wordsI[j], 0);
                if (! hasChecked.contains(wordsI[j])) {
                    returnWords.put(wordsI[j], returnWords.get(wordsI[j]) + 1);
                    hasChecked.add(wordsI[j]);
                    if (returnWords.get(wordsI[j]) == list.length) {
                        returnArrayDraft[count] = wordsI[j];
                        count ++;
                    }
                }
                
            }  
        }

        String[] returnArray = new String[count];
        for (int i = 0; i < count; i ++) {
            returnArray[i] = returnArrayDraft[i];
        }

        Arrays.sort(returnArray);

        String returnString = new String(String.join(" ", returnArray));

        return returnString;
    }
}