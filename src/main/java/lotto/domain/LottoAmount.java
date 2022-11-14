package lotto.domain;

public class LottoAmount {
    private static final int MIN_COST = 1000;
    private static final double DECIMAL = 1.0;
    private static final String NOT_NUMBER_ERROR = "금액은 숫자만 등록 가능합니다.";
    private static final String NOT_NATURAL_NUMBER_ERROR = "금액은 " + MIN_COST + " 이상이어야 합니다.";
    private static final String NOT_DIVISIBLE_NUMBER_ERROR = "금액은 " + MIN_COST + "단위여야 합니다.";

    private final int amount;

    public LottoAmount(int amount) {
        validateAmount(amount);
        this.amount = amount;
    }

    public int calculateLottoCount() {
        return amount / MIN_COST;
    }

    public double calculateProfit(long prizeSum) {
        return DECIMAL * prizeSum / amount;
    }

    @SuppressWarnings("unused")//
	private int convertToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_ERROR);
        }
    }

    private void validateAmount(int amount) {
        validateMinAmount(amount);
        validateDivisible(amount);
    }

    private void validateMinAmount(int amount) {
        if (amount < MIN_COST) {
            throw new IllegalArgumentException(NOT_NATURAL_NUMBER_ERROR);
        }
    }

    private void validateDivisible(int amount) {
        if (amount % MIN_COST != 0) {
            throw new IllegalArgumentException(NOT_DIVISIBLE_NUMBER_ERROR);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottoAmount)) {
            return false;
        }

        LottoAmount that = (LottoAmount) o;

        return amount == that.amount;
    }

    @Override
    public int hashCode() {
        return amount;
    }
}