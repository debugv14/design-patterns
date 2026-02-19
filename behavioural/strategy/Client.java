public class Client{
    public static void main(String[] args){
      
      Scanner scanner = new Scanner(System.in);
      System.out.println("Select the payment method: ");
      System.out.println("1. Credit Card");
      System.out.println("2. PayPal");
      System.out.println("3. Google Pay");

      int choice = scanner.nextInt();
      switch(choice){
        case 1:
          System.out.println("Enter the credit card number: ");
          String cardNumber = scanner.nextLine();
          System.out.println("Enter the name: ");
          String name = scanner.nextLine();
          System.out.println("Enter the expiry date: ");
          String expiryDate = scanner.nextLine();
          System.out.println("Enter the CVV: ");
          String cvv = scanner.nextLine();
          paymentStrategy = new CreditCardPayment(cardNumber, name, expiryDate, cvv);
          break;
        case 2:
          System.out.println("Enter the email: ");
          String email = scanner.nextLine();
          paymentStrategy = new PayPalPayment(email);
          break;
        case 3:
          System.out.println("Enter the pin: ");
          String pin = scanner.nextLine();
          paymentStrategy = new GooglePayPayment(pin);
          break;
      }
      PaymentProcessor paymentProcessor = new PaymentProcessor(paymentStrategy);
      paymentProcessor.processPayment(amount);
      scanner.close();
}

// If using Builder Pattern, we can create a PaymentRequest object and pass it to the PaymentStrategy.
// Gateway-specific data is encapsulated inside a request object, usually built using Builder Pattern. 
// The Strategy reads only the data it needs, while the Factory is responsible only for selecting the appropriate strategy.

public class Client{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select the payment method: ");
        System.out.println("1. Credit Card");
        System.out.println("2. PayPal");
        System.out.println("3. Google Pay");

        int choice = scanner.nextInt();
        PaymentStrategy paymentStrategy = PaymentStrategyFactory.createPaymentStrategy(choice);

        PaymentRequest paymentRequest = new PaymentRequest.Builder(100)
            .setCardNumber(cardNumber)
            .setName(name)
            .setExpiryDate(expiryDate)
            .setCvv(cvv)
            .setEmail(email)
            .setPin(pin)
            .build();

        PaymentProcessor paymentProcessor = new PaymentProcessor(paymentStrategy);
        paymentProcessor.processPayment(paymentRequest);
        scanner.close();
        }
}