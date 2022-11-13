import java.util.Arrays;

public class SimpleWordGame {
    public int points(String[] player, 
                      String[] dictionary) {
        int score = 0;
        for (int i = 0; i < dictionary.length; i++) {
            if(Arrays.toString(player).contains(dictionary[i])) {
                score += (dictionary[i].length() * dictionary[i].length());
                dictionary[i] = null;
            }

        }
        return score;
    }
}