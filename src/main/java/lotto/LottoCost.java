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
            throw new IllegalArgumentException();
        }
    }

    private void validateZero(int cost) {
        if (cost == 0) {
            throw new IllegalArgumentException();
        }
    }
}
