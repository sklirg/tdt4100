package eksamensoving.e2013;

public abstract class TaxEntity {

    /*
     * Oppgave 1
     */
    private final String id;
    private String navn;
    private double skatteprosent;
    private long inntekt, formue, fradrag, gjeld;
    public TaxEntity(String id, String navn) {
        this.id = id;
        this.navn = navn;
    }

    /*
     * Oppgave 2
     */
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
}
