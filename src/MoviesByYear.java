import java.util.Comparator;

public class MoviesByYear implements Comparator< Movie > {

	@Override
	public int compare(Movie o1, Movie o2) {
		return o1.getReleaseDate() - o2.getReleaseDate();
	}
	
}
