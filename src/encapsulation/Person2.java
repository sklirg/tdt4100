package encapsulation;

import java.util.Date;

/**
 * Created by haakon on 24/01/14.
 */
public class Person2 extends Person {
    private String SSN;

    public String getSocialsec() {
        return SSN;
    }

    @SuppressWarnings("deprecation")
    public void setSSN(String SSN) {
        Date birthday = getBirthday();
        int bDate = birthday.getDate();
        int bMonth = birthday.getMonth();
        int bYear = birthday.getYear();

        if (SSN.length() != 11) {
            throw new IllegalArgumentException("Your SSN has the wrong number of digits.");
        }
        else if (!((SSN.substring(0,2).equals(String.valueOf(bDate))) || ((SSN.substring(2,4).equals(String.valueOf(bMonth)))) || ((SSN.substring(4,6).equals(String.valueOf(bYear)))))) {
            throw new IllegalArgumentException("Your SSN does not match your birthday.");
        }
        else if (!((((SSN.charAt(8) % 2) == 0) && getGender() == 'F') || (((SSN.charAt(8) % 2) != 0) && getGender() == 'M')))  {
            throw new IllegalArgumentException("Your gender does not match your SSN");
        }
        else if (false) {
            System.out.println("HOW THE HELL DID YOU ENTER THIS - TO BE IMPLEMENTED.");
        }
        else {
            this.SSN = SSN;
        }
    }
}
