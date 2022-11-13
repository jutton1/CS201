import java.util.Arrays;
import java.util.LinkedHashSet;

public class AlphaLength {
    public ListNode create (String[] words) {
        Arrays.sort(words);

        LinkedHashSet<String> noDuplicates = new LinkedHashSet<String>();

        for (int i = 0; i < words.length; i++) {
            noDuplicates.add(words[i]);
        }

        Object[] returnArray = noDuplicates.toArray();

        String[] returnStringArray = new String[returnArray.length];

        for (int i = 0; i < returnStringArray.length; i++) returnStringArray[i] = returnArray[i].toString();

        ListNode returnList = new ListNode(returnStringArray[returnStringArray.length - 1].length()) ;
        for (int i = returnStringArray.length - 2; i > -1; i--) {

            returnList = new ListNode(returnStringArray[i].length(), returnList);
        }

        return returnList;
    }
}