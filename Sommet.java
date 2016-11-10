import java.util.LinkedList;

/**
 * Un sommet est connecté à N arêtes pondérées et possède une valeur.
 * @param <T> Le type de la valeur du sommet.
 */
public class Sommet<T> {

    /**
     * Valeur du sommet.
     */
    private T valeur;

    /**
     * Liste des arêtes partant de ce sommet.
     */
    private LinkedList<Arete> aretes;

    /**
     * Indique si le sommet a déjà été visité ou pas.
     * Cette propriété doit être remise à false après chaque parcours de graphe.
     */
    private boolean visited;

    /**
     * Construit un nouveau sommet avec une valeur.
     * @param valeur Valeur du sommet.
     */
    public Sommet(T valeur) {
        this(valeur, new LinkedList<>(), false);
    }

    /**
     * Construit un nouveau sommet possédant une valeur, un ensemble d'arêtes et
     * une valeur (booléenne) initiale indiquant si le sommet a déjà été visité.
     * @param valeur Valeur du sommet
     * @param aretes Liste des arêtes partant de ce sommet
     * @param visited Valeur booléenne indiquant si le sommet a déjà été visité.
     */
    public Sommet(T valeur, LinkedList<Arete> aretes, boolean visited) {
        this.valeur = valeur;
        this.aretes = aretes;
        this.visited = visited;
    }
    
    /**
     * Ajoute une arête au sommet. L'ajout ne sera accepté que
     * si l'arête possède ce sommet en tant qu'origine et que la destination n'est pas null.
     * @param arete L'arête à ajouter
     * @return True si l'ajout a fonctionné, false sinon.
     */
    public boolean ajouterConnexion(Arete arete) {
        // The add() will be called only if the two previous conditions are true.
        return (arete.getOrigine() == this) && (arete.getDestination() != null) && this.aretes.add(arete);
    }

    /**
     * Retire une arête du sommet.
     * @param e L'arête à retirer.
     * @return True si le retrait a fonctionné, false sinon.
     */
    public boolean retireConnexion(Arete e) {
        return this.aretes.remove(e);
    }

    /**
     * Returns a string representation of the vertex.
     * (i.e. "Sommet : V
     *         {--> has an edge pointing to Vi, and a weight of Wi such that
     *               i = { 1, ..., this.aretes.size()-1 },
 *                  Vi = vertex i,
     *              Wi = weight i} )
     * @return A string representation of the vertex.
     */
    /**
     * Retourne une représentation d'un sommet sous forme de String.
     * (C.à.d - "Sommet : X
     *             { --> Possède une arête pointant vers Xi et est labellé par : Yi
     *                  où i = {1, ..., this.aretes.size()-1},
     *                     Xi = valeur du sommet i,
     *                     Yi = valeur de l'arête i }
     *
     * @return Une représentation du sommet en chaine de caractère.
     */
    @Override
    public String toString() {
        String s = "Sommet : " + this.valeur.toString() + "\n";
        for(Arete e : this.aretes)
            s += " -> Possède une arête pointant vers : " + e.printDestination()
              + " et est labellé par : " + e.getLabel() + "\n";
        return s;
    }

    // ============== GETTERS ============== //
    /**
     * Retourne la valeur du sommet.
     * @return La valeur du sommet.
     */
    public T getValeur() {
        return this.valeur;
    }

    /**
     * Retourne l'ensemble des arêtes sortantes reliées à un sommet.
     * @return L'ensemble des arêtes
     */
    public LinkedList<Arete> getAretes() {
        return this.aretes;
    }

    /**
     * Retourne true si le sommet a été visité, false sinon.
     * @return True si le sommet a été visité, false sinon.
     */
    public boolean isVisited() {
        return this.visited;
    }


    // ============== SETTERS ============== //


    /**
     * Permet de modifier la valeur du sommet.
     * @param valeur La nouvelle valeur du sommet.
     */
    public void setValeur(T valeur) {
        this.valeur = valeur;
    }

    /**
     * Permet de modifier l'ensemble des arêtes sortantes du sommet.
     * @param aretes Le nouvel ensemble.
     */
    public void setAretes(LinkedList<Arete> aretes) {
        this.aretes = aretes;
    }

    /**
     * Marque le sommet comme visité ou non-visité.
     * @param value True si le sommet a été visité, false sinon.
     */
    public void setVisited(boolean value) {
        this.visited = value;
    }

}
