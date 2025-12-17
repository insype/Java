class BankAccount{
    private int accountNumber;
    private String accountHolderName;
    private double balance;

    public int GetAccountNumber()    
    {
        return accountNumber;
    }

    public BankAccount(int accountNumber, String accountHolderName, double balance)
    {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public void deposit(double amount){
        if(amount > 0){
            balance+=amount;
        }
        
    }

    public void withdraw(double amount){
        if(balance > 0){
            balance-=amount;
        }

    }

    public void accountInfo(){
        System.out.println("account number: "+accountNumber);
        System.out.println("account holder name: "+accountHolderName);
        System.out.println("balance: "+balance);
}



}