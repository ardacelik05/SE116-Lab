public class BankAccount {
    private String ownerName;
    private long iban;
    private int balance;

    public BankAccount(String ownerName,long iban){
        this.ownerName=ownerName;
        this.iban=iban;
        this.balance=0;
    }
    public String getOwnerName() {return ownerName;}
    public long getIban(){return iban;}
    public int getBalance(){return balance;}

    public void setIban(long iban){this.iban=iban;}
    public void setOwnerName(String ownerName){this.ownerName=ownerName;}
    public void setBalance(int balance){this.balance=balance;}

    public void deposit(int amount){
        if(amount<=0){
            System.out.println("amount cant be negative");
        }
        balance+=amount;
        System.out.println("Deposit OK -> " + ownerName + " New Balance: " + balance);

    }

    public void withdraw(int amount){
        if(balance>=amount) {
            balance -= amount;
            System.out.println("Withdraw OK -> " + ownerName + " New Balance: " + balance);
        }else {
            System.out.println("Warning: Insufficient balance! " + ownerName + " Balance: " + balance);
        }
    }

    public void sendMoney(int amount, long recieverIban,BankAccount alici) {

        if (amount <= 0) {
            System.out.println("Send amount must be positive!");
            return;
        }

        if (recieverIban != alici.getIban()) {
            System.out.println("warning wrong iban: " + recieverIban);
            return;
        }


        if (balance < amount) {
            System.out.println("warning: insufficent balance to send money");
            return;
        }

        balance -= amount;
        alici.balance += amount;


        System.out.println(ownerName + "send money to" + alici.ownerName + "amount: " + amount);
        System.out.println("new reciever balance: " + alici.balance);
        System.out.println("new sender balance: " + balance);
    }

    public void displayAccountInfo(){
        System.out.println("owner name: "+ ownerName + " iban: " + iban+" balance: "+ balance);
    }
}
