import java.util.HashMap;
import java.util.LinkedList;


public class SortByFreqs {

    

    public String[] sort(String[] data) {
        HashMap<String, Integer> wordCount = new HashMap<String,Integer>();
        for (String dataPoint : data) {
            wordCount.putIfAbsent(dataPoint, 0);
            wordCount.put(dataPoint, wordCount.get(dataPoint) + 1);
        }


        LinkedList<String> ordered = new LinkedList<String>();

        for (String key : wordCount.keySet()) {
            int position = 0;
            for (String entries: ordered) {
                if ((wordCount.get(entries) < wordCount.get(key)) || ((key.compareTo(entries) < 0) && (wordCount.get(entries) == wordCount.get(key)))) {
                    break;
                }
                position ++;
            }
            ordered.add(position, key);
        }

        String[] output = ordered.toArray(new String[0]);

        return output;
    }
}