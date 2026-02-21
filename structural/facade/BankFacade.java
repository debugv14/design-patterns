public class BankFacade{
    private AccountValidator accountValidator;
    private FundsValidator fundsValidator;
    private SecurityValidator securityValidator;
    private TransactionProcessor transactionProcessor;
    private NotificationSender notificationSender;

    public BankFacade(){
        this.accountValidator = new AccountValidator();
        this.fundsValidator = new FundsValidator();
        this.securityValidator = new SecurityValidator();
    }

    public void withdrawMoney(String accountNumber, double amount){
        accountValidator.isValidAccount(accountNumber);
        fundsValidator.hasEnoughFunds(accountNumber, amount);
        securityValidator.isSecurityPinCorrect(securityPin);
        transactionProcessor.performTransaction(accountNumber, amount);
        notificationSender.sendNotification(accountNumber, amount);
    }
}

// Client will interact with the BankFacade class instead of the complex system.