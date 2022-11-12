package lotto.constant.enumtype;

import java.util.Arrays;
import java.util.List;

public enum LottoMatchCountPrize {
    FIRST_PRIZE(2_000_000_000, Arrays.asList(6, 0)),
    SECOND_PRIZE(30_000_000, Arrays.asList(5, 1)),
    THIRD_PRIZE(1_500_000, Arrays.asList(5, 0)),
    FOURTH_PRIZE(50_000, Arrays.asList(4, 0)),
    FIFTH_PRIZE(5_000, Arrays.asList(3, 0));

    private Integer prize;
    private List<Integer> matchCount;

    LottoMatchCountPrize(Integer prize, List<Integer> matchCount) {
        this.prize = prize;
        this.matchCount = matchCount;
    }

    public String getKey() {
        return name();
    }

    public Integer getPrize() {
        return prize;
    }

    public List<Integer> getMatchCount() {
        return matchCount;
    }
}
