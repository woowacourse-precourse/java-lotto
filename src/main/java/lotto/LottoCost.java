package lotto;

public class LottoCost {
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
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위로 입력해 주세요.");
        }
    }

    private void validateZero(int cost) {
        if (cost == 0) {
            throw new IllegalArgumentException("[ERROR] 100원 이상으로 입력해 주세요.");
        }
    }
}
