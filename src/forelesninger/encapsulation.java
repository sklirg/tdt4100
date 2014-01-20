package forelesninger;

public class encapsulation {
    private int privateField;
    int defaultField;
    public int publicField;
    private boolean logiskVerdi;

    public boolean isLogiskVerdi() {
        return logiskVerdi;
    }

    public int getPrivateField() {
        return privateField;
    }

    public void setPrivateField(int privateField) {
        this.privateField = privateField;
    }
}
