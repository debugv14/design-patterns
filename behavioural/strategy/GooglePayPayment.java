public class GooglePayPayment implements PaymentStrategy{

    private String pin;

    public GooglePayPayment(String pin){
        this.pin = pin;
    }

    @Override
    public void pay(double amount){
        System.out.println("Paying with Google Pay: " + amount);
    }
}

// If using Builder Pattern, we can create a PaymentRequest object and pass it to the PaymentStrategy.

public class GooglePayPaymentStrategy implements PaymentStrategy{
    @Override
    public void pay(PaymentRequest paymentRequest){
        System.out.println("Paying with Google Pay: " + paymentRequest.getAmount());
    }
}