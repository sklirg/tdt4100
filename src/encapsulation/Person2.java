package encapsulation;

import java.util.Date;

/**
 * Created by haakon on 24/01/14.
 */
public class Person2 extends Person {
    private String SSN;


    private boolean CheckControlNums(String SSN) {
        int vs1 = 0, vs2 = 0;
        int[] f = {3,7,6,1,8,9,4,5,2};
        int[] g = {5,4,3,2,7,6,5,4,3,2};
        for (int i = 0; i < SSN.length()-3; i++) {
            vs1 += (Integer.parseInt(SSN.charAt(i)+"")) * f[i];
            vs2 += (Integer.parseInt(SSN.charAt(i)+"")) * g[i];
        }
        /*vs1 = 11 - (vs1 % 11);
        if (vs1 == 11) {
            vs1 = 0;
        }*/
        vs2 += vs1 * g[9];
        /*vs2 = 11 - (vs2 % 11);
        if (vs2 == 11) {
            vs2 = 0;
        }*/
        System.out.println(SSN + ": " + (11 - (vs1 % 11)) + "<10 || " + (vs1 % 11) + "=0 | && | " + (11 - (vs2 % 11))  + "<10 || " +  (vs2 % 11)  + "=0 ");
        System.out.println(((((11 - (vs1 % 11)) < 10) +" "+ ((vs1 % 11) == 0)) +" "+ ((((11 - (vs2 % 11))) < 10) +" "+ ((vs2 % 11) == 0))));
        return ((((11 - (vs1 % 11)) < 10) || ((vs1 % 11) == 0)) && ((((11 - (vs2 % 11))) < 10) || ((vs2 % 11) == 0)));
    }

    public String getSocialsec() {
        return SSN;
    }

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
            throw new IllegalArgumentException("Your gender does not match your SSN: " + getGender());
        }
        else if (!(CheckControlNums(SSN))) {
            System.out.println("Your control numbers are invalid.");
        }
        else {
            this.SSN = SSN;
        }
    }

    public static void main(String[] args) {
        Person2 me = new Person2();
        Date myBd = new Date(94,2,30);
        me.setBirthday(myBd);
        me.setGender('M');

        me.setSSN("30039426311");


        Person2 noob = new Person2();
        Date noobBd = new Date(94,0,1);
        noob.setBirthday(noobBd);
        noob.setGender('M');
        noob.setSSN("01019411122");
    }
}
