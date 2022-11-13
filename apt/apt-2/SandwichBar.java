import java.util.Arrays;

public class SandwichBar {
   public int whichOrder(String[] available, String[] orders){
      int viable = 0;
      for (int y = 0; y < orders.length; y++) {
         String[] splitOrders = orders[y].split(" ");
         for (int z = 0; z < splitOrders.length; z++) {
            if (!Arrays.asList(available).contains(splitOrders[z])) {
               viable ++;
            }
         }
         if (viable == 0) {
            return y;
         }
         else {
            viable = 0;
         }
         
      }
      return -1; 
    }
 }