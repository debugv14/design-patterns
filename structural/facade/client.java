/* Facade is a structural design pattern that provides a simplified interface to a library, 
framework, or any other complex subsystem, making it easier for clients to use.

For example: 
We have a complex system with many classes and methods to withdraw money from a bank. 
Without Facade, the client would need to know about all the classes and methods to withdraw money from a bank.
1. Check if the account is valid (AccountValidator)
2. Check if the account has enough balance (FundsValidator)
3. Check if Security Pin is correct (SecurityPinValidator)
4. Perform the transaction (TransactionProcessor)
5. Send notification to the user (NotificationSender)

This is a complex system with many drawbacks: Not Scalable, Not Maintainable, Not Testable, Not Reusable, Not Extensible.
To solve this, we can use Facade pattern.
Facade Class will expose a simplified interface to the client and handle the complexity of the system. 
So in place of client directly interacting with the complex system, they will interact with the Facade Class.
*/

public class Client{
    public static void main(String[] args){
        BankFacade bankFacade = new BankFacade();
        bankFacade.withdrawMoney("1234567890", 100);
    }
}