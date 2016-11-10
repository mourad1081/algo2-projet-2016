import java.util.ArrayList;

public class Graphe {

    private ArrayList<Sommet> racines;

    // Attribut utilisé pour l'affichage d'un graphe.
    private String affichage;

    public Graphe() {
        this.racines = new ArrayList<>();
    }

    /**
     * Construit un graphe correspondant à un fichier dont le chemin est donné en argument.
     * @param path Le chemin du fichier à parser
     */
    public Graphe(String path) {

    }

    public boolean addRoot(Sommet v) {
        return this.racines.add(v);
    }


    /**
     * <strong>(Résout l'exercice 2.1 du projet)</strong>
     * Simplifie un graphe d'après les instructions donné dans le fichier PDF.
     * @param graph Le graphe à simplifier.
     * @return Le graphe simplifié.
     */
    public static Graphe simplifyDebts(Graphe graph) {
        // TODO : EXO 2.1
        return graph;
    }

    private static void depthFirstTraversal(Sommet v) {
        System.out.println(v);
        v.setVisited(true);
        for(int i = 0; i < v.getAretes().size(); i++) {
            if(((Arete) v.getAretes().get(i)).getDestination().isVisited())
                depthFirstTraversal(v);
        }
    }

    /**
     * <strong>(Résout l'exercice 2.2 du projet)</strong>
     * Retourne la liste des communautés du graphe donné en paramètre.
     * @param graph La graphe dont on doit identifier les communautés.
     * @return La liste des communautés.
     */
    public static ArrayList<Communaute> identifyCommunities(Graphe graph) {
        ArrayList<Communaute> communities = new ArrayList<>();
        // TODO : EXO 2.2
        for(int i = 0; i < graph.racines.size(); i++) {
            communities.add(new Communaute());
            addToCommunityRecur(communities.get(i), graph.racines.get(i));
            // Unmark the vertices after the traversal
            graph.unvisitAll(graph.racines.get(i));
        }
        return communities;
    }
    
    private static void addToCommunityRecur(Communaute c, Sommet v) {
        c.add(v);
        v.setVisited(true);
        for(int i = 0; i < v.getAretes().size(); i++) {
            if((((Arete) v.getAretes().get(i)).getDestination().isVisited()))
                addToCommunityRecur(c, ((Arete) v.getAretes().get(i)).getDestination());
        }
    }

    @Override
    public String toString() {
        this.affichage = "";
        for(int i = 0; i < racines.size(); i++) {
            this.affichage += "\n === Graphe === ";
            graphString(racines.get(i));
            // Unmark the vertices after the traversal
            unvisitAll(racines.get(i));
        }
        return this.affichage;
    }

    private void unvisitAll(Sommet v) {
        this.affichage += v.toString();
        v.setVisited(false);
        for(int i = 0; i < v.getAretes().size(); i++) {
            if((((Arete) v.getAretes().get(i)).getDestination().isVisited()))
                unvisitAll(((Arete) v.getAretes().get(i)).getDestination());
        }   
    }

    private void graphString(Sommet v) {
        this.affichage += v.toString();
        v.setVisited(true);
        for(int i = 0; i < v.getAretes().size(); i++) {
            if( !(((Arete) v.getAretes().get(i)).getDestination().isVisited()))
                graphString(((Arete) v.getAretes().get(i)).getDestination());
        }
    }
}
