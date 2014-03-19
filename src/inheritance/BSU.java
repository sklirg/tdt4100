package inheritance;

public class BSU extends SavingsAccount{
    private double limit, depositsLastYear;

    public BSU(double rentefot, double limit) {
        super(rentefot);
        this.limit = limit;
    }

    public void deposit(double amount) {

    }

    public double getTaxDeduction() {

    }
}
