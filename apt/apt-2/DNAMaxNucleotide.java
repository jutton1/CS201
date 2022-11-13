
public class DNAMaxNucleotide {
    /**
     * @param strands Input array of DNA strands
     * @param nuc the "target" nucleotide which will be looked for within the input strands
     * @return the longest String in strands holding the greatest number of instances of nuc
     */
    public String max(String[] strands, String nuc) {
        String DNAMax = "";
        int[] tracker = new int[4];
        tracker[0] = 0;
        tracker[1] = 0;

        // tracker[0] current number of nuc found in current strands.
        // tracker[1] is the current found max # of String nuc.
        // tracker[2] is the length of the current max string
        // tracker[3] is the current location of that string
        for (int i = 0; i < strands.length; i++) {
            for(int y = 0; y < strands[i].length(); y++) {
                if (nuc.equals(String.valueOf(strands[i].charAt(y)))) {
                    tracker[0] ++;
                }
            }
            if ((tracker[0] > tracker[1]) || (tracker[0] == tracker[1] && tracker[2] < strands[i].length())) {
                tracker[1] = tracker[0];
                tracker[2] = strands[i].length();
                tracker[3] = i;
            }

            tracker[0] = 0;

        }

        DNAMax = strands[tracker[3]];
        if (tracker[1] == 0) {
            return "";
        }
        return DNAMax;
    }
 }