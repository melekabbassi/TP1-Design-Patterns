import java.time.LocalDate;

public class Rental {
    private Customer customer;
    private Movie movie;
    private Payment payment;
    private LocalDate rentalDate;

    public Rental(Customer customer, Movie movie, Payment payment, LocalDate rentalDate) {
        this.customer = customer;
        this.movie = movie;
        this.payment = payment;
        this.rentalDate = rentalDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public LocalDate getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(LocalDate rentalDate) {
        this.rentalDate = rentalDate;
    }
}
