
public class Movie {
	private String title;
	private int releaseDate;
	private double rating;
	private Director director;
	private Actor actor1;
	private Actor actor2;
	
	public Movie(String title, int releaseDate, double rating, Director director, Actor actor1, Actor actor2) {
		this.title = title;
		this.releaseDate = releaseDate;
		this.rating = rating;
		this.director = director;
		this.actor1 = actor1;
		this.actor2 = actor2;
	}
	public Movie() {
		this(null,0,0.0,null,null,null);
	}
	public Movie(String args[]) {
		this( args[0],Integer.parseInt(args[1]),Double.parseDouble(args[2]) ,new Director(args[3]),new Actor(args[4]),new Actor(args[5]) );
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(int releaseDate) {
		this.releaseDate = releaseDate;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public Director getDirector() {
		return director;
	}
	public void setDirector(Director director) {
		this.director = director;
	}
	public Actor getActor1() {
		return actor1;
	}
	public void setActor1(Actor actor1) {
		this.actor1 = actor1;
	}
	public Actor getActor2() {
		return actor2;
	}
	public void setActor2(Actor actor2) {
		this.actor2 = actor2;
	}
	@Override
	public String toString() {
		return "Movie [title=" + title + ", releaseDate=" + releaseDate + ", rating=" + rating + ", director="
				+ director + ", actor1=" + actor1 + ", actor2=" + actor2 + "]";
	}
	
}
