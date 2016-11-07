import java.util.LinkedList;

public class Vertex<T> {
  private T value;
  private LinkedList<Edge> edges;
  private boolean visited;

  public Vertex() {
    this(null, new LinkedList<>(), false);
  }

  public Vertex(T value) {
    this(value, new LinkedList<>(), false);
  }

  public Vertex(T value, LinkedList<Edge> edges, boolean visited) {
    this.value = value;
    this.edges = edges;
    this.visited = visited;
  }

  public boolean addEdge(Edge e) {
    return this.edges.add(e);
  }

  public boolean removeEdge(Edge e) {
    return this.edges.remove(e);
  }

  // Getters
  public T getValue() { return this.value; }
  public LinkedList<Edge> getEdges() { return this.edges; }
  public boolean isVisited() { return this.visited; }

  // Setters
  public void setValue(T value) { this.value = value; }
  public void setEdges(LinkedList<Edge> edges) { this.edges = edges; }
  public void setVisited(boolean value) { this.visited = value; }

}
