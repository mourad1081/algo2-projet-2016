public class Edge {
    private Vertex origin;
    private Vertex destination;
    private double label;

    public Edge() { this(null, null, -1); }

    public Edge(double label) { this(null, null, label); }

    public Edge(Vertex origin, Vertex destination, double label) {
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

    public double getLabel() {
        return label;
    }

    public void setLabel(double label) {
        this.label = label;
    }

    public String printDestination() {
        return this.destination.getValue().toString();
    }
}
