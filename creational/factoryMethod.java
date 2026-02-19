/*
 GoF Definition: Gang of Fours, writers who wrote the book Design Patterns: Elements of Reusable Object-Oriented Software
 Factory Method is a creational design pattern that provides an interface for creating objects in a superclass,
 but allows subclasses to alter the type of objects that will be created.
 */

public interface PaymentGateway{
    void processPayment(double amount);
}

public class StripePaymentGateway implements PaymentGateway{
    @Override
    public void processPayment(double amount){
        System.out.println(
            "Connecting to Stripe API..."
        );

        System.out.println(
            "Processing payment of ₹" +
            amount + " via Stripe"
        );

        System.out.println(
            "Payment successful (Stripe)\n"
        );
    }
}

public class RazorpayPaymentGateway implements PaymentGateway{
    @Override
    public void processPayment(double amount){
       System.out.println(
            "Connecting to Razorpay API..."
        );

        System.out.println(
            "Processing payment of ₹" +
            amount + " via Razorpay"
        );

        System.out.println(
            "Payment successful (Razorpay)\n"
        );
    }
}

public abstract class PaymentService {

    public void makePayment(double amount) {

        // Step 1 — Validation
        validate(amount);

        // Step 2 — Create gateway
        PaymentGateway gateway =
            createGateway();

        // Step 3 — Process payment
        gateway.processPayment(amount);

        // Step 4 — Post processing
        sendReceipt();
    }

    protected abstract PaymentGateway
        createGateway();

    private void validate(double amount) {

        if (amount <= 0) {
            throw new IllegalArgumentException(
                "Invalid payment amount"
            );
        }

        System.out.println(
            "Payment validated for ₹" + amount
        );
    }

    private void sendReceipt() {
        System.out.println(
            "Receipt sent to user"
        );
    }
}

public class StripePaymentService extends PaymentService{
    @Override
    protected PaymentGateway createGateway(){
        return new StripePaymentGateway();
    }
}

public class RazorpayPaymentService extends PaymentService{
    @Override
    protected PaymentGateway createGateway(){
        return new RazorpayPaymentGateway();
    }
}


public class Client{
    public static void main(String args[]) throws Exception{
        PaymentService paymentService = new StripePaymentService();
        paymentService.makePayment(100);
    }
}