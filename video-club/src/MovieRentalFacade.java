import java.util.List;
import java.util.Scanner;

public class MovieRentalFacade {
    private Customer customer;
    private MovieStore movieStore;
    private RentalStore rentalStore;

    public MovieRentalFacade(Customer customer) {
        this.customer = customer;
        movieStore = new MovieStore();
        rentalStore = new RentalStore();
    }

    public MovieRentalFacade() {
        this(null);
    }

    public void showMainMenu() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Welcome to the Movie Rental Store!");
            System.out.print("Enter your customer ID: ");
            int id = scanner.nextInt();
            System.out.print("Enter your password: ");
            String password = scanner.next();
            customer = new Customer(id, password);

            List<Movie> availableMovies = movieStore.getAvailableMovies();
            for (Movie movie : availableMovies) {
                System.out.println(movie.getTitle() + " (" + movie.getType() + "): " + movie.getAvailableCopies() + " copies available out of " + movie.getTotalCopies());
            }

            System.out.print("Enter the title of the movie you want to rent: ");
            try (Scanner scanner2 = new Scanner(System.in)) {
                String title = scanner2.nextLine();
                Movie movie = movieStore.getMovieByTitle(title);
                if (movie == null) {
                    System.out.println("Sorry, we don't have that movie.");
                    return;
                } else if (movie.getAvailableCopies() == 0) {
                    System.out.println("Sorry, we don't have any copies of that movie available.");
                    return;
                } else {
                    System.out.println("You are about to rent " + movie.getTitle() + " (" + movie.getType() + "). if you miss the deadline, you will be charged a late fee of $5.00.");
                    System.out.print("If you agree, enter your credit card number: ");
                    try (Scanner scanner3 = new Scanner(System.in)) {
                        Payment payment = new Payment(scanner3.nextLine());
                        rentalStore.rentMovie(customer, movie, payment);
                    } catch (Exception e) {
                        System.out.println("An error occurred: " + e.getMessage());
                    }
                    System.out.println("Thank you for renting " + movie.getTitle() + "!");
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public void showRentalsForCustomer() {
        List<Rental> customerRentals = rentalStore.getRentalsForCustomer(customer);
        System.out.println("Your rentals:");
        for (Rental rental : customerRentals) {
            System.out.println(rental.getMovie().getTitle() + " (" + rental.getMovie().getType() + ")");
        }
    }
}
