public class AddAt {
    public ListNode addAt(ListNode list, ListNode toAdd, int index) {
        if (list == null) return toAdd;
        if (toAdd == null) return list;
        ListNode myNextReference = list;

        for (int i = 0; i < index; i++) {
            myNextReference = myNextReference.next;
        }
        ListNode myPreviousReference = list;
        if (index > 0) {
            for (int i = 1; i < index; i++) {
                myPreviousReference = myPreviousReference.next;
            }
        }
        if (myPreviousReference != list || index == 1) {
            myPreviousReference.next = toAdd;
            while (toAdd.next != null) {
                toAdd = toAdd.next;
            }
            toAdd.next = myNextReference;
        }
        else {
            ListNode head = toAdd;
            while (toAdd.next != null) {
                toAdd = toAdd.next;
            }
            toAdd.next = list;
            return head;
        }

        return list;
    }
  }