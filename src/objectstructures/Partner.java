package objectstructures;

/**
 * Created by sklirg on 2/13/14.
 */
public class Partner {
    String name;
    Partner partner;

    public Partner(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        if (this.partner != null)
            throw new IllegalArgumentException("This person already has a partner.");
        else
            this.partner = partner;
    }

    public void setPartner() {
        if (this.partner.getPartner() != null)
            this.partner.setPartner();
        this.partner = null;
    }

    @Override
    public String toString() {
        return name;
    }

    public static void main(String[] args) {

    }
}
