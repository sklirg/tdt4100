package tdt4100.eksamensoving.e2013;

public class YearRegister {
    public final int year;

    public YearRegister(int year) {
        this.year = year;
    }

    public String toString() {
        return String.format("YearRegister %s: %s TaxEntities. Max tax is %s, Min tax is %s, Average tax is %s", year, getNumEntities(), getMaxTax(), getMinTax(), getAvgTax()); // fix
    }
}
