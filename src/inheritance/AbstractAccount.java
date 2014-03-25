package inheritance;

import org.eclipse.emf.ecore.xmi.IllegalValueException;

public abstract class AbstractAccount {
    private double balance;

    public AbstractAccount() {
        this.balance = 0;
    }

    public void deposit(double amount) {
        if (amount > 0)
            this.balance += amount;
        else
            throw new IllegalArgumentException("Illegal amount");
    }

    public void withdraw(double amount) {
        if (amount < 0)
            throw new IllegalArgumentException("Illegal amount");
        else {
            try {
                internalWithdraw(amount);
            } catch (IllegalArgumentException e) {
                amount += 50;
            }

            this.balance -= amount;
        }
    }

    abstract void internalWithdraw(double amount);

    public double getBalance() {
        return this.balance;
    }
}
