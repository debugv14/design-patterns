public class PaymentStrategyFactory{
    public static PaymentStrategy createPaymentStrategy(int paymentMethod){
        switch(paymentMethod){
            case 1:
                return new CreditCardPaymentStrategy();
            case 2:
                return new PayPalPaymentStrategy();
            case 3:
                return new GooglePayPaymentStrategy();
            default:
                return throw new IllegalArgumentException("Invalid payment method");
        }
    }
}