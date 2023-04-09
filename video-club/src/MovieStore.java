import java.util.ArrayList;
import java.util.List;

public class MovieStore {
    private List<Movie> movies;

    public MovieStore() {
        movies = new ArrayList<Movie>();
        movies.add(new Movie("The Matrix", "Action", 3, 3));
        movies.add(new Movie("Forrest Gump", "Drama", 2, 2));
        movies.add(new Movie("The Shawshank Redemption", "Drama", 1, 1));
        movies.add(new Movie("The Godfather", "Drama", 2, 2));
        movies.add(new Movie("Jurassic Park", "Science Fiction", 1, 1));
    }

    public List<Movie> getAvailableMovies() {
        List<Movie> availableMovies = new ArrayList<Movie>();
        for (Movie movie : movies) {
            if (movie.getAvailableCopies() > 0) {
                availableMovies.add(movie);
            }
        }
        return availableMovies;
    }

    public Movie getMovieByTitle(String title) {
        for (Movie movie : movies) {
            if (movie.getTitle().equals(title)) {
                return movie;
            }
        }
        return null;
    }
}
