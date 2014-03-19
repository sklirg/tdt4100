package inheritance;

public class BSU extends SavingsAccount{
    private double limit, depositsLastYear;

    public BSU(double rentefot, double limit) {
        super(rentefot);
        this.limit = limit;
    }

    public void deposit(double amount) {
        if (this.depositsLastYear + amount < this.limit) {
            super.deposit(amount);
            depositsLastYear += amount;
        }
        else {
            throw new IllegalStateException("You have deposited too much.");
        }
    }

    public double getTaxDeduction() {
        // @ todo reset depositsLastYear, get taxDeduction
    }
}
