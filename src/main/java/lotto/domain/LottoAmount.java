package lotto.domain;

public class LottoAmount {
    private static final int MIN_COST = 1000;
    private static final double DECIMAL = 1.0;

    private final int amount;

    public LottoAmount(final int amount) {
        validateAmount(amount);
        this.amount = amount;
    }
    private void validateAmount(int amount) {
        validateMinAmount(amount);
        validateDivisible(amount);
    }

    private void validateDivisible(int amount) {
        if (amount % MIN_COST != 0) {
            throw new IllegalArgumentException(String.format("[ERROR] 금액은 " + MIN_COST + " 이상이어야 합니다."));
        }
    }

    private void validateMinAmount(int amount) {
        if (amount < MIN_COST) {
            throw new IllegalArgumentException(String.format("[ERROR] 금액은 " + MIN_COST + " 이상이어야 합니다."));
        }
    }
}
