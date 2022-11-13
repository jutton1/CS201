import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Aaagmnrs {

   public String[] anagrams(String[] phrases) {
      // fill in code here

      HashSet<String> existingUnorderedStrings = new HashSet<String>();

      ArrayList<String> returnList = new ArrayList<String>();

      for (String phrase : phrases) {
         String phraseNoWhitespace = phrase.replaceAll(" ", "");
         char[] phraseCharArray = phraseNoWhitespace.toLowerCase().toCharArray();

         Arrays.sort(phraseCharArray);
         String temporary = String.valueOf(phraseCharArray);

         if (existingUnorderedStrings.contains(temporary)) {
            continue;
         }

         else {
            existingUnorderedStrings.add(temporary);
            returnList.add(phrase);
         }
      }

      Object[] returnObjectArray = returnList.toArray();
      String[] returnArray = new String[returnObjectArray.length];

      int i = 0;
      for (Object returnObject : returnObjectArray) {
         String returnString = (String) returnObject;
         returnArray[i] = returnString;
         i++;
      }

      return returnArray;
   }
}