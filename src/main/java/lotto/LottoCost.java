package lotto;

import java.util.List;

public class LottoCost {
    private final int cost;

    public LottoCost(int cost) {
        this.cost = cost;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
}
