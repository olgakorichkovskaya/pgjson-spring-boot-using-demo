package demo;

public class Price {

    private String currency;

    private double amount;

    public Price() {
    }

    public Price(int i, String dollar) {
        this.amount = i;
        this.currency = dollar;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
