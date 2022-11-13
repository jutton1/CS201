public class HeightLabel {
    public TreeNode rewire(TreeNode t) {
        if (t != null) {
            int leftLVL = rewire(t.left).info;
            int rightLVL = rewire(t.right).info;
            t.info = 1 + Math.max(leftLVL, rightLVL);
            return t;
        }
        return new TreeNode(0);
    }
}