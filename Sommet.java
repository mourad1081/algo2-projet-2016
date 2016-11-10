import java.util.LinkedList;

/**
 * Un sommet est connecté à N arcs pondérées et possède une valeur.
 * @param <T> Le type de la valeur du sommet.
 */
public class Sommet<T> {

    /**
     * Valeur du sommet.
     */
    private T valeur;

    /**
     * Liste des arcs partant de ce sommet.
     */
    private LinkedList<Arc> arcs;

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
     * Construit un nouveau sommet possédant une valeur, un ensemble d'arcs et
     * une valeur (booléenne) initiale indiquant si le sommet a déjà été visité.
     * @param valeur Valeur du sommet
     * @param arcs Liste des arcs partant de ce sommet
     * @param visited Valeur booléenne indiquant si le sommet a déjà été visité.
     */
    public Sommet(T valeur, LinkedList<Arc> arcs, boolean visited) {
        this.valeur = valeur;
        this.arcs = arcs;
        this.visited = visited;
    }
    
    /**
     * Ajoute une arc au sommet. L'ajout ne sera accepté que
     * si l'arc possède ce sommet en tant qu'origine et que la destination n'est pas null.
     * @param arc L'arc à ajouter
     * @return True si l'ajout a fonctionné, false sinon.
     */
    public boolean ajouterConnexion(Arc arc) {
        // The add() will be called only if the two previous conditions are true.
        return (arc.getOrigine() == this) && (arc.getDestination() != null) && this.arcs.add(arc);
    }

    /**
     * Retourne l'arc à l'indice index.
     * @param index L'indice de l'arc à retourner.
     * @return <ul>
     *            <li>L'arc à l'indice i.</li>
     *            <li>Null si l'indice est hors-bornes.</li>
     *        </ul>
     */
    public Arc getArc(int index) {
        return (0 <= index && index < arcs.size())? arcs.get(index) : null;
    }

    /**
     * Retourne la destination de l'arc à l'indice index.
     * @param index L'indice de l'arc dont on doit retourner la destination
     * @return <ul>
     *            <li>Le sommet correspondant à la destination de l'arc à l'indice index.</li>
     *            <li>Null si l'indice est hors-bornes.</li>
     *        </ul>
     */
    public Sommet getDestinationDe(int index) {
        return (0 <= index && index < arcs.size())? arcs.get(index).getDestination() : null;
    }
    /**
     * Retire une arc du sommet.
     * @param e L'arc à retirer.
     * @return True si le retrait a fonctionné, false sinon.
     */
    public boolean retireConnexion(Arc e) {
        return this.arcs.remove(e);
    }

    /**
     * Retourne une représentation d'un sommet sous forme de String.
     * (C.à.d - "Sommet : X
     *             { --> Possède une arc pointant vers Xi et est labellé par : Yi
     *                  où i = {1, ..., this.arcs.size()-1},
     *                     Xi = valeur du sommet i,
     *                     Yi = valeur de l'arc i }
     *
     * @return Une représentation du sommet en chaine de caractère.
     */
    @Override
    public String toString() {
        String s = "Sommet : " + this.valeur.toString() + "\n";
        for(Arc e : this.arcs)
            s += " -> Possède une arc pointant vers : " + e.printDestination()
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
     * Retourne l'ensemble des arcs sortantes reliées à un sommet.
     * @return L'ensemble des arcs
     */
    public LinkedList<Arc> getArcs() {
        return this.arcs;
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
     * Permet de modifier l'ensemble des arcs sortantes du sommet.
     * @param arcs Le nouvel ensemble.
     */
    public void setArcs(LinkedList<Arc> arcs) {
        this.arcs = arcs;
    }

    /**
     * Marque le sommet comme visité ou non-visité.
     * @param value True si le sommet a été visité, false sinon.
     */
    public void setVisited(boolean value) {
        this.visited = value;
    }

}
