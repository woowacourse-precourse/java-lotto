package lotto.model;

public enum Reward {
    FIRST("2,000,000,000", 1),
    SECOND("30,000,000", 2),
    THIRD("1,500,000", 3),
    FOURTH("50,000", 4),
    FIFTH("5,000", 5);

    private String amount;
    private int place;

    Reward(String amount, int place) {
        this.amount = amount;
        this.place = place;
    }

    public String getAmount() {
        return amount;
    }

    public int getPlace() {
        return place;
    }

    public int getAmountAsInteger() {
        return Integer.parseInt(this.amount.replace(",", ""));
    }

}
