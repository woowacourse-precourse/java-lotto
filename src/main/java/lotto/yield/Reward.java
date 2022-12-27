package lotto.yield;

import java.util.Arrays;
import java.util.List;

public enum Reward {
    FIFTH(5_000, Arrays.asList(3, 0), 0),
    FOURTH(50_000, Arrays.asList(4, 0), 1),
    THIRD(1_500_000, Arrays.asList(5, 0), 2),
    SECOND(30_000_000, Arrays.asList(5, 1), 3),
    FIRST(2_000_000_000, Arrays.asList(6, 0), 4);

    private final Integer prize;
    private final List<Integer> matchingNumber;
    private final int index;

    Reward(Integer prize, List<Integer> matchingNumber, int index) {
        this.prize = prize;
        this.matchingNumber = matchingNumber;
        this.index = index;
    }

    public static Reward getReward(List<Integer> numberOfMatching) {
        return Arrays.stream(values())
                .filter(reward -> reward.matchingNumber.equals(numberOfMatching))
                .findAny()
                .orElse(null);
    }

    public Integer getPrize() {
        return prize;
    }

    public Integer getIndex() {
        return index;
    }

    public List<Integer> getMatchingNumber() {
        return matchingNumber;
    }
}