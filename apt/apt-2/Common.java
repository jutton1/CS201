public class Common {
    public int count (String a, String b) {
      char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 
                           'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 
                           's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
      
      int[] alphaA = new int[26];
      int[] alphaB = new int[26];
      char[] aArray = a.toCharArray();
      char[] bArray = b.toCharArray();
      int tracker = 0;

      for (int i = 0; i < aArray.length; i++) {
         for (int j = 0; j < alphabet.length; j++) {
            if (aArray[i] == alphabet[j]) {
               alphaA[j] ++;
            }
         }
      }

      for (int i = 0; i < bArray.length; i++) {
         for (int j = 0; j < alphabet.length; j++) {
            if (bArray[i] == alphabet[j]) {
               alphaB[j] ++;
            }
         }
      }

      for (int i = 0; i < 26; i++) {
         while (alphaA[i] > 0 && alphaB[i] > 0) {
            alphaA[i] --;
            alphaB[i] --;
            tracker++;
         }
      }
      
      return tracker;

    }
 }