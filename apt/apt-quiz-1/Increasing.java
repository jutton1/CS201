import java.util.ArrayList;
import java.util.List;

public class Increasing {
    public int[] getIncreasing(int[] numbers) {
        List<Integer> increasing = new ArrayList<Integer>();
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (i == 0) {
                increasing.add(numbers[i]);
                continue;
            }
            if (numbers[i] > increasing.get(count)) {
                increasing.add(numbers[i]);
                count ++;
            }
        }

        Object[] objectReturn = increasing.toArray();

        int[] intReturn = new int[objectReturn.length];

        for (int i = 0; i < objectReturn.length; i++) {
            intReturn[i] = (Integer) objectReturn[i];
        }

        return intReturn;
    }
}