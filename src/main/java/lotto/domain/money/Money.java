package lotto.domain.money;

public class Money {
    public static final String ERROR_MONEY_IS_NUMBER = "[ERROR] 돈은 숫자만 입력 받을 수 있습니다.";
    public static final String ERROR_MONEY_GREATER_THAN_MIN_NUMBER = "[ERROR] 돈은 최소 금액 보다 커야합니다.";
    public static final String ERROR_MONEY_DIVIDE_MIN_NUMBER = "[ERROR] 돈은 최소금액으로 나누어 떨어져야 합니다.";

    private static final Long MIN_NUMBER = 1000L;
    private final Long amount;

    public Money(final String input) {
        validateInputIsNumber(input);

        Long money = Long.valueOf(input);

        validateMoneyIsGreaterThanMinNumber(money);
        validateMoneyIsDivideMinNUmber(money);
        this.amount = money;

    }

    private void validateMoneyIsDivideMinNUmber(Long money) {
        if (money % MIN_NUMBER != 0) {
            throw new IllegalArgumentException(ERROR_MONEY_DIVIDE_MIN_NUMBER);
        }
    }

    private void validateMoneyIsGreaterThanMinNumber(Long money) {
        if (money < MIN_NUMBER) {
            throw new IllegalArgumentException(ERROR_MONEY_GREATER_THAN_MIN_NUMBER);
        }
    }

    private void validateInputIsNumber(final String input) {
        try {
            Long.valueOf(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR_MONEY_IS_NUMBER);
        }
    }


}
