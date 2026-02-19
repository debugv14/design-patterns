// Using Builder Pattern to create a PaymentRequest object.
// METHOD -2 
public class PaymentRequest{
    private final double amount;

    // Credit Card
    private final String cardNumber;
    private final String name;
    private final String expiryDate;
    private final String cvv;

    // PayPal
    private final String email;

    // Google Pay
    private final String pin;

    private PaymentRequest(Builder builder){
        this.amount = builder.amount;
        this.cardNumber = builder.cardNumber;
        this.name = builder.name;
        this.expiryDate = builder.expiryDate;
        this.cvv = builder.cvv;
        this.email = builder.email;
        this.pin = builder.pin;
    }

    public static class Builder{
        private double amount;

        private String cardNumber;
        private String name;
        private String expiryDate;
        private String cvv;
        private String email;
        private String pin;

        public Builder(double amount){
            this.amount = amount;
        }

        public Builder setCardNumber(String cardNumber){
            this.cardNumber = cardNumber;
            return this;
        }

        public Builder setName(String name){
            this.name = name;
            return this;
        }

        public Builder setExpiryDate(String expiryDate){
            this.expiryDate = expiryDate;
            return this;
        }

        public Builder setCvv(String cvv){
            this.cvv = cvv;
            return this;
        }

        public Builder setEmail(String email){
            this.email = email;
            return this;
        }

        public Builder setPin(String pin){
            this.pin = pin;
            return this;
        }

        public PaymentRequest build(){
            return new PaymentRequest(this);
        }
    }
}