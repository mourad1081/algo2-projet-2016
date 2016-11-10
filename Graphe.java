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
     * @param v Le sommet à partir duquel le parcours récursif est fait.
     * @param action l'action a effectuer lors de la visite d'un sommet.
     */
    public void parcoursGraphe(Sommet v, Methode<Sommet> action) {
        v.setVisited(true);
        if(action != null) // visite du sommet
            action.executer(v);
        for(int i = 0; i < v.getArcs().size(); i++) {
            if(!  v.getDestinationDe(i).isVisited())
                parcoursGraphe(v.getDestinationDe(i), action);
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
            ajoutRecursifCommunaute(c.get(i), graphe.getRacines().get(i));
            graphe.parcoursGraphe(graphe.getRacines().get(i), (s) -> s.setVisited(false) );
        }
        return c;
    }


    /**
     * Ajoute un sommet dans une communauté. Tous les sommets atteignables par ce sommet seront également ajoutés.
     * Et ce, récursivement jusqu'à ce qu'il n'y ait plus d'ajout possible.
     * @param c La communauté dans laquelle on rajoute le sommet <strong>s</strong>.
     * @param s Le sommet à rajouter dans la communauté <strong>c</strong>.
     */
    private static void ajoutRecursifCommunaute(Communaute c, Sommet s) {
        c.add(s);
        s.setVisited(true);
        for(int i = 0; i < s.getArcs().size(); i++) {
            if(! ((Arc) s.getArcs().get(i)).getDestination().isVisited())
                ajoutRecursifCommunaute(c, ((Arc) s.getArcs().get(i)).getDestination());
        }
    }

    @Override
    public String toString() {
        this.affichage = "\n";
        for (Sommet racine : getRacines()) {
            this.affichage += " === Graphe === ";
            parcoursGraphe(racine, (s) -> this.affichage += s.toString());
        }
        resetVisites();
        return this.affichage;
    }


    public void resetVisites() {
        for(Sommet s : racines)
            parcoursGraphe(s, (v) -> v.setVisited(false));
    }

    public ArrayList<Sommet> getRacines() {
        return racines;
    }

    public void setRacines(ArrayList<Sommet> racines) {
        this.racines = racines;
    }
}
