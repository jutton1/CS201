import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class DepthOrder {

    HashMap<Integer, ArrayList<Integer>> depthMap = new HashMap<Integer, ArrayList<Integer>>();

    public int[] order(TreeNode root) {

        ArrayList<Integer> myArrayList = new ArrayList<Integer>();

        helper(root, 0);
        for (int i = 0; i < depthMap.keySet().size(); i ++) {
            for (int y = 0; y < depthMap.get(i).size(); y ++) {
                myArrayList.add(depthMap.get(i).get(y));
            }
        }
        int[] returnList = new int[myArrayList.size()];
        for (int i = 0; i < returnList.length; i++) {
            returnList[i] = myArrayList.get(i);
        }
        return returnList;
    }

    private void helper(TreeNode t, int level) {
        ArrayList<Integer> currentList = new ArrayList<Integer>();
        if (t != null) {
            helper(t.left, level + 1);
            helper(t.right, level + 1);
            
            if (!depthMap.containsKey(level)) {
                currentList.add(t.info);
                depthMap.putIfAbsent(level, currentList);
            }
            else {
                for (Integer entry : depthMap.get(level)) {
                    currentList.add(entry);
                }
                currentList.add(t.info);
                Collections.sort(currentList);
                depthMap.put(level, currentList);
            }
        }
        return;
    }
}