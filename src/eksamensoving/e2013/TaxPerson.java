package eksamensoving.e2013;

public class TaxPerson extends TaxEntity {
    public TaxPerson(String id, String navn, double skatteprosent) {
        super(id, navn, skatteprosent);
    }

    protected boolean checkId(String id) {
        return id.length() == 11;
    }
}
