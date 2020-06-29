package entity;

public class Movie {

	private int movieId;
	private String title;
	private int year;
	private String genre;
	public Movie(int movieId, String title, int year, String genre) {
		this.setMovieId(movieId);
		this.setTitle(title);
		this.setYear(year);
		this.setGenre(genre);
		
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
}
