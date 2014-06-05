package eksamensoving.e2013;

public class TaxPerson extends TaxEntity {
    public static final int LENGTH = 11;

    public TaxPerson(String id, String navn, double skatteprosent) {
        super(id, navn, skatteprosent);
    }

    protected boolean checkId(String id) {
        if (id.length() != LENGTH) return false;
        else {
            for (char c : id.toCharArray())
                if (! Character.isDigit(c)) return false;
            return true;
        }
    }
}
