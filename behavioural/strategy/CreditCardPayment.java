public class CreditCardPayment implements PaymentStrategy{

    private String cardNumber;
    private String name;
    private String expiryDate;
    private String cvv;

    public CreditCardPayment(String cardNumber, String name, String expiryDate, String cvv){
        this.cardNumber = cardNumber;
        this.name = name;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    @Override
    public void pay(double amount){
        System.out.println("Paying with credit card: " + amount);
    }
}


// If using Builder Pattern, we can create a PaymentRequest object and pass it to the PaymentStrategy.

public class CreditCardPaymentStrategy implements PaymentStrategy{
    @Override
    public void pay(PaymentRequest paymentRequest){
        System.out.println("Paying with credit card: " + paymentRequest.getAmount());
        System.out.println("Card Number: " + paymentRequest.getCardNumber());
        System.out.println("Name: " + paymentRequest.getName());
        System.out.println("Expiry Date: " + paymentRequest.getExpiryDate());
        System.out.println("CVV: " + paymentRequest.getCvv());

        // Process the payment
        System.out.println("Processing payment with credit card: " + paymentRequest.getAmount());
    }
}