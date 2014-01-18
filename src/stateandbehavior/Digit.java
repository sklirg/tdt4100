package stateandbehavior;

public class Digit {

    public int numSys;
    public int digit;

    public Digit(int i) {
        this.numSys = i;
        this.digit = 0;
    }

    public int getValue() {
        return this.digit;
    }

    public boolean increment() {
        if (this.digit == (this.numSys - 1)) {
            this.digit = 0;
            return true;
        }
        else {
            this.digit++;
            return false;
        }
    }

    @Override
    public String toString() {
        String str = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return str.charAt(this.digit) + "";
    }

    public static void main(String[] args) {
        Digit d = new Digit(12);
        System.out.println(d.getValue());
        d.increment();
        System.out.println(d.getValue());
        System.out.println(d);
    }



}
