package lotto.model;

public class Money {
    private static final String INVALID_MONEY_TYPE = "[ERROR] 금액은 숫자여야 합니다.";
    private static final String MONEY_MUST_NOT_NEGATIVE = "[ERROR] 금액은 음수일 수 없습니다.";
    private static final String MONEY_MUST_MULTIPLE_OF_THOUSAND = "[ERROR] 금액은 1,000원 단위로 나누어 떨어져야 합니다.";
    private final int money;

    public Money(String money) {
        isValidMoneyType(money);
        isPositive(money);
        isDivideByThousand(money);
        this.money = Integer.parseInt(money);
    }

    private void isValidMoneyType(String money) {
        try {
            Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_MONEY_TYPE);
        }
    }

    private void isPositive(String money) {
        if (Integer.parseInt(money) < 0) {
            throw new IllegalArgumentException(MONEY_MUST_NOT_NEGATIVE);
        }
    }

    private void isDivideByThousand(String money) {
        if (Integer.parseInt(money) % 1000 != 0) {
            throw new IllegalArgumentException(MONEY_MUST_MULTIPLE_OF_THOUSAND);
        }
    }
}
