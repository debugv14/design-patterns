public interface PaymentStrategy{
    void pay(double amount);
}


// If using Builder Pattern, we can create a PaymentRequest object and pass it to the PaymentStrategy.
public class PaymentStrategy{
     void pay(PaymentRequest paymentRequest);
}