public class SoccerLeagues {
    public int[] points(String[] matches) {
        // you write code here

        int[] teamPoints = new int[matches.length];

        int i = 0;
        for (String teamResults : matches) {
            char[] scoreChars = teamResults.toCharArray();
            int j = 0;
            for (char scoreChar : scoreChars) {

                if (scoreChar == 'W') {
                    teamPoints[i] += 3;
                }
                if (scoreChar == 'D') {
                    teamPoints[i] += 1;
                    teamPoints[j] += 1;
                }
                if (scoreChar == 'L') {
                    teamPoints[j] += 3;
                }
                j++;

            }
            i++;
        }

        return teamPoints;
        
    }
}