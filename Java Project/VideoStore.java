package university;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;;

/**
 * @author Daut Molahasanov
 *
 */
public class VideoStore {

	String storeName;
	int movieCount;
	private ArrayList<Movie> moviesList = new ArrayList<Movie>();
	private Movie[] moviesArr = new Movie[9999];
	
	public VideoStore(String storeName) {
		this.storeName = storeName;
		this.movieCount = 0;
	};
	
	public void setStoreName(String name) {
		this.storeName = name;
	}
	public String getStoreName() {
		return this.storeName;
	}
	
	void setMovieCount (int count) {
		this.movieCount = count;
	}

	int getMovieCount () {
		return this.movieCount;
	}

	public void addMovie (String movieTitle,String actorNames, int movieYear,int movieTax) {
				
		if (this.movieCount <= 10000) {
			moviesArr[this.getMovieCount()] = new Movie(movieTitle, actorNames, movieYear, movieTax);
			moviesList.add(moviesArr[this.getMovieCount()]);
			this.movieCount++;

		} else {
			System.out.println("You have reached the limit of 10000 movies!"); // throw exception
		}
	}
	
	public ArrayList<Movie> getMovies () { 
		return moviesList;
	}
	
	public static void printLine() {
		System.out.println("--------------------------------------------");
	} 
	
	public static void printMovies(ArrayList<Movie> movies) {
		printLine();
		for (Movie movie: movies) {
			System.out.println(
				movie.getTitle() + "; " + 
				movie.getActorNamesString() + "; " + 
				movie.getYear() + "; " + 
				movie.getTax()
			);
		}
	}

	public static void main(String[] args) {
		

		VideoStore[] Stores = new VideoStore[3];
		Stores[0] = new VideoStore("Peika");
		Stores[1] = new VideoStore("Monkey Business");
		Stores[2] = new VideoStore("Filmi ot Kiro");

		String actorNameToFilter = "Robert de Niro";
		int yearFilter = 1992;
		
		Stores[0].addMovie("aDie hard1", "Catherine Zeta Jones,Robert de Niro,Nicolas Cage", 1990, 100008);
		Stores[0].addMovie("cDie hard3", "Catherine Zeta Jones,Robert de Niro,Nicolas Cage", 1992, 100003);
		Stores[2].addMovie("iDie hard5", "Catherine Zeta Jones,Robert de Niro,Nicolas Cage", 1994, 100001);
		Stores[0].addMovie("bDie hard2", "Catherine Zeta Jones,Robert de Niro,Nicolas Cage", 1991, 100004);
		Stores[1].addMovie("hDie hard6", "Catherine Zeta Jones,Robert de Niro,Nicolas Cage", 1995, 100009);
		Stores[2].addMovie("eDie hard9", "Catherine Zeta Jones,Robert de Niro,Nicolas Cage", 1992, 100004);
		Stores[0].addMovie("yDie hard7", "Catherine Zeta Jones,Robert de Niro,Nicolas Cage", 1992, 100002);
		Stores[1].addMovie("fDie hard8", "Catherine Zeta Jones,Robert de Niro,Nicolas Cage", 1993, 100001);
		Stores[2].addMovie("gDie hard0", "Catherine Zeta Jones,Robert de Niro,Nicolas Cage", 2009, 100004);
		Stores[1].addMovie("dDie hard4", "Robera de Nir,Catherine Zeta Jones,Nicolas Cage,", 1993, 100002);

		ArrayList<Movie> allMovies = new ArrayList<Movie>();

		for (VideoStore store: Stores ) { // loop over the stores
			int i = 0;
			Iterator<Movie> movieIterator = store.getMovies().iterator();
			while (i < store.getMovieCount()) { // loop over the added movies only
				allMovies.add(movieIterator.next());
				i++;
			}
		}
		
		System.out.println();
		printLine();
		System.out.println("All movies sorted alphabetically");
		allMovies.sort(new SortMoviesAlphabetically());
		printMovies(allMovies);


		allMovies.removeIf(movie -> !movie.getActorNamesList().contains(actorNameToFilter)); // filter movies if contains actor

		allMovies.sort(new SortMoviesByYearAndByTax()); // sort by year and then by tax
		System.out.println();
		printLine();
		System.out.println("Sorted by year and then tax");
		printMovies(allMovies);


		float heighestTax = 0;
		
		
		for (int i = 0; i < Stores.length; i++) { // loop over the stores
			ArrayList<Movie> movies = Stores[i].getMovies();
			int averageTaxPerStore = 0;
			int counter = 0;
		
			for(Movie movie: movies) {
			
				if (movie.getYear() == yearFilter) {
					averageTaxPerStore += movie.getTax();
					counter++;
				}

			}
		
			if (counter > 0) {
				System.out.println();
				printLine();
				System.out.println("Average tax in " + Stores[i].getStoreName() +  " is " + (float)(averageTaxPerStore / counter) );

				if (heighestTax < averageTaxPerStore / counter) {
					heighestTax = averageTaxPerStore / counter;
				}

			} else {
				System.out.println();
				printLine();
				System.out.println("There are no movies in " + Stores[i].getStoreName() + " from the year " + yearFilter );
			}


			Stores[i].getMovies().removeIf(mov -> mov.getYear() == yearFilter);
			printMovies(allMovies );
		}
		System.out.println();
		printLine();
		System.out.println("heighest tax for " + yearFilter +  " is " + heighestTax);
	}
}