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
        Graphe graph;
        graph = args.length > 0 ?  new Graphe(args[0]) : Figure1();

        // Exercise 2.1
        Graphe.simplifyDebts(graph);
        System.out.println(graph);
        System.out.println("DEUXIEME APPEL");
        System.out.println(graph);        System.out.println("DEUXIEME APPEL");
        System.out.println(graph);

        // Exercise 2.2
        // TODO : replace "Object" by the correct type
        Object c = Graphe.identifyCommunities(graph);
        System.out.println(" ===== COMMUNITIES ====== ");
        System.out.println(c);
        

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

        // Creation des arrêtes
        Arete AB = new Arete(A, B, 10);
        Arete AC = new Arete(A, C, 50);
        Arete BA = new Arete(B, A, 20);
        Arete BH = new Arete(B, H, 40);
        Arete CB = new Arete(C, B, 30);
        Arete CD = new Arete(C, D, 40);
        Arete DE = new Arete(D, E, 15);
        Arete EF = new Arete(E, F, 25);
        Arete FD = new Arete(F, D, 50);
        Arete EG = new Arete(E, G, 50);
        Arete GE = new Arete(G, E, 50);

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

        // création des arrêtes
        Arete LM = new Arete(L, M, 20);
        Arete LN = new Arete(L, N, 60);
        Arete MN = new Arete(M, N, 10);

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
