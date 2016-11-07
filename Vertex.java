import java.util.LinkedList;

/**
 * A vertex which is composed of N weighted edges and an optional value.
 * @author Mourad, Mounir
 * @param <T> Value type of the vertex
 */
public class Vertex<T> {

    /**
     * Value of the vertex.
     */
    private T value;

    /**
     * List of edges that have this node for origin.
     */
    private LinkedList<Edge> edges;

    /**
     * Indicates if this vertex is already visited or not.
     * Must be set to false after every graph traversal.
     */
    private boolean visited;

    /**
     * Constructs a vertex without edges nor value.
     */
    public Vertex() {
        this(null, new LinkedList<>(), false);
    }

    /**
     * Constructs a new vertex with a value but no edges.
     * @param value Value of the vertex.
     */
    public Vertex(T value) {
        this(value, new LinkedList<>(), false);
    }

    /**
     * Constructs a new vertex with a value, a set of edges and an initial value
     * that indicates if this vertex has already been visited or not.
     * @param value Value of the vertex.
     * @param edges Set of edges connected to this vertex.
     * @param visited Indicates if this vertex has already been visited or not.
     */
    public Vertex(T value, LinkedList<Edge> edges, boolean visited) {
        this.value = value;
        this.edges = edges;
        this.visited = visited;
    }

    /**
     *
     * @param e
     * @return
     */
    public boolean addEdge(Edge e) {
        return this.edges.add(e);
    }

    /**
     *
     * @param e
     * @return
     */
    public boolean removeEdge(Edge e) {
        return this.edges.remove(e);
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        String s = "Vertex : " + this.value.toString() + "\n";
        for(Edge e : this.edges)
            s += " -> has an edge pointing to : " + e.printDestination() + ", and a weight of : " + e.getLabel() + "\n";
        return s;
    }

    // ============== GETTERS ============== //
    /**
     *
     * @return
     */
    public T getValue() {
        return this.value;
    }

    /**
     *
     * @return
     */
    public LinkedList<Edge> getEdges() {
        return this.edges;
    }

    /**
     *
     * @return
     */
    public boolean isVisited() {
        return this.visited;
    }


    // ============== SETTERS ============== //


    /**
     *
     * @param value
     */
    public void setValue(T value) {
        this.value = value;
    }

    /**
     *
     * @param edges
     */
    public void setEdges(LinkedList<Edge> edges) {
        this.edges = edges;
    }

    /**
     *
     * @param value
     */
    public void setVisited(boolean value) {
        this.visited = value;
    }

}
