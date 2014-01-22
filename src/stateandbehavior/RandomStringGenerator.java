package stateandbehavior;
import java.util.Random;

public class RandomStringGenerator {
    String letters = "abcdefghijklmnopqrstuvwxyz";

    public String getRandomString()
    {
        String r = "";
        Random getRandomNum = new Random();
        int numChars = getRandomNum.nextInt(30);
        for (int i = 0; i < numChars; i++) {
            int x = getRandomNum.nextInt(this.letters.length());
            r += letters.charAt(x);
        }
        return r;
    }

    public static void main (String[] Args)
    {
        RandomStringGenerator str = new RandomStringGenerator();
        String l = str.getRandomString();
        System.out.println(l);
    }
}
