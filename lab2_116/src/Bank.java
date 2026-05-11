public class Bank {
    public static void main(String[] args) {


        BankAccount b1 = new BankAccount("Arda", 1090167448399L);
        BankAccount b2 = new BankAccount("helin", 23940506139L);


        System.out.println("=== Initial Accounts ===");
        b1.displayAccountInfo();
        b2.displayAccountInfo();

        System.out.println("\n=== Operations on Account 1 ===");
        b1.deposit(100000);
        b1.withdraw(200);

        System.out.println("\n=== Operations on Account 2 ===");
        b2.deposit(5000);
       b2.withdraw(700); // warning

        System.out.println("\n=== Accounts After Deposit/Withdraw ===");
        b1.displayAccountInfo();
        b2.displayAccountInfo();

        // account1 sends money to account2
        System.out.println("\n=== Account 1 Sends Money to Account 2 ===");
        b1.sendMoney(300, b2.getIban(), b2);

        // Try with iban that is not in the bank.
        // account1 sends money to account2
        System.out.println("\n=== Account 1 Sends Money to Account 2 ===");
        b1.sendMoney(300, 11111111111L, b2);

        System.out.println("\n=== Final Accounts ===");
        b1.displayAccountInfo();
        b2.displayAccountInfo();
    }
}