public class Arete {
    private Sommet origine;
    private Sommet destination;
    private double label;

    public Arete() { this(null, null, -1); }

    public Arete(double label) { this(null, null, label); }

    public Arete(Sommet origine, Sommet destination, double label) {
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
