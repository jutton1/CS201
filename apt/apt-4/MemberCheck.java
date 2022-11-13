import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Collections;

public class MemberCheck {
    public String[] whosDishonest(String[] club1, String[] club2, String[] club3) {
        

        Set<String> club1Set = new HashSet<>(Arrays.asList(club1));
        Set<String> club2Set = new HashSet<>(Arrays.asList(club2));
        Set<String> club3Set = new HashSet<>(Arrays.asList(club3));

        HashMap <String, Integer> members = new HashMap<>();

        for (String member : club1Set) {
            members.putIfAbsent(member, 0);
            members.put(member, members.get(member) + 1);
        }
        for (String member : club2Set) {
            members.putIfAbsent(member, 0);
            members.put(member, members.get(member) + 1);
        }
        for (String member : club3Set) {
            members.putIfAbsent(member, 0);
            members.put(member, members.get(member) + 1);
        }
        ArrayList<String> duplicates = new ArrayList<String>();

        for (String member : members.keySet()) {
            if (members.get(member) > 1) {
                duplicates.add(member);
            }
        }

        Collections.sort(duplicates);

        String[] duplicatesArray = new String[duplicates.size()];
        duplicatesArray = duplicates.toArray(duplicatesArray);

        return duplicatesArray;
    }
}