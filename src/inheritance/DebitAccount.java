package inheritance;

public class DebitAccount extends AbstractAccount {

    public DebitAccount() {
        super();
    }

    public void internalWithdraw(double amount) {
        if (super.getBalance()<amount)
            throw new IllegalStateException("Not enough funds");
    }
}
