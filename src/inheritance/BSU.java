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

    public void withdraw(double amount) {
        if (amount < this.depositsLastYear) {
            this.depositsLastYear-= amount;
            super.withdraw(amount);
        }
        else {
            throw new IllegalStateException("Illegal amount");
        }
    }

    public double getTaxDeduction() {
        // @ todo reset depositsLastYear, get taxDeduction
        double freeMoney = this.depositsLastYear * 0.20;
        this.depositsLastYear = 0;
        return freeMoney;
    }
}
