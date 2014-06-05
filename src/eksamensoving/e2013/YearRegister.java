package eksamensoving.e2013;

import java.util.*;

public class YearRegister {
    private Collection<TaxFirm> firms;
    private Collection<TaxPerson> persons;

    public final int year;

    public YearRegister(int year) {
        this.year = year;
        this.firms = new HashSet<TaxFirm>();
        this.persons = new HashSet<TaxPerson>();
    }

    public String toString() {
        return String.format("YearRegister %s: %s TaxEntities. Max tax is %s, Min tax is %s, Average tax is %s", year, numEntities, maxTax, minTax, avgTax); // fix
    }

    public boolean containsTaxEntity(String id) {
        if (id.length() == TaxPerson.LENGTH) {
            for (TaxPerson tp : persons) {
                if (tp.getId().equals(id)) return true;
            }
            return false;
        }
        else if (id.length() == TaxFirm.LENGTH) {
            for (TaxFirm tf : firms) {
                if (tf.getId().equals(id)) return true;
            }
            return false;
        }
    }
}
