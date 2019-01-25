package university;
import java.util.Comparator;

public class SortMoviesAlphabetically implements Comparator<Movie> {

    // Used for sorting in ascending order of Movie title
    public int compare(Movie a, Movie b)
    {
        return a.getTitle().compareTo(b.getTitle());
    }
}
