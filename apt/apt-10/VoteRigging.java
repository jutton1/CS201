import java.util.Collections;
import java.util.PriorityQueue;

public class VoteRigging {
    public int minimumVotes(int[] votes) {
        if (votes.length < 2) return 0;
        PriorityQueue<Integer> votesQueue = new PriorityQueue<Integer>(votes.length - 1, Collections.reverseOrder());

        for (int i = 1; i < votes.length; i++) {
            votesQueue.add(votes[i]);
        }
        int myCandidate = votes[0];
        int changedVotesCount = helper(votesQueue, myCandidate);

        return changedVotesCount;
    }

    private int helper(PriorityQueue<Integer> votesQueue, int myCandidate) {
        int changedVotesCount = 0;
        int topCandidate = votesQueue.remove();
        if (topCandidate >= myCandidate) {
            topCandidate --;
            myCandidate ++;
            changedVotesCount ++;
            votesQueue.add(topCandidate);
            changedVotesCount += helper(votesQueue, myCandidate);
        }
        return changedVotesCount;
    }
 }