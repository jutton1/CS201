import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ErdosNumber {
    public String[] calculateNumbers(String[] pubs) {
        ArrayList<MapNode> authors = new ArrayList<MapNode>();
        ArrayList<String> bcsISuckAtCoding = new ArrayList<String>();

        for (String pub : pubs) {
            String[] pubAuthors = pub.split(" ");
            for (int i = 0; i < pubAuthors.length; i++) {
                if (!bcsISuckAtCoding.contains(pubAuthors[i])) {
                    MapNode myTempAuthor = new MapNode(pubAuthors[i]);
                    authors.add(myTempAuthor);
                    bcsISuckAtCoding.add(pubAuthors[i]);
                }
                
                for (int j = i + 1; j < pubAuthors.length; i++) {
                    MapNode myTempAuthor = new MapNode()
                    if (authors.contains(pubAuthors[j])) {
                        for (int k = 0; k < bcsISuckAtCoding.size(); k++) {

                        }
                    }
                }
                
            }
        }
    }
}

public class MapNode implements Comparable {
    String info;
    Set<MapNode> connections;

    MapNode(String info) {
        this.info = info;
    }

    void connect(MapNode connection) {
        connections.add(connection);
    }

    @Override
    public int compareTo(MapNode otherNode) {
        return String.compare(this.info, otherNode.info);
    }


}