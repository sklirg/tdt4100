package encapsulation;
import java.util.Date;

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
        if (names.length != 2) {
            throw new IllegalArgumentException("Please input both your first and your last name, and remove middle names.");
        }
        else if (!((isAlpha(names[0])) && (isAlpha(names[1])))) {
            throw new IllegalArgumentException("Your name may only contain letters.");
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
        String[] emailSplit = email.split("@");
        String[] domain;
        int numOfSubDomains;

        String[] emailNames;

        try {
            domain = emailSplit[1].split("\\.");
            numOfSubDomains = domain.length;

            emailNames = emailSplit[0].split("\\.");
        }
        catch (Exception e) {
            throw new IllegalArgumentException("Names or email invalid. Wat.");
        }

        String name = getName();
        String firstName = name.split("\\s+")[0].toLowerCase();
        String lastName = name.split("\\s+")[0].toLowerCase();

        if (emailSplit.length != 2 && !(emailSplit.length == 0)) {
            throw new IllegalArgumentException("Please make sure you typed in your email address correctly. [Error: Multiple @'s]");
        }
        else if (!(isCountry(domain[numOfSubDomains-1])) || !(isAlpha(domain[numOfSubDomains-1]))) {
            throw new IllegalArgumentException("Please use a valid country code.");
        }
        else if (!(emailNames[0].toLowerCase().equals(firstName)) && !(emailNames[1].toLowerCase().equals(lastName))) {
            throw new IllegalStateException("HAHA NAVNET ditt er feil XD");
        }
        else {
            this.email = email;
        }
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        Date now = new Date();
        if (birthday.before(now)) {
            this.birthday = birthday;
        }
        else {
            throw new IllegalArgumentException("Invalid date: Into the future!");
        }
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        if (gender == 'M' || gender == 'F' || gender == '\0') {
            this.gender = gender;
        }
        else {
            throw new IllegalArgumentException("Gender is either [m]ale or [f]emale.");
        }
    }

    public static void main(String[] args) {
        Person p = new Person();
        Date d = new Date(94,0,1); // year + 1900, month, date

        p.setName("Ola Nordmann");
        p.setGender('M');
        p.setEmail("ola.nordmann@ntnu.no");
        p.setBirthday(d);

        System.out.println(p.getName());
        System.out.println(p.getGender());
        System.out.println(p.getEmail());
        System.out.println(p.getBirthday());

    }


}
