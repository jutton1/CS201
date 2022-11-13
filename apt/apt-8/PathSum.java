public class PathSum {
    public int hasPath(int target, TreeNode tree){
        if (tree != null) {
            
            if (tree.info == target && tree.left == null && tree.right == null) {
                return 1;
            }

            return Math.max(hasPath(target - tree.info, tree.left),
            hasPath(target - tree.info, tree.right));

        }
        return 0;
    }
}