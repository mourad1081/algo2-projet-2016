import java.util.ArrayList;

public class Community {
	private ArrayList<Vertex> community;

	public Community() {
		this(new ArrayList<Vertex>());
	}

	public Community(ArrayList<Vertex> community) {
		this.community = community;
	}

	public boolean add(Vertex v) {
		return this.community.add(v);
	}

	@Override
	public String toString() {
		String s = "";
		for(Vertex v : community)
			s += v.getValue().toString() + " ";
		return s;
	}
}