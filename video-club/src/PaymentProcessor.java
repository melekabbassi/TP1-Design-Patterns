public class PaymentProcessor {
    public static Payment processPayment(String creditCardNumber) {
        return new Payment(creditCardNumber);
    }
}
