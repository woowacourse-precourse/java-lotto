package lotto.model;

import java.util.List;

public enum PrizeType {
    FIRST_PRIZE(List.of(6, 0), 2_000_000_000),
    SECOND_PRIZE(List.of(5, 1), 30_000_000),
    THIRD_PRIZE(List.of(5, 0), 1_500_000),
    FOURTH_PRIZE(List.of(4, 0), 50_000),
    FIFTH_PRIZE(List.of(3, 0), 5_000),
    NOTHING(List.of(0, 0), 0);

    private final List<Integer> condition;
    private final int reward;

    PrizeType(List<Integer> condition, int reward) {
        this.condition = condition;
        this.reward = reward;
    }




}
