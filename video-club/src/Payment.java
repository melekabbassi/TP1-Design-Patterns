public class Payment {
    private String creditCardNumber;

    public Payment(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public Payment() {
        this.creditCardNumber = "0000-0000-0000-0000";
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }
}
