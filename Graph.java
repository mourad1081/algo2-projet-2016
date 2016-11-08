import java.util.ArrayList;
import java.util.HashSet;

public class Graph {
    private ArrayList<Vertex> roots;
    // Private attribute used to print the graph
    private String print;

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

    private static void depthFirstTraversal(Vertex v) {
        System.out.println(v);
        v.setVisited(true);
        for(int i = 0; i < v.getEdges().size(); i++) {
            if(((Edge) v.getEdges().get(i)).getDestination().isVisited())
                depthFirstTraversal(v);
        }
    }

    /**
     * (Resolves the exercise 2.2 of the project)
     * Returns the communities of the graph according to the given instructions in exercise 2.2.
     * @param graph The graph to identify communities
     * @return The list of communities
     */
    public static ArrayList<Community> identifyCommunities(Graph graph) {
        ArrayList<Community> communities = new ArrayList<>(); 
        // TODO : EXO 2.2
        for(int i = 0; i < graph.roots.size(); i++) {
            communities.add(new Community());
            addToCommunityRecur(communities.get(i), graph.roots.get(i));
            // Unmark the vertices after the traversal
            graph.unvisitAll(graph.roots.get(i));
        }
        return communities;
    }
    
    private static void addToCommunityRecur(Community c, Vertex v) {
        c.add(v);
        v.setVisited(false);
        for(int i = 0; i < v.getEdges().size(); i++) {
            if((((Edge) v.getEdges().get(i)).getDestination().isVisited()))
                addToCommunityRecur(c, ((Edge) v.getEdges().get(i)).getDestination());
        }
    }

    @Override
    public String toString() {
        this.print = "";
        for(int i = 0; i < roots.size(); i++) {
            this.print += "\n === Graphe === ";
            graphString(roots.get(i));
            // Unmark the vertices after the traversal
            unvisitAll(roots.get(i));
        }
        return this.print;
    }

    private void unvisitAll(Vertex v) {
        this.print += v.toString();
        v.setVisited(false);
        for(int i = 0; i < v.getEdges().size(); i++) {
            if((((Edge) v.getEdges().get(i)).getDestination().isVisited()))
                unvisitAll(((Edge) v.getEdges().get(i)).getDestination());
        }   
    }

    private void graphString(Vertex v) {
        this.print += v.toString();
        v.setVisited(true);
        for(int i = 0; i < v.getEdges().size(); i++) {
            if( !(((Edge) v.getEdges().get(i)).getDestination().isVisited()))
                graphString(((Edge) v.getEdges().get(i)).getDestination());
        }
    }
}
