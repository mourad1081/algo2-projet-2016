public class Arc {
    private Sommet origine;
    private Sommet destination;
    private double label;

    public Arc() { this(null, null, -1); }

    public Arc(double label) { this(null, null, label); }

    public Arc(Sommet origine, Sommet destination, double label) {
        this.setOrigine(origine);
        this.setDestination(destination);
        this.setLabel(label);
    }

    public Sommet getOrigine() {
        return origine;
    }

    public void setOrigine(Sommet origine) {
        this.origine = origine;
    }

    public Sommet getDestination() {
        return destination;
    }
    
    public void setDestination(Sommet destination) {
        this.destination = destination;
    }

    public double getLabel() {
        return label;
    }

    public void setLabel(double label) {
        this.label = label;
    }

    public String printDestination() {
        return this.destination.getValeur().toString();
    }
}
