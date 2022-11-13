public class ListSum {
    public int sum(ListNode list, int thresh) {
        int summation = 0;
        if (list == null) {
            return 0;
        }
        while (list.next != null) {
            if (list.info > thresh) {
                summation += list.info;
            }
            list = list.next;
        }

        if (list.info > thresh) {
            summation += list.info;
        }

        return summation;
    }
}