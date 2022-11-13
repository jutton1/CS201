import java.util.Arrays;
import java.util.HashMap;

public class LeafTrails {

    HashMap<Integer,String> binaryCodes = new HashMap<>();

    public String[] trails(TreeNode tree) {
        helper(tree, "");

        Integer[] Keys = new Integer[binaryCodes.keySet().size()];
        int i = 0;
        for (Integer key: binaryCodes.keySet()) {
            Keys[i] = key;
            i ++;
        }

        Arrays.sort(Keys);
        String[] returnArray = new String[Keys.length];
        i = 0;
        for (Integer key : Keys) {
            returnArray[i] = binaryCodes.get(key);
            i++;
        }

        return returnArray;

    }

    private void helper(TreeNode t, String binaryPath) {
        if (t != null) {
            helper(t.left, binaryPath + "0");
            helper(t.right, binaryPath + "1");
            if (t.left == null && t.right == null) {
                binaryCodes.put(t.info, binaryPath);
            }
            return;
        }
        return;
    }
}

/*
 *         if (tree!=null) {
            String[] leftArray = trails(tree.left);
            String[] rightArray = trails(tree.right);
            if (leftArray.length != 0) {
                combine two arrays, one with 1 and one the reutnr.
            }
            
            
        }
        return new String[0];
 */

/*
 * //if (tree == null) return new String[0];
        if (tree.left == null && tree.right == ) return new String[]{tree.info};
        if (tree!= null) {
            String[] leftArray = trails(tree.left);
            String[] rightArray = trails(tree.right);
            String[] result = new String[leftArray.length + rightArray.length];
            System.arraycopy(leftArray, 0, result, 0, leftArray.length);
            System.arraycopy(rightArray, 0, result, leftArray.length, rightArray.length);
            return result;
        }
        return new String[0];
 */