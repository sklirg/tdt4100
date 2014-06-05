package eksamensoving.e2013;

public class TaxPerson extends TaxEntity {
    private static final int length = 11;

    public TaxPerson(String id, String navn, double skatteprosent) {
        super(id, navn, skatteprosent);
    }

    protected boolean checkId(String id) {
        if (id.length() != length) return false;
        else {
            for (char c : id.toCharArray())
                if (! Character.isDigit(c)) return false;
            return true;
        }
    }
}
