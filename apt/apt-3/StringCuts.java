import java.util.*;
import java.util.ArrayList;
import java.io.*;
import java.util.List;
import java.util.stream.Collectors;
  


public class StringCuts {


    public String[] filter(String[] list, int minLength) {
        ArrayList<String> longWords = new ArrayList<String>();
        ArrayList<String> allWords = new ArrayList<String>();

        for (String word : list) {
            allWords.add(word);
        }
        List<String> uniqueList = allWords.stream().distinct().collect(Collectors.toList());

        for (String word: uniqueList) {
            if (!(word.length() < minLength)) {
                longWords.add(word);
            }
        }

        String[] output = longWords.toArray(new String[longWords.size()]);

        //Object[] longWordsArray = longWords.toArray();

        return output;
    }
}