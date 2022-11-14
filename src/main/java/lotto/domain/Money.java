package lotto.domain;

public class Money {
    private static final int PRICE_PER_LOTTO = 1_000;
    private static final String ERROR_INDIVISIBLE_NUMBER = "[ERROR] 1000으로 나누어 떨어지는 수를 입력해 주세요.";

    private static final String ERROR_MINIMUM_NUMBER = "[ERROR] 최소 1000원부터 입력할 수 있습니다.";

    private final int inputMoney;

    public Money(int inputMoney) {
        validateDivisibility(inputMoney);
        validateMinimum(inputMoney);
        this.inputMoney = inputMoney;
    }

    public static void validateDivisibility(int inputMoney) {
        if (inputMoney % PRICE_PER_LOTTO != 0) {
            throw new IllegalArgumentException(ERROR_INDIVISIBLE_NUMBER);
        }
    }

    private void validateMinimum(int inputMoney) {
        if (inputMoney < PRICE_PER_LOTTO) {
            throw new IllegalArgumentException(ERROR_MINIMUM_NUMBER);
        }
    }
}
