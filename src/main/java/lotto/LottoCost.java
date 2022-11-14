package lotto;

public class LottoCost {
    private static final String ERROR_DIVIDE = "[ERROR] 금액은 1000원 단위로 입력해 주세요.";
    private static final String ERROR_RANGE = "[ERROR] 100원 이상으로 입력해 주세요.";

    private final int cost;

    public LottoCost(int cost) {
        validateDivide(cost);
        validateZero(cost);

        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    private void validateDivide(int cost) {
        if (cost % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_DIVIDE);
        }
    }

    private void validateZero(int cost) {
        if (cost == 0) {
            throw new IllegalArgumentException(ERROR_RANGE);
        }
    }
}
