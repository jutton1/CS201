public class TrueSpace {
    public long calculateSpace(int[] sizes, int clusterSize) {
        long totalSpace = 0;
        for (int i = 0; i < sizes.length; i++) {
            totalSpace += (sizes[i] / clusterSize) * clusterSize;
            if ((sizes[i] % clusterSize) > 0) {
                totalSpace += clusterSize;
            }
            

       }
        return totalSpace;
    }
 }