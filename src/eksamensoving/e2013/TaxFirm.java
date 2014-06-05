package eksamensoving.e2013;

public class TaxFirm extends TaxEntity {
    private static final int length = 9;

    protected TaxFirm(String id, String navn, double skatteprosent) {
        super(id,navn,skatteprosent);
    }

    @Override
    protected boolean checkId(String id) {
        if (id.length() != length) return false;
        else {
            for (char c : id.toCharArray()) {
                if (! Character.isDigit(c)) return false;
            }
            return true;
        }
    }
}
