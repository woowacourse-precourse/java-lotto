package lotto.model;

public class Money {
    public static final String INVALID_MONEY_TYPE = "[ERROR] 금액은 숫자여야 합니다.";
    private final int money;

    public Money(String money) {
        validate(money);
        this.money = Integer.parseInt(money);
    }

    private void validate(String money) {
        try {
            Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_MONEY_TYPE);
        }
    }
}
