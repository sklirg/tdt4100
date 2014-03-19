package inheritance;

/**
 * Created by Håkon on 19.03.14.
 */
public interface IAccount {
    public void deposit(double amount);
    public void withdraw(double amount);
    public double getBalance();
}
