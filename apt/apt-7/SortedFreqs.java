import java.util.ArrayList;
import java.util.Arrays;

public class SortedFreqs {
    public int[] freqs(String[] data) {
      Arrays.sort(data);
      ArrayList<Integer> frequencies = new ArrayList<Integer>();
      int count = 0;

      if (data.length == 0) {
        int[] baseReturnArray = {};
        return baseReturnArray;
      }

      String current = data[0];
      
      for (int i = 0; i < data.length; i++) {
        if (data[i].equals(current)) {
          count ++;
        }
        else {
          frequencies.add(count);
          count = 1;
          current = data[i];
        }
      }
      frequencies.add(count);

      Integer[] returnObjectArray = frequencies.toArray(new Integer[0]);

      int[] returnArray = new int[returnObjectArray.length];

      for (int i = 0; i <returnObjectArray.length; i++) {
        returnArray[i] = returnObjectArray[i];
      }

      return returnArray;

    }
 }