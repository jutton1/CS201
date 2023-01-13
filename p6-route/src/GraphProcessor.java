import java.security.InvalidAlgorithmParameterException;
import java.util.List;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Stack;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Models a weighted graph of latitude-longitude points
 * and supports various distance and routing operations.
 * To do: Add your name(s) as additional authors
 * @author Brandon Fain
 * @author Jake Wolfram
 * @author Joshua Dutton
 *
 */
public class GraphProcessor {

    private ArrayList<Point> nodes = new ArrayList<Point>();       // list of all nodes
    private HashMap<Point, HashSet<Point>> adjacent = new HashMap<Point, HashSet<Point>>(); //Map of point, with the values the adjacent points

    private HashMap<Point, Double> distance = new HashMap<Point, Double>();  // Stores distance of a point
    
    private HashMap<Point, Point> previous = new HashMap<Point, Point>();   //for dijkstras 
    private HashSet<Point> visited = new HashSet<Point>();          //for dijkrstras

    


    /**
     * Creates and initializes a graph from a source data
     * file in the .graph format. Should be called
     * before any other methods work.
     * @param file a FileInputStream of the .graph file
     * @throws Exception if file not found or error reading
     */
    public void initialize(FileInputStream file) throws Exception {
        Scanner s = new Scanner(file);  //use scanner to scan through data
        int nNodes = s.nextInt();       //number of nodes
        int nEdges = s.nextInt();       //number of edges
        s.nextLine();

        for (int i = 0; i< nNodes; i++){        //for every node, go through and get its latitude and longitude
            s.next();
            double latitude = s.nextDouble();
            double longitude = s.nextDouble();
            Point p = new Point(latitude, longitude);   //create the point from the longitude and latitude
            nodes.add(p);       //add to set of nodes

            if (!adjacent.containsKey(p)){ 
                HashSet<Point> edges = new HashSet<>();
                adjacent.put(p,edges);             //put the node in the hashset where the key is the node and edges are the values
            }
            s.nextLine();
        }
        for (int i = 0; i< nEdges; i++){            //for every edge, go through, add each node to each other's adjacent list in the hashset
            int node1 = s.nextInt();
            int node2 = s.nextInt();
            adjacent.get(nodes.get(node1)).add(nodes.get(node2));
            adjacent.get(nodes.get(node2)).add(nodes.get(node1));
            if (s.hasNextLine()){           //if there are more nodes do this again
                s.nextLine();
            }
        }
        s.close();
    }


    /**
     * Searches for the point in the graph that is closest in
     * straight-line distance to the parameter point p
     * @param p A point, not necessarily in the graph
     * @return The closest point in the graph to p
     */
    public Point nearestPoint(Point p) {
        Point closest = nodes.get(0);                       //placeholder for our closest point
        double closestDistance = nodes.get(0).distance(p);  //placeholder for our closest point's distance
        
        for (int i = 1; i<nodes.size(); i++){               //for every node go through and compare the distance to the other ones
            
            if (nodes.get(i).distance(p) < closestDistance){      //if closer than the previous closest, replace it
                closest = nodes.get(i);
                closestDistance = nodes.get(i).distance(p);
            }
        }
        return closest;
    }


    /**
     * Calculates the total distance along the route, summing
     * the distance between the first and the second Points, 
     * the second and the third, ..., the second to last and
     * the last. Distance returned in miles.
     * @param start Beginning point. May or may not be in the graph.
     * @param end Destination point May or may not be in the graph.
     * @return The distance to get from start to end
     */
    public double routeDistance(List<Point> route) {
        double dist = 0.0;
        for (int i = 0; i< route.size()-1;i++){     //for every node in the route, go through, add the distance between the current node and node next in the list
            dist+= route.get(i).distance(route.get(i+1));
        }
        return dist;
    }
    

    /**
     * Checks if input points are part of a connected component
     * in the graph, that is, can one get from one to the other
     * only traversing edges in the graph
     * @param p1 one point
     * @param p2 another point
     * @return true if p2 is reachable from p1 (and vice versa)
     */
    public boolean connected(Point p1, Point p2) {
        if (!nodes.contains(p1) || !nodes.contains(p2)) return false; //they're not in the list
        if (p1 ==p2) return true; // same point
        visited.clear(); //must clear before doing DFS
        DFS(p1);
        if (visited.contains(p2)){      //checks the visited, after DFS is performed and is in visited, connected
            return true;
        }

        return false;
    }

    // Depth First Search for use in connected, does a normal DFS
    private void DFS(Point p){      
        Stack<Point> exp = new Stack<>();
        Point current = p;
        exp.push(current);
        visited.add(current);
        while (!exp.isEmpty()){
            current = exp.pop();
            for (Point point: adjacent.get(current)){
                if (!visited.contains(point)){
                    previous.put(point, current);
                    visited.add(point);
                    exp.push(point);
                }
            }
        }
    }

    /**
     * Returns the shortest path, traversing the graph, that begins at start
     * and terminates at end, including start and end as the first and last
     * points in the returned list. If there is no such route, either because
     * start is not connected to end or because start equals end, throws an
     * exception.
     * @param start Beginning point.
     * @param end Destination point.
     * @return The shortest path [start, ..., end].
     * @throws InvalidAlgorithmParameterException if there is no such route, 
     * either because start is not connected to end or because start equals end.
     */
    public List<Point> route(Point start, Point end) throws InvalidAlgorithmParameterException {
        if (!adjacent.keySet().contains(start) || !adjacent.keySet().contains(end) || start.equals(end) || connected(start, end)==false){
            throw new InvalidAlgorithmParameterException("No path between start and end");
        }

        Map<Point, Double> distance = new HashMap<>();      //initialize doubel
        List<Point> route = new ArrayList<>();              //initialize route
        Map<Point, Point> previous = new HashMap<>();
        Comparator<Point> comp = (Point a, Point b) -> Double.compare(distance.get(a), distance.get(b));
        PriorityQueue<Point> toEx = new PriorityQueue<>(comp);          //priority queue based on distance

        Point current = start;          // start at the start? duh
        distance.put(current, 0.0);
        toEx.add(current);
        while (!toEx.isEmpty()){        
            current = toEx.remove();                // Do BFS
            for (Point adj: adjacent.get(current)){
                double weight = current.distance(adj);
                if (!distance.containsKey(adj)||distance.get(adj) > distance.get(current) + weight) {
                    distance.put(adj, distance.get(current)+weight);
                    previous.put(adj, current);
                    toEx.add(adj);
                }
            }
        }
        current = end;
        while (!current.equals(start)){   
            route.add(current);
            current = previous.get(current);
        }
        route.add(start);
        Collections.reverse(route);     //have to reverse order first
        return route;
    }

    
}
