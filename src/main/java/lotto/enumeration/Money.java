package lotto.enumeration;

public enum Money {
    SIX(2_000_000_000, "2,000,000,000원"),
    FIVE_WITH_BONUS(30_000_000, "30,000,000원"),
    FIVE(1_500_000, "1,500,000원"),
    FOUR(50_000, "50,000원"),
    THREE(5_000, "5,000원");

    private final Integer amount;
    private final String type;

    Money(Integer amount, String type) {
        this.amount = amount;
        this.type = type;
    }

    public Integer amount() {
        return amount;
    }

    public String type() {
        return type;
    }
}
