package YieldMachine;

import java.util.Arrays;
import java.util.List;

public enum Reward {
    FIRST(2_000_000_000, Arrays.asList(6, 0)),
    SECOND(30_000_000, Arrays.asList(5, 1)),
    THIRD(1_500_000, Arrays.asList(5, 0)),
    FOURTH1(50_000, Arrays.asList(4, 0)),
    FOURTH2(50_000, Arrays.asList(4, 1)),
    FIFTH1(5_000, Arrays.asList(3, 0)),
    FIFTH2(5_000, Arrays.asList(3, 1));

    private final Integer prize;
    private final List<Integer> matchingNumber;
    public Integer getReward() {
        return prize;
    }
    private Reward(Integer prize, List<Integer> matchingNumber) {
        this.prize = prize;
        this.matchingNumber = matchingNumber;
    }
}
