import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RentalStore {
    private List<Rental> rentals;

    public RentalStore() {
        rentals = new ArrayList<Rental>();
    }

    public void rentMovie(Customer customer, Movie movie, Payment payment) {
        LocalDate rentalDate = LocalDate.now();
        Rental rental = new Rental(customer, movie, payment, rentalDate);
        rentals.add(rental);

        // Decrease the number of available copies of the movie
        movie.setAvailableCopies(movie.getAvailableCopies() - 1);
    }

    public List<Rental> getRentalsForCustomer(Customer customer) {
        List<Rental> customerRentals = new ArrayList<Rental>();
        for (Rental rental : rentals) {
            if (rental.getCustomer().getId() == customer.getId()) {
                customerRentals.add(rental);
            }
        }
        return customerRentals;
    }
}
