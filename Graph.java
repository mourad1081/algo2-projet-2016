import java.util.ArrayList;

public class Graph {
    private ArrayList<Vertex> roots;


    public Graph() {
        this(new ArrayList<>());
    }

    public Graph(ArrayList<Vertex> roots) {
        this.roots = roots;
    }

    public boolean addRoot(Vertex v) {
        return this.roots.add(v);
    }

    
}
