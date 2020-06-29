package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Movie;

public class MovieDao {
	
	private Connection connection;
	private final String GET_MOVIES_QUERY = "SELECT * FROM movies";
	private final String CREATE_NEW_MOVIE_QUERY = "INSERT INTO movies(title, year, genre) VALUES(?,?,?)";
	private final String UPDATE_MOVIE_QUERY = "UPDATE movies SET title = ?, year = ?, genre = ? WHERE id = ?";
	private final String DELETE_MOVIE_BY_ID_QUERY = "DELETE FROM movies WHERE ID = ?";
	
	public MovieDao() {
		connection = DBConnection.getConnection();
	}
	public List<Movie> getMovies() throws SQLException {
		ResultSet rs = connection.prepareStatement(GET_MOVIES_QUERY).executeQuery();
		List<Movie> movies = new ArrayList<Movie>();
		
		while (rs.next()) {
			movies.add(populateMovie(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4)));
		}
				
		return movies;
	}
	
	public void createNewMovie(String title, int year, String genre) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_MOVIE_QUERY);
		ps.setString(1, title);
		ps.setInt(2, year);
		ps.setString(3, genre);
		ps.executeUpdate();
	}
	
	
	public void reviseMovie(String title, int year, String genre, int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_MOVIE_QUERY);
		ps.setString(1, title);
		ps.setInt(2, year);
		ps.setString(3, genre);
		ps.setInt(4, id);
		ps.executeUpdate();
	}
	
	public void deleteMovieById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_MOVIE_BY_ID_QUERY);
		ps.setInt(1, id);
		ps.executeUpdate();
	}
	
	private Movie populateMovie(int id, String title, int year, String genre) throws SQLException {
		return new Movie(id, title, year, genre);
	}
	
		
}
