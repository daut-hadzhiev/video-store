package university;
import java.util.Comparator;

public class SortMoviesByYearAndByTax implements Comparator<Movie> {

	// Used for sorting in ascending order of Movie title
	public int compare(Movie a, Movie b)
	{
		int compare = 0;
		compare = b.getYear() - a.getYear();
		if (compare == 0) {
			compare = a.getTax() - b.getTax();
			return compare;
		}
		return compare;
	}
}