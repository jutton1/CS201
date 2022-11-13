import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



public class LeafCollector {
    HashMap<Integer, String> removals = new HashMap<>();
    public String[] getLeaves(TreeNode tree) {

        ArrayList<String> returnArrayList = new ArrayList<String>();
        int i = 0;
        while (isLeaf(tree) == false) {
            collectAndRemove(tree, i);
            System.out.println(removals);
            i++;
        }
        removals.put(i, "" + tree.info);
        String[] returnArray = new String[i + 1];
        for (i = 0; i < returnArray.length; i++) {
            returnArray[i] = removals.get(i);
        }
        return returnArray;
    }

    private void collectAndRemove(TreeNode root, Integer i) {
        // String returnString = new String("");

        System.out.println("we are in collectAndRemove");
        
        if (isLeaf(root.left)) {
            System.out.println(root.left.info);
            removals.putIfAbsent(i, "");
            if (removals.get(i).compareTo("") == 0) removals.put(i, "" + root.left.info);
            else {
                removals.put(i, removals.get(i) + " " + root.left.info);
            }
            root.left = null;
        }
        else if (root.left != null) collectAndRemove(root.left, i);
        if (isLeaf(root.right)) {
            System.out.println(root.right.info);
            removals.putIfAbsent(i, "");
            if (removals.get(i).compareTo("") == 0) removals.put(i, "" + root.right.info);
            else {
                removals.put(i, removals.get(i) + " " + root.right.info);
            }
            root.right = null;
        }
        else if (root.right != null) collectAndRemove(root.right, i);
        
        return;        

    }
    public boolean isLeaf(TreeNode t) {
        if (t == null) {
            return false;
        }

        if (t.left == null && t.right == null) {
            return true;
        }
        return false;
    }
}

/*
 * HashMap<Integer, String> removals = new HashMap<>();
    public String[] getLeaves(TreeNode tree) {
        int i = 0;

        while (tree.left != null && tree.right != null) {
            helper (tree, i);
            i++;
        }

        String[] returnArray = new String[removals.keySet().size()];
        for (i = 0; i < returnArray.length; i ++) {
            returnArray[i] = removals.get(i);
        }
        return returnArray;
    }

    private int helper(TreeNode t, int i) {
        if (t != null) {
            helper(t.left, i);//t.left = null;
            if (t.left != null && t.left.left == null && t.left.right == null) {
                t.left = null;
            }
            helper(t.right, i);// t.right = null;
            if (t.right != null && t.right.left == null && t.right.right == null) {
                t.right = null;
                return 0;
            }
            if (t.left == null && t.right == null) {
                removals.putIfAbsent(i, "");
                if (removals.get(i) == "") removals.put(i, "" + t.info);
                else removals.put(i, removals.get(i) + " " + t.info);
                return 0;
            }
        }
        
        return 0;
    }
 */

/*
 * 
 * 
 * 
 * 
 * if (tree != null) {
            String[] right = getLeaves(tree.right);
            String[] left = getLeaves(tree.left);

            String[] me = new String[]{String.valueOf(tree.info)};
            String[] returnArray = new String[right.length + left.length + me.length];
            for (int i = 0; i < returnArray.length; i++) {
                if (i<me.length) returnArray[i] = me[i];
                else if (i<left.length + me.length) returnArray[i] = left[i - me.length];
                else returnArray[i] = right[i - me.length - left.length];
            }
            return returnArray;
        }
        
        return new String[0];
 */