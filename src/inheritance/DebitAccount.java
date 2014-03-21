package inheritance;

public class DebitAccount extends AbstractAccount {

    public DebitAccount() {
        super();
    }

    protected void internalWithdraw(double amount) {
        if (super.getBalance()<amount)
            throw new IllegalStateException("Not enough funds");
    }
}
