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
     * List of edges that have this vertex as origin.
     */
    private LinkedList<Edge> edges;

    /**
     * Indicates if the vertex is already visited or not.
     * Must be set to false after every graph traversal.
     */
    private boolean visited;

    /**
     * Constructs a new vertex with a value but no edges.
     * @param value Value of the vertex.
     */
    public Vertex(T value) {
        this(value, new LinkedList<>(), false);
    }

    /**
     * Constructs a new vertex with a value, a set of edges and an initial value
     * that indicates if the vertex has already been visited or not.
     * @param value Value of the vertex.
     * @param edges Set of edges connected to this vertex as origin.
     * @param visited Indicates if this vertex has already been visited or not.
     */
    public Vertex(T value, LinkedList<Edge> edges, boolean visited) {
        this.value = value;
        this.edges = edges;
        this.visited = visited;
    }

    /**
     * Adds an edge to the vertex. It must have "this" vertex as origin and any other vertex as destination.
     * @param e The edge to add to the vertex.
     * @return True if conditions are respected and the adding succeeded. False otherwise.
     */
    public boolean addEdge(Edge e) {
        // The add() will be called only if the two previous conditions are true.
        return (e.getOrigin() == this) && (e.getDestination() != null) && this.edges.add(e);
    }

    /**
     * Removes an edge from the set of edges.
     * @param e The edge to remove.
     * @return True if the remove succeeded, false otherwise.
     */
    public boolean removeEdge(Edge e) {
        return this.edges.remove(e);
    }

    /**
     * Returns a string representation of the vertex.
     * (i.e. "Vertex : V
     *         {--> has an edge pointing to Vi, and a weight of Wi such that
     *               i = { 1, ..., this.edges.size()-1 },
 *                  Vi = vertex i,
     *              Wi = weight i} )
     * @return A string representation of the vertex.
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
     * Returns the value of the vertex.
     * @return The value of the vertex.
     */
    public T getValue() {
        return this.value;
    }

    /**
     * Returns the set of edges.
     * @return The set of edges.
     */
    public LinkedList<Edge> getEdges() {
        return this.edges;
    }

    /**
     * Returns a boolean that indicates if the vertex has been visited or not.
     * @return True if the vertex has been visited or not. False otherwise.
     */
    public boolean isVisited() {
        return this.visited;
    }


    // ============== SETTERS ============== //


    /**
     * Sets the value of the vertex.
     * @param value The new value of the vertex.
     */
    public void setValue(T value) {
        this.value = value;
    }

    /**
     * Sets the set of edges of the vertex.
     * @param edges The new set of edges.
     */
    public void setEdges(LinkedList<Edge> edges) {
        this.edges = edges;
    }

    /**
     * Defines if the vertex has been visited or not.
     * @param value the new boolean value
     */
    public void setVisited(boolean value) {
        this.visited = value;
    }

}
