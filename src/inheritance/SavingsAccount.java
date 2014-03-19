package inheritance;

public class SavingsAccount implements IAccount{
    private double balance, rentefot;

    protected SavingsAccount(double rentefot) {
        this.rentefot = rentefot;
        this.balance = 0;
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
        return this.balance;
    }

    protected void endYearUpdate() {
        this.balance += this.balance * this.rentefot;
    }
}
