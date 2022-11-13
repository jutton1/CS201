import java.util.HashMap;
import java.util.HashSet;

public class Translate {
    public int numAlternates(String original, String translated) {
        HashMap<String, HashSet<String>> tracker = new HashMap<>();
        String[] originalArray = original.split(" ");
        String[] translatedArray = translated.split(" ");




        for (int i = 0; i < originalArray.length; i++) {
            HashSet<String> temporary = new HashSet<>();
            if (!tracker.containsKey(originalArray[i])) {
                temporary.add(translatedArray[i]);
                tracker.put(originalArray[i], temporary);
            }

            if (tracker.containsKey(originalArray[i])) {
                tracker.get(originalArray[i]).add(translatedArray[i]);
                //temporary.add(translatedArray[i]);
                //tracker.put(originalArray[i], temporary);
            }

        }

        int count = 0;
        for (String key : tracker.keySet()) {
            if (tracker.get(key).size() > 1) {
                count += tracker.get(key).size();
            }
        }

        return count; 
    }
}