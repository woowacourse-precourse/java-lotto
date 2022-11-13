package lotto.model;

public enum Reward {
    FIFTH("5,000", 5, "3개 일치"),
    FOURTH("50,000", 4, "4개 일치"),
    THIRD("1,500,000", 3, "5개 일치"),
    SECOND("30,000,000", 2, "5개 일치, 보너스 볼 일치"),
    FIRST("2,000,000,000", 1, "6개 일치");

    private final String amount;
    private final String condition;
    private final int place;

    Reward(String amount, int place, String condition) {
        this.amount = amount;
        this.place = place;
        this.condition = condition;
    }

    public String getAmount() {
        return amount;
    }

    public String getCondition() {
        return condition;
    }

    public int getPlace() {
        return place;
    }

    public int getAmountAsInteger() {
        return Integer.parseInt(getAmount().replace(",", ""));
    }
}
