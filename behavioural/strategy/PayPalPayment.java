public class PayPalPayment implements PaymentStrategy{

    private String email;

    public PayPalPayment(String email){
        this.email = email;
    }
    @Override
    public void pay(double amount){
        System.out.println("Paying with PayPal: " + amount);
    }
}

// If using Builder Pattern, we can create a PaymentRequest object and pass it to the PaymentStrategy.

public class PayPalPaymentStrategy implements PaymentStrategy{
    @Override
    public void pay(PaymentRequest paymentRequest){
        System.out.println("Paying with PayPal: " + paymentRequest.getAmount());
        System.out.println("Email: " + paymentRequest.getEmail());
    }
}