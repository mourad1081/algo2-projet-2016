import java.util.ArrayList;

public class Graphe {

    private ArrayList<Sommet> racines;

    // Attribut utilisé pour l'affichage d'un graphe.
    private String affichage;

    public Graphe() {
        this.setRacines(new ArrayList<>());
    }

    /**
     * Construit un graphe correspondant à un fichier dont le chemin est donné en argument.
     * @param path Le chemin du fichier à parser
     */
    public Graphe(String path) {

    }

    public boolean addRoot(Sommet v) {
        return this.getRacines().add(v);
    }

    /**
     * Retourne la racine du sous-graphe d'indice index.
     * @param index L'indice de la racine du sous-graphe de ce graphe.
     * @return Le sommet racince
     */
    private Sommet getRacine(int index) {
        return (0 <= index && index < racines.size()) ? racines.get(index) : null;
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

    /**
     * Permet de faire un parcours en profondeur d'un graphe.
     * L'action à effectuer lors de la visite d'un sommet doit être donné en argument.
     * (Via un objet Function introduit dans Java 1.8.
     * Il 'agit simplement d'une référence à une méthode possédant un input et un output.)
     * @param s Le sommet à partir duquel le parcours récursif est fait.
     * @param action l'action a effectuer lors de la visite d'un sommet.
     */
    public void parcoursGraphe(Sommet s, Action<Sommet> action) {
        s.setVisited(true);
        action.executer(s);
        for(int i = 0; i < s.getArcs().size(); i++) {
            if(!  s.getDestinationDe(i).isVisited())
                parcoursGraphe(s.getDestinationDe(i), action);
        }
    }

    /**
     * <strong>(Résout l'exercice 2.2 du projet)</strong>
     * Retourne la liste des communautés du graphe donné en paramètre.
     * @param graphe La graphe dont on doit identifier les communautés.
     * @return La liste des communautés.
     */
    public static ArrayList<Communaute> identifierCommunautes(Graphe graphe) {
        ArrayList<Communaute> c = new ArrayList<>();
        for(int i = 0; i < graphe.getRacines().size(); i++) {
            c.add(new Communaute());
            graphe.parcoursGraphe(graphe.getRacine(i), c.get(i)::add);
            graphe.resetVisites(graphe.getRacine(i));
        }
        return c;
    }


    @Override
    public String toString() {
        this.affichage = "\n";
        for (Sommet racine : getRacines()) {
            this.affichage += " === Graphe === \n";
            parcoursGraphe(racine, (s) -> this.affichage += s.toString() );
            resetVisites(racine);
        }
        return this.affichage;
    }


    public void resetVisites(Sommet s) {
        s.setVisited(false);
        for(int i = 0; i < s.getArcs().size(); i++) {
            if(s.getDestinationDe(i).isVisited())
                resetVisites(s.getDestinationDe(i));
        }
    }

    public ArrayList<Sommet> getRacines() {
        return racines;
    }

    public void setRacines(ArrayList<Sommet> racines) {
        this.racines = racines;
    }
}
