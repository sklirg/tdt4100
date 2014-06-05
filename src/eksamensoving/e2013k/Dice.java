package eksamensoving.e2013k;

import java.util.Random;

public class Dice {
    public static final int MaxValue = 6;
    public static int[] dicelist;

    public void roll(String test) {
        if (test.equals("1e")) {
            dicelist[0] = 1;
            dicelist[1] = 3;
            dicelist[2] = 1;
            dicelist[3] = 6;
            dicelist[4] = 3;
        }
        if (test.equals("1f")) {
            dicelist[0] = 2;
            dicelist[1] = 1;
            dicelist[2] = 3;
            dicelist[3] = 5;
            dicelist[4] = 3;
        }
    }

    public void roll() {
        Random random = new Random();
        for (int dice : dicelist) {
            dice = random.nextInt(MaxValue);
        }
    }

    public void roll (int[] dicelist) {
        if (dicelist.length != this.dicelist.length)
            throw new IllegalArgumentException("Lists are not of same length");
        else
            this.dicelist = dicelist;
    }

    public Dice(int numDice) {
        dicelist = new int[numDice];
    }

    public String toString() {
        String r = "";
        for (int dice : dicelist) {
            r += String.format(" - %s", dice);
        }
        return r.substring(3);
    }

    public int getValueCount(int value) {
        // Count how many dices have this value
        int cnt = 0;
        for (int dice : dicelist) {
            if (dice == value)
                cnt++;
        }
        return cnt;
    }

    public int getHighestValueOf(int count, int butNot) {
        for (int value = MaxValue; value > 0; value--) {
            if (value != butNot && getValueCount(value) >= count)
                return value;
        }
        return 0;
    }

    public int getStraightSum(int startVal, int endVal) {
        int sum = 0;
        for (int i = startVal; i <= endVal; i++) {
            if (!(getValueCount(i) >= 1))
                return 0;
            else
                sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        SomeEnum c = SomeEnum.PAIR;
        Dice dice = new Dice(5);
        System.out.println(c);
    }
}
