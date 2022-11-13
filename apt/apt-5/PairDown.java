public class PairDown {
    public int[] fold(int[] list) {
        int[] foldedList;

        if (list.length % 2 == 1) {
            foldedList = new int[(list.length / 2) + 1];
            foldedList[foldedList.length - 1] = list[list.length - 1];

            for (int i = 0; i < foldedList.length - 1; i++) {
                foldedList[i] = list[2 * (i+1) - 1] + list[(2* (i+1)) - 2];
            }
        }

        else {
            foldedList = new int[(list.length / 2)];

            for (int i = 0; i < foldedList.length; i++) {
                foldedList[i] = list[2 * (i+1) - 1] + list[(2* (i+1)) - 2];
            }
        }

        return foldedList;
    }
}