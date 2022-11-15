package lotto.domain;

public class LottoAmount {
    private static final int MIN_COST = 1000;
    private static final double DECIMAL = 1.0;
    private static final String NOT_NATURAL_NUMBER_ERROR = "[ERROR] 금액은 " + MIN_COST + " 이상이어야 합니다.";
    private static final String NOT_DIVISIBLE_NUMBER_ERROR = "[ERROR] 금액은 " + MIN_COST + "단위여야 합니다.";
    private final int money;

    public LottoAmount(int money) {
        validateMoney(money);
        this.money = money;
    }

    public int calculateLottoCount() {
        return money / MIN_COST;
    }

    private void validateMoney(int money) {
        validateMinMoney(money);
        validateDivisible(money);
    }

    private void validateMinMoney(int money) {
        if (money < MIN_COST) {
            throw new IllegalArgumentException(NOT_NATURAL_NUMBER_ERROR);
        }
    }

    private void validateDivisible(int money) {
        if (money % MIN_COST != 0) {
            throw new IllegalArgumentException(NOT_DIVISIBLE_NUMBER_ERROR);
        }
    }

    public double calculateProfit(long prizeSum) {
        return DECIMAL * prizeSum / money * 100;
    }
}
