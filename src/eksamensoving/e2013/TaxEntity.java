package eksamensoving.e2013;

public abstract class TaxEntity {

    /*
     * Oppgave 1
     *
     *
     */
    private final String id;
    private String navn;
    private double skatteprosent;
    private long inntekt, formue, fradrag, gjeld;
    public TaxEntity(String id, String navn) {
        this.id = id;
        this.navn = navn;
    }
}
