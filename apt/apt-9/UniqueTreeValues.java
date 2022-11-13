import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class UniqueTreeValues {
    HashSet<Integer> returnSet = new HashSet<Integer>();
    public int[] unique(TreeNode root) {
        
        findUnique(root);

        int[] returnArray = new int[returnSet.size()];
        int i = 0;
        for (Integer entry : returnSet) {
            returnArray[i] = entry;
            i++;
        }

        Arrays.sort(returnArray);
        return returnArray;
    }

    private void findUnique(TreeNode tree) {
        if (tree != null) {
            findUnique(tree.left);
            findUnique(tree.right);
            returnSet.add(tree.info);
        }
        
    }
}




/*
 * if (root != null) {
            int[] leftArray = unique(root.left);
            int[] rightArray = unique(root.right);
            int[] me = {root.info};
            int[] returnArray = new int[leftArray.length + rightArray.length + me.length];
            for (int i = 0; i < returnArray.length; i++) {
                if (i == 0) {
                    returnArray[i] = me[0];
                    continue;
                }
                if (i < (leftArray.length + 1)) {
                    returnArray[i] = leftArray[i - 1];
                    continue;
                }
                returnArray[i] = rightArray[i - leftArray.length - 1];
            }
            Arrays.sort(returnArray);
            int[] nodupReturnArray = new int [returnArray.length];
            int y = 0;
            for (int i = 0; i < returnArray.length; i++) {
                nodupReturnArray[y] = returnArray[i];
                while (returnArray[i] == returnArray[y] && i < returnArray.length) {
                    i++;
                }
                y++;
            }
            int[] finalReturn = new int [y];
            for (int i = 0; i < y; i++) {
                finalReturn[i] = nodupReturnArray[i];
            }
            
            return finalReturn;

        }

        return new int[0];
 */



/*
 * 
 * if (root == null) return new int[0];
        Set<Integer> returnSet = new HashSet<Integer>();
        returnSet.add(root.info);
        Set<Integer> leftSet = new HashSet<>(Arrays.asList(unique(root.left)));
        Set<Integer> rightSet = new HashSet<>(Arrays.asList(unique(root.right)));

        returnSet.addAll(leftSet);
        returnSet.addAll(rightSet);

        int x = 0;
        int[] returnA = new int[returnSet.size()];
        for(int i : returnSet){
            returnA[x] = i;
            x++;
        }
        Arrays.sort(returnA);
        return returnA;
 * 
 */