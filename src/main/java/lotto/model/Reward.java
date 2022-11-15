package lotto.model;

public enum Reward {
    FIFTH("5,000", "3개 일치", 5),
    FOURTH("50,000", "4개 일치", 4),
    THIRD("1,500,000", "5개 일치", 3),
    SECOND("30,000,000", "5개 일치, 보너스 볼 일치", 2),
    FIRST("2,000,000,000", "6개 일치", 1);

    private final String amount;
    private final String condition;
    private final int place;

    Reward(String amount, String condition, int place) {
        this.amount = amount;
        this.condition = condition;
        this.place = place;
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
