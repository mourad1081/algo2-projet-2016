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

	@Override
	public String toString() {
		String s = "";
		for(Sommet v : communaute)
			s += v.getValeur().toString() + " ";
		return s;
	}
}