import java.util.Collections;
import java.util.HashMap;

public class BigWord {
    public String most(String[] sentences) {

        HashMap<String, Integer> wordCount = new HashMap<String, Integer>();
        for (String sentence : sentences) {
            String words[] = sentence.split(" ");
            for (String word : words) {
                if (!(wordCount.containsKey(word.toLowerCase()))) {
                    wordCount.put(word.toLowerCase(), 1);
                }
                else {
                    wordCount.put(word.toLowerCase(), (wordCount.get(word.toLowerCase()) + 1));
                }
            }
        }

        int maxValue = (Collections.max(wordCount.values()));

        for (java.util.Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() == maxValue) {
                return entry.getKey();
            }
        }

        return "invalid";


    }
}