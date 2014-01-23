package encapsulation;

public class Digit {
    // [1] Private vars
    private int numSys;
    private int digit;

    public Digit(int i) {
        if (digit < numSys) {
            this.numSys = i;
            this.digit = 0;
        }
        else {
            throw new IllegalArgumentException("WTF!");
        }
    }

    // [1] Public methods
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

    public String toString() {
        String str = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return str.charAt(this.digit) + "";
    }

    /*
     *
     * [2] Konstruktør må ha validation for at digit er lavere enn numSys.
     * [3] ^
     */
    public static void main(String[] args) {
        Digit d = new Digit(12);
        System.out.println(d.getValue());
        d.increment();
        System.out.println(d.getValue());
        System.out.println(d);
    }



}
