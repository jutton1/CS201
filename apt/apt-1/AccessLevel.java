public class AccessLevel {
    public String canAccess(int[] rights, int minPermission) {
        StringBuilder access = new StringBuilder();
        for (int i = 0; i < rights.length; i++) {
            if (rights[i] < minPermission) {
                access.append("D");
            }
            else {
                access.append("A");
            }
        }
        return access.toString();
    }
 }