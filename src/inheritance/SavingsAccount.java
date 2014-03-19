package inheritance;

public class SavingsAccount implements IAccount{
    private double balance, rentefot;

    public SavingsAccount(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
     // @Todo: illegal amount throws new IllegalArgException
    }

    public void withdraw(double amount) {
        /*
         * @Todo
         * Illegal amount throws new IllArgExc
         * Not enough funds throws new IllStateExc
         */
    }

    public double getBalance() {
        // @ Todo return balance
        return -1;
    }

    public void endYearUpdate() {
        // @Todo apply rentefot
    }
}
