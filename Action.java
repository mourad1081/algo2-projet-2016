/**
 * Interface fonctionnelle. Notion introduite dans java 1.8
 * cela me permet denvoyer des méthodes/fonctions en paramètres.
 * Ici, j'impose que les méthodes envoyées en paramètres ne doivent rien retourner et avoir un seul input.
 * C'est ce qui convient le mieux pour ce projet.
 * @author Mourad
 */
@FunctionalInterface
public interface Action<I> {
    void executer(I input);
}
