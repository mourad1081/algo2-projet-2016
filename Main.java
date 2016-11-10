/**
 * Classe principale du projet.
 * @author Mourad, Mounir
 */
public class Main {

    /**
     * Fonction principale du projet.
     * @param args Arguments optionnels du programme.
     *             S'il y en a un, il sera considéré comme le chemin vers le fichier décrivant un graphe.
     *             Sinon, un graphe telle que la figure 1 du PDF sera créé.
     */
    public static void main(String[] args) {
        Graphe g;
        g = args.length > 0 ?  new Graphe(args[0]) : Figure1();

        // Exercise 2.1
        Graphe.simplifyDebts(g);
        System.out.println(g);
        System.out.println("DEUXIEME APPEL");
        System.out.println(g);        System.out.println("DEUXIEME APPEL");
        System.out.println(g);

        g.resetVisites();
        // Exercise 2.2
        // TODO : replace "Object" by the correct type
        System.out.println(" ===== COMMUNITIES ====== ");
        System.out.println(Graphe.identifierCommunautes(g));



        // TODO : choose which optional exercises to do
    }


    /**
     * Créé un graphe comme celui de la figure 1 du fichier PDF du projet.
     * @return Le graphe de la figure 1
     */
    private static Graphe Figure1() {
        Graphe graph = new Graphe();
        // Sommets A B C D E F G H
        Sommet<String> A = new Sommet<>("A");
        Sommet<String> B = new Sommet<>("B");
        Sommet<String> C = new Sommet<>("C");
        Sommet<String> D = new Sommet<>("D");
        Sommet<String> E = new Sommet<>("E");
        Sommet<String> F = new Sommet<>("F");
        Sommet<String> G = new Sommet<>("G");
        Sommet<String> H = new Sommet<>("H");

        // Creation des arcs
        Arc AB = new Arc(A, B, 10);
        Arc AC = new Arc(A, C, 50);
        Arc BA = new Arc(B, A, 20);
        Arc BH = new Arc(B, H, 40);
        Arc CB = new Arc(C, B, 30);
        Arc CD = new Arc(C, D, 40);
        Arc DE = new Arc(D, E, 15);
        Arc EF = new Arc(E, F, 25);
        Arc FD = new Arc(F, D, 50);
        Arc EG = new Arc(E, G, 50);
        Arc GE = new Arc(G, E, 50);

        // Connexions
        A.ajouterConnexion(AB);
        A.ajouterConnexion(AC);
        B.ajouterConnexion(BA);
        B.ajouterConnexion(BH);
        C.ajouterConnexion(CB);
        C.ajouterConnexion(CD);
        D.ajouterConnexion(DE);
        E.ajouterConnexion(EF);
        E.ajouterConnexion(EG);
        F.ajouterConnexion(FD);
        G.ajouterConnexion(GE);

        // sommets L M N
        Sommet<String> L = new Sommet<>("L");
        Sommet<String> M = new Sommet<>("M");
        Sommet<String> N = new Sommet<>("N");

        // création des arcs
        Arc LM = new Arc(L, M, 20);
        Arc LN = new Arc(L, N, 60);
        Arc MN = new Arc(M, N, 10);

        // Ajout des connexions
        L.ajouterConnexion(LM);
        L.ajouterConnexion(LN);
        M.ajouterConnexion(MN);

        // Ajout des sommets racines au graphe
        graph.addRoot(A);
        graph.addRoot(L);

        return graph;
    }
}
