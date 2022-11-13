import java.util.Arrays;

public class TxMsg {

  public static void main(String[] args) {
    System.out.println(getMessage("dad"));
  }
    /**
     * @param original original message text
     * @return text message text styling of original
     */
    public static String getMessage(String original) {

      original = "dad";
      System.out.println(original);

      final char[] vowels = {'a', 'e', 'i', 'o', 'u'};
      char[] charArray = original.toCharArray();
      String workingString = original;

      int previousWorkingStringLength = workingString.length();

      // Remove the consonants with consonants before it
      for (int i = 1; i < charArray.length; i++) {
        if (!Arrays.asList(vowels).contains(charArray[i]) && !Arrays.asList(vowels).contains(charArray[i-1])) {
          charArray[i] = (Character) null;
        }
      }

      workingString = new String(charArray);
      charArray = workingString.toCharArray();
      System.out.println(workingString);
      // remove vowels
      if (!(previousWorkingStringLength == workingString.length())) {
        for (int i = 0; i < charArray.length; i++) {
          if (Arrays.asList(vowels).contains(charArray[i])) {
            charArray[i] = (Character) null;
          }
        }
      }
      
      workingString = new String(charArray);
      charArray = workingString.toCharArray();
      
      return workingString;
    }
 }