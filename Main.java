import java.util.ArrayList;

/**
 * The main class of the project
 * @author Mourad, Mounir
 */
public class Main {

    /**
     * The main function of the project.
     * @param args Optional arguments to the program. If there is one,
     *             We consider that it's the path of a file that describes a graph to create.
     */
    public static void main(String[] args) {
        Graph graph;
        graph = args.length > 0 ?  new Graph(args[0]) : Figure1();

        // Exercise 2.1
        Graph.simplifyDebts(graph);
        System.out.println(graph);
        System.out.println("DEUXIEME APPEL");
        System.out.println(graph);        System.out.println("DEUXIEME APPEL");
        System.out.println(graph);

        // Exercise 2.2
        // TODO : replace "Object" by the correct type
        Object c = Graph.identifyCommunities(graph);
        System.out.println(" ===== COMMUNITIES ====== ");
        System.out.println(c);
        

        // TODO : choose which optional exercises to do
    }

    public static void s(ArrayList<String> x ) { x.add("aaa"); }
    /**
     * Creates a graph according to the figure 1 of the PDF project file (for tests purpose)
     * @return The graph at figure 1 of the PDF project file.
     */
    private static Graph Figure1() {
        Graph graph = new Graph();

        // vertices A B C D E F G H
        Vertex<String> A = new Vertex<>("A");
        Vertex<String> B = new Vertex<>("B");
        Vertex<String> C = new Vertex<>("C");
        Vertex<String> D = new Vertex<>("D");
        Vertex<String> E = new Vertex<>("E");
        Vertex<String> F = new Vertex<>("F");
        Vertex<String> G = new Vertex<>("G");
        Vertex<String> H = new Vertex<>("H");

        // Create edges
        Edge AB = new Edge(A, B, 10);
        Edge AC = new Edge(A, C, 50);
        Edge BA = new Edge(B, A, 20);
        Edge BH = new Edge(B, H, 40);
        Edge CB = new Edge(C, B, 30);
        Edge CD = new Edge(C, D, 40);
        Edge DE = new Edge(D, E, 15);
        Edge EF = new Edge(E, F, 25);
        Edge FD = new Edge(F, D, 50);
        Edge EG = new Edge(E, G, 50);
        Edge GE = new Edge(G, E, 50);

        // Make connections
        A.addEdge(AB);
        A.addEdge(AC);
        B.addEdge(BA);
        B.addEdge(BH);
        C.addEdge(CB);
        C.addEdge(CD);
        D.addEdge(DE);
        E.addEdge(EF);
        E.addEdge(EG);
        F.addEdge(FD);
        G.addEdge(GE);

        // vertices L M N
        Vertex<String> L = new Vertex<>("L");
        Vertex<String> M = new Vertex<>("M");
        Vertex<String> N = new Vertex<>("N");

        // creating edges
        Edge LM = new Edge(L, M, 20);
        Edge LN = new Edge(L, N, 60);
        Edge MN = new Edge(M, N, 10);

        // Adding connections
        L.addEdge(LM);
        L.addEdge(LN);
        M.addEdge(MN);

        // Adding root vertices to the graph
        graph.addRoot(A);
        graph.addRoot(L);

        return graph;
    }
}
