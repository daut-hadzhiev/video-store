package university;
import java.util.ArrayList;

public class Movie {
	String title;
	String actorNames;
	int year, tax;

	public Movie(String title,String actorNames, int year,int movieTax) {
		this.title = title;
		this.actorNames = actorNames;
		this.year = year;
		this.tax = movieTax;
	}

	public void setyear(int year) {
		this.year = year;
	}

	public int getYear() {
		return this.year;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTax(int tax) {
		this.tax = tax;
	}

	public int getTax() {
		return this.tax;
	}
	
	public String getActorNamesString () { // get string of actors
		return this.actorNames;
	}

	public ArrayList<String> getActorNamesList() { // get list of actors
		ArrayList<String> actorNamesList = new ArrayList<String>();
		int len = this.actorNames.split(",").length;
		String[] namesArr = new String[len];

		namesArr = this.actorNames.split(",");
		
		for(int i = 0; i < len; i++) {
			actorNamesList.add(namesArr[i]);
		}
		
		return actorNamesList;
	}

	public void setActorNames(String names) { // string separated with comma ","
		this.actorNames = names;
	}
	
	public void addActorName (String name) { // add actors one by one
		this.actorNames += ( name);
	}

}