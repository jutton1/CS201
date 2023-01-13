import java.util.Collections;
import java.util.PriorityQueue;

public class OlympicCandles{
    public int numberOfNights(int[] candles){
        int days = 0;
        PriorityQueue<Integer> candlesQueue = new PriorityQueue<Integer>(candles.length, Collections.reverseOrder());
        for (Integer candle : candles) {
            candlesQueue.add(candle);
        }
        int returnDays = helper(candlesQueue, days);
        if (returnDays > 0) returnDays --;

        return returnDays;
    }

    private int helper(PriorityQueue<Integer> candlesQueue, int days) {
        Integer[] currentCandles = new Integer[days];
        
        for (int i = 0; i < days; i++) {
            if (candlesQueue.peek() != null && candlesQueue.peek() > 0) {
                currentCandles[i] = candlesQueue.remove();
                currentCandles[i] --;
            }
            else {
                return days;
            }
        }

        for (int i = 0; i < days; i++) {
            candlesQueue.add(currentCandles[i]);
        }
        days ++;
        days = helper(candlesQueue, days);

        return days;

    }
  }