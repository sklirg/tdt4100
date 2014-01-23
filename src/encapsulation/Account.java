package encapsulation;

/**
 * Created by Håkon on 22.01.14.
 */
public class Account {

    private double balance;
    private double interestRate;
    public Account(double amount, double interestRate) {
        if (amount > 0 && interestRate> 0) {
            this.balance = amount;
            this.interestRate = interestRate;
        }
        else {
            throw new IllegalArgumentException("Amount/Interest rate cannot be less than 0!");
        }
    }

    public double getBalance() {
        return balance;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        if (interestRate>0) {
            this.interestRate = interestRate;
        }
        else {
            throw new IllegalArgumentException("Cannot set interest rate less than 0!");
        }
    }

    void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        }
        else {
           throw  new IllegalArgumentException("Cannot deposit less than 0.");
        }
    }

    void withdraw(double amount) {
        if (amount > 0) {
            if (amount <= this.balance) {
                this.balance -= amount;
                // PrintMoney(amount);
            }
            else {
                throw new IllegalStateException(String.format("Cannot withdraw, too low on funds.\nBalance: %s, withdraw: %s", this.balance, amount));
            }
        }
        else {
            throw new IllegalArgumentException("Cannot withdraw less than 0.");
        }
    }

        /*
         * Del 1 - Teori
         *
         * 1. Metodene gjør det mulig å forandre på tilstanden til objektet (både opp og ned). (setRate, withdraw, deposit)
         *
         * 2. ?      Tjenesteorientert. Du gir feilmeldinger.
         *
         */

    public static void main(String[] args) {
        Account lanekassa = new Account(100, 3);

        System.out.println(lanekassa.getBalance());
        lanekassa.withdraw(105);
    }
}
