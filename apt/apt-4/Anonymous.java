import java.security.KeyStore.Entry;
import java.util.HashMap;

public class Anonymous {
    public int howMany(String[] headlines, String[] messages) {
        HashMap <Character, Integer> availableChars = new HashMap<>();
        for (String headline : headlines) {
            for (char letter : headline.toLowerCase().toCharArray()) {
                if (letter != ' ') {
                    availableChars.putIfAbsent(letter, 0);
                    availableChars.put(letter, availableChars.get(letter) + 1);
                }
                
            }
        }

        int canWrite = 0;

        outerLoop:
        for (String message: messages) {
            HashMap <Character, Integer> availableCopy = new HashMap<>(copy(availableChars));
            
            for (char letter : message.toLowerCase().toCharArray()) {
                if (letter != ' ') {
                    if (availableCopy.containsKey(letter)) {
                        if (availableCopy.get(letter) > 0) {
                            availableCopy.put(letter, availableCopy.get(letter) - 1);
                        }
                        else {
                            continue outerLoop;
                        }
                    }
                    else {
                        continue outerLoop;
                    }
                }
                
            }
            canWrite ++;

        }

        return canWrite;
    }

    public HashMap <Character, Integer> copy (HashMap <Character, Integer> original) {
        
        HashMap <Character, Integer> copy = new HashMap <Character, Integer>();

        for (Character key: original.keySet()) {
            // Integer numb = new Integer.valueOf(entry.getValue().intValue());
            int numb = original.get(key);
            copy.put(key, numb);
        }


        return copy;
    }


}