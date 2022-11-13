import java.util.ArrayList;
import java.util.HashMap;

public class Encryption {
    public String encrypt(String message){
        char[] messageChars = message.toCharArray();

        HashMap <Character, Character> encryptionKey = new HashMap<>();

        char[] alphabet = new char[] {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        int i = 0;

        ArrayList<Character> returnSet = new ArrayList<>();
        //ArrayList<Character> returnSet = new ArrayList<Character>();


        for (Character messageChar : messageChars) {
            if (!encryptionKey.containsKey(messageChar)) {
                encryptionKey.putIfAbsent(messageChar, alphabet[i]);
                i++;
            }

            returnSet.add(encryptionKey.get(messageChar));
        }

        StringBuffer intermediaryReturn = new StringBuffer();

        for (Character s : returnSet) {
            intermediaryReturn.append(s);
        }

        String finalReturn = intermediaryReturn.toString();

        return finalReturn;
    }
}