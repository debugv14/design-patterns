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