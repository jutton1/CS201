public class RemoveMin {
    public ListNode remove (ListNode list) {
        ListNode first = new ListNode(list.info, list.next);
        int min = list.info;
        while (list.next != null) {
            if (list.info < min) {
                min = list.info;
            }
            list = list.next;
        }

        if (list.info < min) {
            min = list.info;
        }

        list = first;
        ListNode previous = list;

        if (list.info == min) {
            return list.next;
        }

        list = list.next;

        while (list.next != null) {
            if (list.info == min) {
                previous.next = list.next;
                return first;
            }
            list = list.next;
            previous = previous.next;

        }

        if (list.info == min) {
            previous.next = null;
        }

        return first;
    }
}