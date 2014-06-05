package eksamensoving.e2013;

public abstract class TaxEntity {

    // Oppgave 1
    private final String id;
    private String navn;
    private double skatteprosent;
    private long inntekt, formue, fradrag, gjeld;

    // Oppgave 1d
    protected TaxEntity(String id, String navn, double skatteprosent) {
        if (checkId(id))
            this.id = id;
        this.setName(navn);
        this.setPercent(skatteprosent);
    }

    // Oppgave 2
    private boolean checkPositive(long num) {
        return num >= 0;
    }

    // overloading for int
    private boolean checkPositive(int num) {
        return num >= 0;
    }

    private boolean checkPercent(double percent) {
        return (percent >= 0 && percent <= 100);
    }

    private boolean checkName(String name) {
        String alphabet = "abcdefghijklmnopqrstuvwxyzæøå";

        // First, check length of name >= 3.
        if (name.length() < 3)
            return false;
        else {
            int numNorskeChars = 0;
            for (char c : name.toCharArray()) {
                if (numNorskeChars >= 3)
                    return true;
                if (Character.isLetter(c))
                    numNorskeChars++;
            }
        }
        return false;
    }

    protected abstract boolean checkId(String id);


    // Oppgave 1c
    public void setName(String name) {
        if (checkName(name))
            this.navn = name;
        else
            throw new IllegalArgumentException();
    }

    public void setPercent(double percent) {
        if (checkPercent(percent))
            this.skatteprosent = percent;
        else
            throw new IllegalArgumentException();
    }

    // Oppgave 1e
    /*
        Skatt = Inntektsskatt + Formueskatt
        Inntektsskatt = (inntekt – fradrag) * skatteprosent %
        Formueskatt = (formue – gjeld) * 1 %
        Hvis gjelden er større enn formuen blir det ingen formueskatt det året.
        (NB: Tilsvarende for inntekt/fradag for å unngå negativ skatt!!)
     */

    public double getTax() {
        return getCapitalTax() + getIncomeTax();
    }

    // Hjelpemetode for formueskatt
    private double getCapitalTax() {
        return (formue > gjeld) ? ((formue - gjeld) * 0.01) : 0;
    }

    private double getIncomeTax() {
        return (inntekt > fradrag) ? (inntekt - fradrag) * skatteprosent : 0;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return navn;
    }

    public long getInntekt() {
        return inntekt;
    }

    public void setInntekt(long inntekt) {
        if (checkPositive(inntekt)) this.inntekt = inntekt;
    }

    public long getFormue() {
        return formue;
    }

    public void setFormue(long formue) {
        if (checkPositive(formue)) this.formue = formue;
    }

    public long getFradrag() {
        return fradrag;
    }

    public void setFradrag(long fradrag) {
        if (checkPositive(fradrag)) this.fradrag = fradrag;
    }

    public long getGjeld() {
        return gjeld;
    }

    public void setGjeld(long gjeld) {
        if (checkPositive(gjeld)) this.gjeld = gjeld;
    }
}
