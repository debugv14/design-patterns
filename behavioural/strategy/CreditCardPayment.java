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