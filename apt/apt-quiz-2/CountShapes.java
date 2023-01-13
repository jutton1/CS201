public class CountShapes {
    public int count(TreeNode countThis, TreeNode root) {
        int returnCount = firstHelper(root, countThis);
        System.out.println("balls " + returnCount);
        return returnCount;

        
    }

    private int firstHelper(TreeNode t, TreeNode r) {
        if (t != null) {
            int countLeft = firstHelper(t.left, r);
            int countRight = firstHelper(t.right, r);
            int myCount = helper(t, r);
            int totalCount = countLeft + countRight + myCount;
            //System.out.println(totalCount);
            return totalCount;
        }
        return 0;

    }

    private int helper(TreeNode t, TreeNode matchThis) {
        if (matchThis == null) return 1;
        if (t == null && matchThis != null) {
            //System.out.println("t is null, match is not");
            return 0;
        }
        if (t != null && matchThis.left == null && matchThis.right == null) {
            //System.out.println(3);
            return 1;
        }
        if (t != null && matchThis != null) {
            int matchLeft = helper(t.left, matchThis.left);
            int matchRight = helper(t.right, matchThis.right);
            //System.out.println("MatchLeft, MatchRight = " + matchLeft + ", " + matchRight + ". min is" + Math.min(matchLeft, matchRight)); 
            return (Math.min(matchLeft, matchRight));
        }
        System.out.println(4); 
        return 1;
        
    }
  }