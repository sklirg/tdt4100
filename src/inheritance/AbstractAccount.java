package inheritance;

public abstract class AbstractAccount {
    private double balance;

    public void deposit(double amount) {

    }

    public void withdraw(double amount) {

    }

    abstract void internalWithdraw(double amount);

    public double getBalance() {

    }
}
