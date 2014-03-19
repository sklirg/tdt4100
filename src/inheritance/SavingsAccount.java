package inheritance;

public class SavingsAccount implements IAccount{
    private double balance, rentefot;

    public SavingsAccount(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount>0)
            this.balance += amount;
        else
            throw new IllegalArgumentException("Illegal amount");
    }

    public void withdraw(double amount) {
        if (amount < 0)
            throw new IllegalArgumentException("Illegal amount");
        else if (this.balance < amount)
            throw new IllegalStateException("Not enough funds");
        else
            this.balance -= amount;
    }

    public double getBalance() {
        // @ Todo return balance
        return -1;
    }

    public void endYearUpdate() {
        // @Todo apply rentefot
    }
}
