package application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.MovieDao;
import entity.Movie;

public class Menu {
	
	private MovieDao movieDao = new MovieDao();
	private Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList(
			"Display Movies", 
			"Create Movie",
			"Revise Movie",
			"Delete Movie");
	
	
	public void start() {
		String selection = "";
		do {
			printMenu();
			selection = scanner.nextLine();
			
			try {
				if (selection.equals("1")) {
						displayMovies();
					} else if (selection.equals("2")) {
						createMovie();
					} else if (selection.equals("3")) {
						reviseMovie();
					} else if (selection.equals("4")) {
						deleteMovie();
					}	
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
						System.out.println("Press enter to continue....");
						scanner.nextLine();
			
		} while (!selection.equals("-1"));
	
	}

	private void printMenu() {
		System.out.println("Select an Option:\n..........................");
		for (int i = 0; i < options.size(); i++) {
			System.out.println(i + 1 + ") " + options.get(i));
		}
	}

	private void displayMovies() throws SQLException {
		List<Movie> movies = movieDao.getMovies();
		for (Movie movie : movies) {
			System.out.println(movie.getMovieId() + ": " + movie.getTitle() + ", " + movie.getYear() + ", " + movie.getGenre());
		}
	}
	
	private void createMovie() throws SQLException {
		System.out.println("Enter new movie title:");
		String title = scanner.nextLine();
		System.out.println("Enter new movie year:");
		int year = Integer.parseInt(scanner.nextLine());
		System.out.println("Enter new movie genre:");
		String genre = scanner.nextLine();
		movieDao.createNewMovie(title, year, genre);
		
	}
	
	private void reviseMovie() throws SQLException {
		System.out.println("Enter movie id to revise:");
		int id = Integer.parseInt(scanner.nextLine());
		System.out.println("Enter movie title to revise:");
		String title = scanner.nextLine();
		System.out.println("Enter movie year to revise:");
		int year = Integer.parseInt(scanner.nextLine());
		System.out.println("Enter movie genre to revise:");
		String genre = scanner.nextLine();
		movieDao.reviseMovie(title, year, genre, id);
	}
	
	
	private void deleteMovie() throws SQLException {
		System.out.println("Enter movie id to delete:");
		int id = Integer.parseInt(scanner.nextLine());
		movieDao.deleteMovieById(id);
	}
	
}
