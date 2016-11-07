import java.util.HashMap;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph();
        // graph of the figure 1 of the project file
        // Graph L_M_N

        Vertex<String> M = new Vertex<>("M");
        Vertex<String> N = new Vertex<>("N");
        Vertex<String> L = new Vertex<>("L");
        Edge MN = new Edge(M, N, 10);
        Edge LM = new Edge(L, M, 20);
        Edge LN = new Edge(L, N, 60);
        M.addEdge(MN);
        L.addEdge(LM);
        L.addEdge(LN);

        // Graph A_B_C_D_E_F_G_H
        Vertex<String> A = new Vertex<>("A");
        Vertex<String> B = new Vertex<>("B");
        Vertex<String> C = new Vertex<>("C");
        Vertex<String> D = new Vertex<>("D");
        Vertex<String> E = new Vertex<>("E");
        Vertex<String> F = new Vertex<>("F");
        Vertex<String> G = new Vertex<>("G");
        Vertex<String> H = new Vertex<>("H");
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

        // Add an edge to the graph
        System.out.println(A);
        graph.addRoot(A);
        graph.addRoot(L);
    }
}
