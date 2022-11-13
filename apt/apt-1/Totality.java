public class Totality {
    public int sum(int[] a, String stype) {
        int even = 0;
        int odd = 0;
        for (int i = 0; i < a.length; i++) {
            if (i % 2 == 0) {
                even += a[i];
            }
            else {
                odd += a[i];
            }
        }
        if (stype.equals("odd")) {
            return odd;
        }
        else if (stype.equals("even")) {
            return even;
        }
        else {
            return odd + even;
        }
    }
}