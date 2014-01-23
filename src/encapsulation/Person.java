package encapsulation;
import com.sun.deploy.util.StringUtils;

import java.util.Date;
import java.util.regex.Pattern;

/**
 * Created by Håkon on 23.01.14.
 */
public class Person {
    private String name;
    private String email;
    private Date birthday;
    private char gender;

    private boolean isAlpha(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!(Character.isLetter(s.charAt(i)))) {
                return false;
            }
        }
        return true;
    }

    private boolean isCountry(String tld) {
        return (tld.length() == 2 || tld.length() == 3);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String[] names = name.split("\\s+");
        //Pattern p = Pattern.compile("^[\pL]");
        if (names.length < 2) {
            throw new IllegalArgumentException("Please input both your first and your last name.");
        }
        else if (!((isAlpha(names[0])) && (isAlpha(names[1])))) {
            throw new IllegalArgumentException("Your name may only contains letters.");
        }
        else if (names[0].length() < 2 || names[1].length() < 2) {
            throw new IllegalArgumentException("Your names have to be longer than 2 chars.");
        }
        else {
            this.name = name;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String[] emailSplit = email.split("\\@");
        String[] domain = emailSplit[1].split("\\.");
        int numOfSubDomains = domain.length;
        if (emailSplit.length != 2) {
            throw new IllegalArgumentException("Please make sure you typed in your email address correctly. [Error: Multiple @'s]");
        }
        else if (!(isCountry(domain[numOfSubDomains-1])) || !(isAlpha(domain[numOfSubDomains-1]))) {
            throw new IllegalArgumentException("Please use a valid country code");
        }
        else {
            this.email = email;
        }
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        if (gender == 'm' || gender == 'f' || gender == '\0') {
            this.gender = gender;
        }
        else {
            throw new IllegalArgumentException("Gender is either [m]ale or [f]emale.");
        }
    }

    public static void main(String[] args) {
        Person p = new Person();
        p.setGender('f');
        p.setName("Herp Dærp");
        p.setEmail("hei.u@lol.com");
        System.out.println(p.getEmail());
    }


}
