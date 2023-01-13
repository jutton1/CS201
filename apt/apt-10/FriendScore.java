public class FriendScore {
    public int highestScore(String[] friends) {
        int[] friendsCounts = new int[friends.length];
        for (int i = 0; i < friendsCounts.length; i ++) {
            for (int y = 0; y < friends[i].length(); y++) {
                if (friends[i].charAt(y) == 'Y') {
                    friendsCounts[i] ++;
                }
                else {
                    // figure out it there is a common friend.
                }
            }
        }

        int maxFriends = 0;
        for (int friendsNum : friendsCounts) {
            if (friendsNum > maxFriends) {
                maxFriends = friendsNum;
            }
        }

        return maxFriends;
    }
 }