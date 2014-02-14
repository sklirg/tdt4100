package objectstructures;

/**
 * Created by sklirg on 2/13/14.
 */
public class Partner {
    String name;
    Partner partner = null;

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
        if (partner == null) {
            // Do resetting stuff here
            boolean hasPartner;
            if (this.getPartner() == null) {
                hasPartner = false;
            }
            else {
                hasPartner = true;
            }

            if (hasPartner) {
                Partner other = this.getPartner();
                this.partner = null;
                other.setPartner(null);
            }
            else
                this.partner = null;
        }
        else {
            // New partner as arg; Set new partners
            if (this.partner != null) {
                // this currently has partner
                if ((this == this.partner.getPartner()) && (this.getPartner() != partner)) {
                    // Partners partner is this
                    Partner currentPartner = this.partner;
                    this.partner = null;
                    currentPartner.setPartner(null);


                    Partner swinger = partner;
                    partner.setPartner(this);
                    this.setPartner(swinger);
                }
                /*if (this.partner.getPartner() != null && false)
                {

                    Partner oldPartner = this.partner.getPartner();
                    if (oldPartner.getPartner() != null) {
                        System.out.println("Old partner has partner");
                        Partner oldPartnerPartner = oldPartner.getPartner();
                        oldPartner.setPartner(null);
                        oldPartnerPartner.setPartner(null);
                    }
                    this.partner = null;

                    Partner newPartner = partner;
                    boolean newPartnerHasPartner;

                    if (newPartner.getPartner() != null) {
                        System.out.println("New partner has partner");
                        Partner newPartnerPartner = newPartner.getPartner();
                        newPartner.setPartner(null);
                        newPartnerPartner.setPartner(null);
                    }
                    System.out.println("Setting new partners");
                    /*newPartner.setPartner(this);
                    this.partner = newPartner;*/
                /*}*/
            }
            else {
                // If no current partner
                /*if (false) {
                    Partner oldPartner = this.getPartner();
                    Partner newPartner = partner;
                    this.partner = null;
                    oldPartner.setPartner(null);
                    if (newPartner.getPartner() != null) {
                        newPartner.setPartner(null);
                    }

                    this.setPartner(partner);
                }
                else {*/
                    this.partner = partner;
                    partner.setPartner(this);
                //}
            }
        }
    }

    @Override
    public String toString() {
        return name;
    }

    public static void main(String[] args) {
        Partner far = new Partner("Far");
        Partner mor = new Partner("Mor");
        Partner sw1 = new Partner("Swinger1");
        Partner sw2 = new Partner("Swinger2");

        System.out.println("======initial");
        System.out.println("Fars partner: " + far.getPartner());
        System.out.println("Mors partner: " + mor.getPartner());
        System.out.println("======Setting partners");
        far.setPartner(mor);
        System.out.println("Fars partner: " + far.getPartner());
        System.out.println("Mors partner: " + mor.getPartner());
        System.out.println("======Removing partners");
        far.setPartner(null);
        System.out.println("Fars partner: " + far.getPartner());
        System.out.println("Mors partner: " + mor.getPartner());
        System.out.println("======Setting swingers");
        far.setPartner(mor);
        far.setPartner(sw1);
        System.out.println("Fars partner: " + far.getPartner());
        System.out.println("Mors partner: " + mor.getPartner());
        System.out.println("Sw1 partner: " + sw1.getPartner());
        System.out.println("Sw2 partner: " + sw2.getPartner());
    }
}
