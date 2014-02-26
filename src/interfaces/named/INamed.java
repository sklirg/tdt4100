package interfaces.named;

/**
 * Created by sklirg on 2/23/14.
 */
public interface INamed {
    void setGivenName(String givenName);
    String getGivenName();

    void setFamilyName(String familyName);
    String getFamilyName();

    void setFullName(String fullName);
    String getFullName();
}
