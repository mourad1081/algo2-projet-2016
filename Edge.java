public class Edge {
    private Vertex origin;
    private Vertex destination;
    private int label;

    public Edge() { this(null, null, -1); }

    public Edge(int label) { this(null, null, label); }

    public Edge(Vertex origin, Vertex destination, int label) {
        this.setOrigin(origin);
        this.setDestination(destination);
        this.setLabel(label);
    }

    public Vertex getOrigin() {
        return origin;
    }
    public void setOrigin(Vertex origin) {
        this.origin = origin;
    }

    public Vertex getDestination() {
        return destination;
    }
    public void setDestination(Vertex destination) {
        this.destination = destination;
    }

    public int getLabel() {
        return label;
    }
    public void setLabel(int label) {
        this.label = label;
    }

    public String printDestination() {
        return this.destination.getValue().toString();
    }
}
