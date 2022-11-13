public class TreeCount {
    public int count(TreeNode tree) {
        if (tree != null) {
            return 1 + count(tree.left) + count(tree.right);
        }
        return 0;
    }
}