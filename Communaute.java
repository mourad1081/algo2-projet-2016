import java.util.ArrayList;

public class Communaute {
	private ArrayList<Sommet> communaute;

	public Communaute() {
		this(new ArrayList<Sommet>());
	}

	public Communaute(ArrayList<Sommet> communaute) {
		this.communaute = communaute;
	}

	public boolean add(Sommet v) {
		return this.communaute.add(v);
	}

    /**
     * Retourne une communauté sous forme de chaine de caractère.
     * @return Une communauté sous forme de chaine de caractère.
     */
	@Override
	public String toString() {
		String res = "";
        for (Sommet s : communaute)
            res += s.getValeur().toString() + " ";
		return res;
	}
}