import java.util.ArrayList;
import java.util.HashSet;

public class Graph {
    private ArrayList<Vertex> roots;


    public Graph() {
        this.roots = new ArrayList<>();
    }

    /**
     * Constructs a graph thanks to a file which describes the graph.
     * @param path The path to the file.
     */
    public Graph(String path) {

    }

    public boolean addRoot(Vertex v) {
        return this.roots.add(v);
    }

    /**
     * (Resolves the exercise 2.1 of the project)
     * Simplify a graph according to the given instructions in exercise 2.1.
     * @param graph The graph to simplify
     * @return The simplified graph
     */
    public static Graph simplifyDebts(Graph graph) {
        // TODO : EXO 2.1
        return graph;
    }

    /**
     * (Resolves the exercise 2.2 of the project)
     * Returns the communities of the graph according to the given instructions in exercise 2.2.
     * @param graph The graph to identify communities
     * @return The list of set of persons
     */
    public static ArrayList<HashSet<Vertex>> identifyCommunities(Graph graph) {
        ArrayList<HashSet<Vertex>> communities = new ArrayList<>(); //Maybe there is a better structure
        // TODO : EXO 2.2
        return communities;
    }
}
