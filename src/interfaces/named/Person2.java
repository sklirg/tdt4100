package interfaces.named;

/**
 * Created by sklirg on 2/23/14.
 *
 * Class for full name
 *
 */
public class Person2 implements INamed {
    String givenName, familyName, fullName;

    public Person2(String fullName) {
        this.fullName = fullName;
        this.givenName = this.fullName.split("\\s")[0];
        this.familyName = this.fullName.split("\\s")[1];
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
