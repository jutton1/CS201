import java.util.ArrayList;
import java.util.List;

// temporary

public class LunchPlans {
    public String[] favorites(String[] preferences) {
        List<String> communal = new ArrayList<String>();
        String[] first = preferences[0].split(" ");
        if (preferences.length == 1) {
            return first;
        }

        for (int i = 0; i < first.length; i++) {
            boolean include = true;
            for (int j = 1; j < preferences.length; j++) {
                if (!preferences[j].contains(first[i])){
                    include = false;
                }
            }
            if (include == true) {
                communal.add(first[i]);
            }
        }

        Object[] objectReturn = communal.toArray();

        String[] stringReturn = new String[objectReturn.length];

        for (int i = 0; i < objectReturn.length; i++) {
            stringReturn[i] = (String) objectReturn[i];
        }

        return stringReturn;

    }
}